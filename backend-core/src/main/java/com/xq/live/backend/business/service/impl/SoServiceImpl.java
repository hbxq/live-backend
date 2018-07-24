package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.service.SoService;
import com.xq.live.backend.business.vo.AccountLogConditionVO;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.business.vo.UserAccountConditionVO;
import com.xq.live.backend.persistence.beans.*;
import com.xq.live.backend.persistence.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 订单实现类
 * Created by lipeng on 2018/6/26.
 */
@Service
public class SoServiceImpl implements SoService{
    @Autowired
    private SoMapper soMapper;

    @Autowired
    private SoDetailMapper soDetailMapper;

    @Autowired
    private SoShopLogMapper soShopLogMapper;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private AccountLogMapper accountLogMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<SoBo> findPageBreakByCondition(SoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<So> sos = soMapper.findPageBreakByCondition(vo);
        if (CollectionUtils.isEmpty(sos)) {
            return null;
        }
        List<SoBo> SoBos = new ArrayList<>();
        for (So r : sos) {
            if(r.getSoType()==So.SO_TYPE_SJ){
                SoShopLog soShopLog = new SoShopLog();
                soShopLog.setSoId(r.getId());
                soShopLog.setOperateType(r.getSoStatus());
                soShopLog = soShopLogMapper.selectOne(soShopLog);
                int i =0 ;
            }else {
                SoDetail soDetail = new SoDetail();
                soDetail.setSoId(r.getId());
                soDetail = soDetailMapper.selectOne(soDetail);
                r.setSoDetail(soDetail);
            }
            SoBos.add(new SoBo(r));
        }
        PageInfo bean = new PageInfo<So>(sos);
        bean.setList(SoBos);
        return bean;
    }
    @Override
    public PageInfo<SoBo> findSoForShop(SoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<So> sos = soMapper.findSoForShop(vo);
        if (CollectionUtils.isEmpty(sos)) {
            return null;
        }
        List<SoBo> SoBos = new ArrayList<>();
        BigDecimal allPrice = BigDecimal.ZERO;
        for (So s:sos){
            if (s.getPaymentMethod()==2){//平臺代收
                s.setSoPrice(s.getSoAmount());
                if(s.getShopId()!=null&&s.getSoType()==1){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }
            }else if (s.getPaymentMethod()==1){//商家自收
                if(s.getShopId()!=null&&s.getSoType()==1){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }
            }
            if (s.getSoPrice()==null){
                s.setSoPrice(new BigDecimal(0));
            }
            allPrice=allPrice.add(allPrice.add(s.getSoPrice()));
            SoBos.add(new SoBo(s));
        }
        PageInfo bean = new PageInfo<So>(sos);
        bean.setList(SoBos);
        return bean;
    }

    @Override
    public SoBo findSoShop(SoConditionVO vo) {
        List<So> sos = soMapper.findSoForShop(vo);
        BigDecimal allPrice = BigDecimal.ZERO;
        if (CollectionUtils.isEmpty(sos)) {
            return null;
        }
        for (So s:sos){
            s.setSoPrice(s.getSoAmount());
            if (s.getPaymentMethod()==2){//平臺代收
                if(s.getShopId()!=null&&s.getSoType()==1){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }/*else if (s.getShopId()!=null&&s.getSoType()==2){//商家訂單
                    s.setSoPrice(s.getSoAmount());
                }else if (s.getShopId()==null&& s.getSoType()==1){//平臺訂單
                    s.setSoPrice(s.getSoAmount());
                }*/
            }else if (s.getPaymentMethod()==1){//商家自收
                if(s.getShopId()!=null&&s.getSoType()==1){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }
            }
            if (s.getSoPrice()==null){
                s.setSoPrice(new BigDecimal(0));
            }
            allPrice=allPrice.add(allPrice.add(s.getSoPrice()));
        }
        So so = new So();
        so.setSoAllPrice(allPrice);
        SoBo soprice=new SoBo(so);
        return soprice;
    }

    @Override
    @Transactional
    public Integer updateBySO(List<SoConditionVO> list) {
        Integer i=soMapper.updateBySO(list);
        if (i<1){
            return 0;
        }
        return i;
    }

