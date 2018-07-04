package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.WriteBo;
import com.xq.live.backend.business.service.SoWriteOffService;
import com.xq.live.backend.business.vo.SoWriteOffInVo;
import com.xq.live.backend.persistence.beans.SoWriteOff;
import com.xq.live.backend.persistence.mapper.SoWriteOffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @date
 * @copyright:hbxq
 **/
@Service
public class SoWriteOffServiceImpl implements SoWriteOffService {

    @Autowired
    private SoWriteOffMapper soWriteOffMapper;

    @Override
    public WriteBo insert(WriteBo entity) {
        return null;
    }

    @Override
    public void insertList(List<WriteBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(WriteBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(WriteBo entity) {
        return false;
    }

    @Override
    public WriteBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public WriteBo getOneByEntity(WriteBo entity) {
        return null;
    }

    @Override
    public List<WriteBo> listAll() {
        return null;
    }

    @Override
    public List<WriteBo> listByEntity(WriteBo entity) {
        return null;
    }

    @Override
    public PageInfo<WriteBo> findSoForShop(SoWriteOffInVo vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SoWriteOff> soWriteOffs=soWriteOffMapper.selectofflist(vo);
        if (CollectionUtils.isEmpty(soWriteOffs)) {
            return null;
        }
        List<WriteBo> writeBos =new ArrayList<WriteBo>();
        BigDecimal a = new BigDecimal(1);
        BigDecimal allPrice = new BigDecimal(0);
        for (int i=0;i<soWriteOffs.size();i++){
            soWriteOffs.get(i).setSoType(soWriteOffs.get(i).getSo().getSoType());
            if (soWriteOffs.get(i).getSo().getShopId()!=null&&soWriteOffs.get(i).getSo().getSoType()==1){//食典券訂單
                soWriteOffs.get(i).getSo().setSellPrice(a);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }else {//商家訂單和平台訂單
                if (soWriteOffs.get(i).getSo().getSellPrice()==null){
                    soWriteOffs.get(i).getSo().setSellPrice(new BigDecimal(0));
                    soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                }
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }
            if (soWriteOffs.get(i).getSo().getSoPrice()==null){
                soWriteOffs.get(i).getSo().setSoPrice(new BigDecimal(0));
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }
            /*System.out.println("getSoPrice" + soWriteOffs.get(i).getSoPrice());
            allPrice.add(soWriteOffs.get(i).getSoPrice());
            System.out.println("allPrice" + allPrice);
            allPrice.add(new BigDecimal(10));
            System.out.println("allPrice" + allPrice);*/
            writeBos.add(new WriteBo(soWriteOffs.get(i)));
        }
        PageInfo bean = new PageInfo<SoWriteOff>(soWriteOffs);
        bean.setList(writeBos);
        return bean;
    }

    @Override
    public WriteBo findSoShop(SoWriteOffInVo vo) {
        List<SoWriteOff> soWriteOffs=soWriteOffMapper.selectofflist(vo);
        if (CollectionUtils.isEmpty(soWriteOffs)) {
            return null;
        }
        BigDecimal a = new BigDecimal(1);
        BigDecimal allPrice = new BigDecimal(0);
        for (int i=0;i<soWriteOffs.size();i++){
            soWriteOffs.get(i).setSoType(soWriteOffs.get(i).getSo().getSoType());
            if (soWriteOffs.get(i).getSo().getShopId()!=null&&soWriteOffs.get(i).getSo().getSoType()==1){//食典券訂單
                soWriteOffs.get(i).getSo().setSellPrice(a);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }else {//商家訂單和平台訂單
                if (soWriteOffs.get(i).getSo().getSellPrice()==null){
                    soWriteOffs.get(i).getSo().setSellPrice(new BigDecimal(0));
                    soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                }
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }
            if (soWriteOffs.get(i).getSo().getSoPrice()==null){
                soWriteOffs.get(i).getSo().setSoPrice(new BigDecimal(0));
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }
            //System.out.println("getSoPrice" + soWriteOffs.get(i).getSoPrice());
            allPrice=allPrice.add(soWriteOffs.get(i).getSoPrice());
            //System.out.println("allPrice" + allPrice);
        }
        System.out.println("allPrice" + allPrice);
        SoWriteOff soWriteOff = new SoWriteOff();
        soWriteOff.setTotalService(allPrice);

        WriteBo bo= new WriteBo(soWriteOff);
        return bo;
    }

    @Override
    @Transactional
    public Integer updateByShopId(SoWriteOffInVo vo) {
        Integer i=soWriteOffMapper.updateByShopId(vo);
        if (i<1){
            return 0;
        }
        return i;
    }
}
