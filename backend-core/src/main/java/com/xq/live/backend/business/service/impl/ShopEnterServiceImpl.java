package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopEnterBo;
import com.xq.live.backend.business.entity.UserBo;
import com.xq.live.backend.business.service.ShopEnterService;
import com.xq.live.backend.business.vo.ShopAllocationVO;
import com.xq.live.backend.business.vo.ShopCashierVO;
import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.business.vo.UserVO;
import com.xq.live.backend.persistence.beans.*;
import com.xq.live.backend.persistence.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 商家入驻审核业务
 * Created by ss on 2018/7/4.
 */
@Service
public class ShopEnterServiceImpl implements ShopEnterService{

    @Autowired
    private ShopEnterMapper shopEnterMapper;
    @Autowired
    private ShopCashierMapper shopCashierMapper;
    @Autowired
    private ShopAllocationMapper shopAllocationMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private UserMapper userMapper;



    @Override
    public ShopEnterBo insert(ShopEnterBo entity) {
        return null;
    }

    @Override
    public void insertList(List<ShopEnterBo> entities) {
    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(ShopEnterBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(ShopEnterBo entity) {
        return false;
    }

    @Override
    public ShopEnterBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public ShopEnterBo getOneByEntity(ShopEnterBo entity) {
        return null;
    }

    @Override
    public List<ShopEnterBo> listAll() {
        return null;
    }

    @Override
    public List<ShopEnterBo> listByEntity(ShopEnterBo entity) {
        return null;
    }

    @Override
    @Transactional
    public Integer addShop(ShopEnterVO shopEnter) {
        List<ShopEnter> list = shopEnterMapper.selectByUserId(shopEnter.getUserId());
        if(list==null||list.size()==0){
            return null;
        }
        ShopEnter Enter = list.get(list.size()-1);//返回最后一条数据,前面的数据无需做判断
        ShopEnterVO shopEnter1 = new ShopEnterVO();
        shopEnter1.setId(Enter.getId());
        shopEnter1.setStatus(Enter.SHOP_ENTER_CAN);
        shopEnterMapper.updateById(shopEnter1);
        Enter = shopEnterMapper.selectById(Enter.getId());

        if(Enter!=null&&Enter.getStatus()!=null&&Enter.getStatus()==1){
            Shop shop = new Shop();
            Long userId = Enter.getUserId();
            String address = Enter.getAddress();
            String businessCate = Enter.getBusinessCate();
            String city = Enter.getCity();
            BigDecimal locationX = Enter.getLocationX();
            BigDecimal locationY = Enter.getLocationY();
            String mobile = Enter.getMobile();
            String shopName = Enter.getShopName();
            String userName = Enter.getUserName();
            shop.setAddress(address);
            shop.setLocationX(locationX);
            shop.setLocationY(locationY);
            boolean flag = isMobile(mobile);//判断是否是手机号
            if(flag==true){
                shop.setMobile(mobile);
            }else{
                shop.setPhone(mobile);
            }

            shop.setShopName(shopName);
            shop.setUserId(userId);
            shop.setBusinessCate(businessCate);
            shop.setLogoUrl(Enter.getLogoPic());
            shop.setIndexUrl(Enter.getDoorPic());
            shop.setShopHours(Enter.getShopHours());
            shop.setOtherService(Enter.getOtherService());
            shop.setCity(Enter.getCity());
            int insert = shopMapper.insertShop(shop);

            /*
            判断插入shop表是否成功，失败返回-2
            */
            if(insert<1){
                throw new RuntimeException("插入shop表失败");
            }
            Long id = null;
            if(shop.getId()!=null) {
                id = shop.getId();//插入得到的shop_id
            }
            UserVO user = new UserVO();
            user.setId(userId);
            user.setShopId(id);
            user.setUserType(2);

            int i = userMapper.updateUserType(user);

           /*
             判断更改用户状态是否成功,失败返回-1
             */
            if(i<1){
                throw new RuntimeException("更新用户状态失败");
            }
            User user1 = userMapper.selectByid(userId);
            //给商家加入管理员权限
            ShopCashierVO shopCashierInVo = new ShopCashierVO();
            shopCashierInVo.setCashierId(user1.getId());
            shopCashierInVo.setCashierName(user1.getUserName());
            shopCashierInVo.setShopId(id);
            shopCashierInVo.setIsAdmin(ShopCashier.SHOP_CASHIER_IS_ADMIN);
            shopCashierInVo.setIsDeleted(ShopCashier.SHOP_CASHIER_NO_DELETED);
            shopCashierMapper.insertCashier(shopCashierInVo);

            //给商家配置收款方式，先配置已删除,为平台代收的数据，后期可以根据业务来修改
            ShopAllocationVO shopAllocation = new ShopAllocationVO();
            shopAllocation.setShopId(id);
            shopAllocation.setIsDelete(ShopAllocation.SHOP_ALLOCATION_IS_DELETED);
            shopAllocation.setPaymentMethod(ShopAllocation.SHOP_ALLOCATION_DS);
            shopAllocationMapper.insertAllShop(shopAllocation);
        }else {
            throw new RuntimeException("用户尚未入驻或审批未通过");//判断用户是否入驻且审批通过
        }
        return 0;
    }


    @Override
    public int updateById(ShopEnterVO record) {
        Integer i=shopEnterMapper.updateById(record);
        if (i==null||i<0){
            return 0;
        }
        return i;
    }

    @Override
    public PageInfo<ShopEnterBo> selectBytemp(ShopEnterVO vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<ShopEnter> list=shopEnterMapper.selectBytemp(vo);
        if (list.size()<1||list==null){
            return null;
        }
        List<ShopEnterBo> shopEnterBos=new ArrayList<ShopEnterBo>();
        for (ShopEnter r : list) {
            shopEnterBos.add(new ShopEnterBo(r));
        }
        PageInfo bean = new PageInfo<ShopEnter>(list);
        bean.setList(shopEnterBos);
        return bean;
    }

    @Override
    public ShopEnterBo seedetail(ShopEnterVO record) {
        List<ShopEnter> list=shopEnterMapper.selectBytemp(record);
        if (list.size()<1||list==null){
            return null;
        }
        ShopEnterBo shopEnterBo = new ShopEnterBo(list.get(0));
        return shopEnterBo;
    }

    /**
     * 判断是否是手机号
     * @param str
     * @return
     */
    public boolean isMobile(String str) {
        String regExp = "^[1][3,4,5,7,8][0-9]{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