    @Override
    @Transactional
    public Integer updateByShopId(SoConditionVO list) throws RuntimeException{

        Integer i = soMapper.updateByShopId(list);
        if (i < 1) {
            throw new RuntimeException("订单状态修改失败!");
        }
        Long userid = userMapper.selectByshopid(list.getShopId());
        UserAccount userAccount = userAccountMapper.findAccountByUserId(userid);
        AccountLogConditionVO accountLogConditionVO = custom(userAccount,list);
        Integer ac=accountLogMapper.billLog(accountLogConditionVO);
        if (ac < 1) {
            throw new RuntimeException("账户余额日志添加失败!");
        }
        return i;
    }

    @Override
    public SoBo detail(SoConditionVO vo) {
        Assert.notNull(vo, "SoConditionVO不能为空");
        So so = new So();
        so.setId(vo.getId());
        So result = soMapper.selectOne(so);
        return new SoBo(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SoBo insert(SoBo entity) {
        return null;
    }

    @Override
    public void insertList(List<SoBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(SoBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(SoBo entity) {

        return false;
    }

    @Override
    public SoBo getByPrimaryKey(Long primaryKey) {
        Assert.notNull(primaryKey, "PrimaryKey不可为空！");
        So so = soMapper.selectByPrimaryKey(primaryKey);
        return null == so ? null : new SoBo(so);
    }

    @Override
    public SoBo getOneByEntity(SoBo entity) {
        Assert.notNull(entity, "So不可为空！");
        So so = soMapper.selectOne(entity.getSo());
        return null == so ? null : new SoBo(so);
    }

    @Override
    public List<SoBo> listAll() {
        List<So> sos = soMapper.selectAll();

        if (CollectionUtils.isEmpty(sos)) {
            return null;
        }
        List<SoBo> soBos = new ArrayList<>();
        for (So so : sos) {
            soBos.add(new SoBo(so));
        }
        return soBos;
    }

    @Override
    public List<SoBo> listByEntity(SoBo soBo) {
        Assert.notNull(soBo, "So不可为空！");
        List<So> sos = soMapper.select(soBo.getSo());
        if (CollectionUtils.isEmpty(sos)) {
            return null;
        }
        List<SoBo> soBos = new ArrayList<>();
        for (So su : sos) {
            soBos.add(new SoBo(su));
        }
        return soBos;
    }

    @Transactional
    public AccountLogConditionVO custom(UserAccount userAccount,SoConditionVO vo)  throws RuntimeException{
        AccountLogConditionVO accountLog = new AccountLogConditionVO();
        accountLog.setAccountId(userAccount.getId());
        accountLog.setUserName(userAccount.getUserName());
        accountLog.setPreAmount(userAccount.getAccountAmount());
        SoBo pageInfo = findSoShop(vo);
        accountLog.setOperateAmount(pageInfo.getSoAllPrice());
        accountLog.setAfterAmount(accountLog.getPreAmount().subtract(accountLog.getOperateAmount()));
        accountLog.setOperateType(AccountLog.OPERATE_TYPE_PAYOUT);
        StringBuilder remark = new StringBuilder();
        remark.append("商家对账");//标题
        remark.append("交易对象:"+userAccount.getUserName());//交易对象
        remark.append("对账的时间范围: 开始:" + vo.getBeginTime() + "结束:" + vo.getEndTime());//内容，交易金额的时间段
        remark.append("交易金额:" + accountLog.getOperateAmount());//金额
        accountLog.setRemark(remark.toString());
        accountLog.setUserId(userAccount.getUserId());
        accountLog.setAccountName(userAccount.getAccountName());
        System.out.println(accountLog.getRemark());

        //更改用户余额
        UserAccountConditionVO userAccountConditionVO = new UserAccountConditionVO();
        userAccountConditionVO.setUserId(userAccount.getUserId());
        userAccountConditionVO.setAccountAmount(accountLog.getPreAmount().subtract(accountLog.getOperateAmount()));
        Integer i=userAccountMapper.amoutForUserid(userAccountConditionVO);
        if (i < 1) {
            throw new RuntimeException("账户余额修改失败!");
        }
        return accountLog;
    }
}
