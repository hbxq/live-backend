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
    /*
    * 食典券*/
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
                if(s.getShopId()!=null&&s.getSoType()==1){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }else if (s.getShopId()!=null&&s.getSoType()==2){//商家訂單
                    if (s.getSkuId()!=null){
                        s.setSoPrice(s.getSoAmount().subtract(s.getSellPrice()));
                    }else {
                        s.setSoPrice(s.getSoAmount());
                    }
                }/*else if (s.getShopId()==null&& s.getSoType()==1){//平臺訂單
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
            SoBos.add(new SoBo(s));
        }
        PageInfo bean = new PageInfo<So>(sos);
        bean.setList(SoBos);
        return bean;
    }

    /*
    * 商家订单*/
    @Override
    public PageInfo<SoBo> findSoForShops(SoConditionVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<So> soss=soMapper.findSoForShops(vo);
        if (CollectionUtils.isEmpty(soss)) {
            return null;
        }
        List<SoBo> SoBos = new ArrayList<>();
        BigDecimal allPrice = BigDecimal.ZERO;
        for (So s:soss){
            if (s.getPaymentMethod()==2){//平臺代收
                if (s.getShopId()!=null&&s.getSoType()==2){//商家訂單
                    if (s.getSkuId()!=null&&s.getIsDeleted()==0){
                        s.setSoPrice(s.getSoAmount().subtract(s.getSellPrice()));
                    }else {
                        s.setSoPrice(s.getSoAmount());
                    }
                }
            }else if (s.getPaymentMethod()==1){//商家自收
            }
            if (s.getSoPrice()==null){
                s.setSoPrice(new BigDecimal(0));
            }
            allPrice=allPrice.add(allPrice.add(s.getSoPrice()));
            SoBos.add(new SoBo(s));
        }
        System.out.println(SoBos);
        PageInfo bean = new PageInfo<So>(soss);
        bean.setList(SoBos);
        return bean;
    }

    @Override
    public SoBo findSoShop(SoConditionVO vo) {
        List<So> sos = soMapper.findSoForShop(vo);
        List<So> soss=soMapper.findSoForShops(vo);

        BigDecimal allPrice = BigDecimal.ZERO;
        BigDecimal bilPrice = BigDecimal.ZERO;
        BigDecimal noBilPrice = BigDecimal.ZERO;
        if (soss!=null&&soss.size()>0){
            sos.addAll(soss);
        }

        for (So s:sos){
            if (s.getPaymentMethod()==2){//平臺代收
                if (s.getSkuId()!=null){
                    if(s.getSkuType()==3){//食典券訂單
                        s.setSellPrice(BigDecimal.ONE);
                        s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                    }
                }
                if (s.getShopId()!=null&&s.getSoType()==2){//商家訂單
                    if (s.getSkuId()!=null){
                        s.setSoPrice(s.getSoAmount().subtract(s.getSellPrice()));
                    }else {
                        s.setSoPrice(s.getSoAmount());
                    }
                }
            }else if (s.getPaymentMethod()==1){//商家自收
                if(s.getSkuType()==3){//食典券訂單
                    s.setSellPrice(BigDecimal.ONE);
                    s.setSoPrice(s.getSoAmount().subtract(BigDecimal.ONE));
                }
            }
            if (s.getSoPrice()==null){
                s.setSoPrice(BigDecimal.ZERO);
            }
            allPrice=allPrice.add(s.getSoPrice());
            if (s.getIsDui()==0){
                noBilPrice=noBilPrice.add(s.getSoPrice());
            }
            if (s.getIsDui()==1){
                bilPrice=bilPrice.add(s.getSoPrice());
            }
        }
        So so = new So();
        System.out.println(allPrice);
        so.setSoAllPrice(allPrice);
        so.setSoBillPrice(bilPrice);
        so.setSoNoBillPrice(noBilPrice);
        SoBo soprice=new SoBo(so);
        return soprice;
    }

    /**
     * 根据soid批量更改商家訂單
     * @param list
     * @return
     */
    @Override
    @Transactional
    public Integer updateBySO(List<SoConditionVO> list) {
        Integer i=soMapper.updateBySO(list);
        if (i<1){
            return 0;
        }
        return i;
    }

    /**
     * 根据shopid和时间批量更改商家訂單和食典券
     * @param list
     * @return
     */
    @Override
    public Integer updateByShopId(SoConditionVO list){
        /*食典券*/
        List<So> sos = soMapper.findSoForIsDui(list);
        /*商家订单*/
        List<So> shopForIsDui = soMapper.findShopForIsDui(list);
        Integer all = 0;
        if (shopForIsDui!=null&&shopForIsDui.size()>0){
            Integer shopIds = soMapper.updateByShopIds(list);
            if (shopIds < 1){
                throw new RuntimeException("商家订单状态修改失败!");
            }
            all=all+shopIds;
        }
        if (sos!=null&&sos.size()>0){
            Integer i = soMapper.updateByShopId(list);
            if (i < 1) {
                throw new RuntimeException("食典券订单状态修改失败!");
            }
            all=all+i;
            //修改食典券结算状态
            Integer bill=soMapper.updateByShopIdBill(list);
            if (bill<1){
                throw new RuntimeException("食典券订单结算状态修改失败!");
            }
        }
        return all;
    }

    /**
     * 修改用户余额
     * @param list
     * @return
     */
    @Override
    public Integer updateUseract(SoConditionVO list){
        Long userid = userMapper.selectByshopid(list.getShopId());
        UserAccount userAccount = userAccountMapper.findAccountByUserId(userid);
        AccountLogConditionVO accountLogConditionVO = custom(userAccount,list);

        Integer ac=accountLogMapper.billLog(accountLogConditionVO);
        if (ac < 1) {
            throw new RuntimeException("账户余额日志添加失败!");
        }
        return ac;
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
        userAccountConditionVO.setVersionNo(userAccount.getVersionNo());
        userAccountConditionVO.setAccountAmount(accountLog.getPreAmount().subtract(accountLog.getOperateAmount()));
        Integer i=userAccountMapper.amoutForUserid(userAccountConditionVO);
        if (i < 1) {
            throw new RuntimeException("账户余额修改失败!");
        }
        return accountLog;
    }
}
