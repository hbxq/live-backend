package com.xq.live.backend.business.service.impl;

import com.xq.live.backend.business.entity.ShopEnterBo;
import com.xq.live.backend.business.service.ShopEnterService;
import com.xq.live.backend.business.vo.ShopEnterVO;
import com.xq.live.backend.persistence.beans.Shop;
import com.xq.live.backend.persistence.beans.ShopAllocation;
import com.xq.live.backend.persistence.beans.ShopEnter;
import com.xq.live.backend.persistence.beans.User;
import com.xq.live.backend.persistence.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ss on 2018/7/4.
 */
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

        //boolean enter=shopEnterMapper.updateS

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

       /* List<ShopEnter> list = shopEnterMapper.selectByUserId(shopEnter.getUserId());
        if(list==null||list.size()==0){
            return null;
        }
        ShopEnter shopEnter = list.get(list.size()-1);//返回最后一条数据,前面的数据无需做判断
        ShopEnter shopEnter1 = new ShopEnter();
        shopEnter1.setId(shopEnter.getId());
        shopEnter1.setStatus(ShopEnter.SHOP_ENTER_CAN);
        shopEnterMapper.updateByPrimaryKeySelective(shopEnter1);

        shopEnter = shopEnterMapper.selectByPrimaryKey(shopEnter.getId());
        if(shopEnter!=null&&shopEnter.getStatus()!=null&&shopEnter.getStatus()==1){
            Shop shop = new Shop();
            Long userId = shopEnter.getUserId();
            String address = shopEnter.getAddress();
            String businessCate = shopEnter.getBusinessCate();
            String city = shopEnter.getCity();
            BigDecimal locationX = shopEnter.getLocationX();
            BigDecimal locationY = shopEnter.getLocationY();
            String mobile = shopEnter.getMobile();
            String shopName = shopEnter.getShopName();
            String userName = shopEnter.getUserName();
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
            shop.setLogoUrl(shopEnter.getLogoPic());
            shop.setIndexUrl(shopEnter.getDoorPic());
            shop.setShopHours(shopEnter.getShopHours());
            shop.setOtherService(shopEnter.getOtherService());
            shop.setCity(shopEnter.getCity());
            int insert = shopMapper.insert(shop);
            *//**
             * 判断插入shop表是否成功，失败返回-2
             *//*
            if(insert<1){
                throw new RuntimeException("插入shop表失败");
            }
            Long id = null;
            if(shop.getId()!=null) {
                id = shop.getId();//插入得到的shop_id
            }
            User user = new User();
            user.setId(userId);
            user.setShopId(id);
            user.setUserType(2);

            int i = userMapper.updateUserType(user);
            *//**
             * 判断更改用户状态是否成功,失败返回-1
             *//*
            if(i<1){
                throw new RuntimeException("更新用户状态失败");
            }
            User user1 = userMapper.selectByPrimaryKey(userId);
            //给商家加入管理员权限
            ShopCashierVo shopCashierInVo = new ShopCashierVo();
            shopCashierInVo.setCashierId(user1.getId());
            shopCashierInVo.setCashierName(user1.getUserName());
            shopCashierInVo.setShopId(id);
            shopCashierInVo.setIsAdmin(ShopCashier.SHOP_CASHIER_IS_ADMIN);
            shopCashierInVo.setIsDeleted(ShopCashier.SHOP_CASHIER_NO_DELETED);
            shopCashierMapper.insert(shopCashierVo);

            //给商家配置收款方式，先配置已删除,为平台代收的数据，后期可以根据业务来修改
            ShopAllocation shopAllocation = new ShopAllocation();
            shopAllocation.setShopId(id);
            shopAllocation.setIsDelete(ShopAllocation.SHOP_ALLOCATION_IS_DELETED);
            shopAllocation.setPaymentMethod(ShopAllocation.SHOP_ALLOCATION_DS);
            shopAllocationMapper.insert(shopAllocation);
        }else {
            throw new RuntimeException("用户尚未入驻或审批未通过");//判断用户是否入驻且审批通过
        }*/
        return 0;
    }

    @Override
    public List<ShopEnter> selectByUserId(Long id) {
        return null;
    }

    @Override
    public int updateById(ShopEnterVO record) {
        return 0;
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
