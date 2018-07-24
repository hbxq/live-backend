package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.SoWriteOffBo;
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
 * 核销
 * @author
 * @date
 * @copyright:hbxq
 **/
@Service
public class SoWriteOffServiceImpl implements SoWriteOffService {

    @Autowired
    private SoWriteOffMapper soWriteOffMapper;

    @Override
    public SoWriteOffBo insert(SoWriteOffBo entity) {
        return null;
    }

    @Override
    public void insertList(List<SoWriteOffBo> entities) {

    }

    @Override
    public boolean removeByPrimaryKey(Long primaryKey) {
        return false;
    }

    @Override
    public boolean update(SoWriteOffBo entity) {
        return false;
    }

    @Override
    public boolean updateSelective(SoWriteOffBo entity) {
        return false;
    }

    @Override
    public SoWriteOffBo getByPrimaryKey(Long primaryKey) {
        return null;
    }

    @Override
    public SoWriteOffBo getOneByEntity(SoWriteOffBo entity) {
        return null;
    }

    @Override
    public List<SoWriteOffBo> listAll() {
        return null;
    }

    @Override
    public List<SoWriteOffBo> listByEntity(SoWriteOffBo entity) {
        return null;
    }

    @Override
    public PageInfo<SoWriteOffBo> findSoForShop(SoWriteOffInVo vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<SoWriteOff> soWriteOffs=soWriteOffMapper.selectofflist(vo);
        if (CollectionUtils.isEmpty(soWriteOffs)) {
            return null;
        }
        List<SoWriteOffBo> soWriteOffBos =new ArrayList<SoWriteOffBo>();
        BigDecimal a = new BigDecimal(1);
        BigDecimal allPrice = new BigDecimal(0);
        for (int i=0;i<soWriteOffs.size();i++){
            soWriteOffs.get(i).setSoType(soWriteOffs.get(i).getSo().getSoType());
            if (soWriteOffs.get(i).getSo().getShopId()!=null&&soWriteOffs.get(i).getSo().getSoType()==1&&soWriteOffs.get(i).getSkuId()!=406){//食典券訂單
                soWriteOffs.get(i).getSo().setSellPrice(a);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }else  if(soWriteOffs.get(i).getSkuId()==406&&soWriteOffs.get(i).getSo().getSoType() == 1) {//套餐券
                soWriteOffs.get(i).getSo().setSellPrice(a);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
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
            soWriteOffBos.add(new SoWriteOffBo(soWriteOffs.get(i)));
        }
        PageInfo bean = new PageInfo<SoWriteOff>(soWriteOffs);
        bean.setList(soWriteOffBos);
        return bean;
    }

    @Override
    public SoWriteOffBo findSoShop(SoWriteOffInVo vo) {
        List<SoWriteOff> soWriteOffs=soWriteOffMapper.selectofflist(vo);
        if (CollectionUtils.isEmpty(soWriteOffs)) {
            return null;
        }
        BigDecimal allPrice =BigDecimal.ZERO;
        for (SoWriteOff swo :soWriteOffs){
            swo.setSoType(swo.getSo().getSoType());
            if (swo.getSo().getShopId()!=null&&swo.getSo().getSoType()==1&&swo.getSkuId()!=406){//食典券訂單
                swo.getSo().setSellPrice(BigDecimal.ONE);
                swo.setSellPrice(swo.getSo().getSellPrice());
                swo.getSo().setSoPrice(swo.getSo().getSellPrice());
                swo.setSoPrice(swo.getSo().getSoPrice());
            }else  if(swo.getSkuId()==406&&swo.getSo().getSoType() == 1) {//套餐券
                swo.getSo().setSellPrice(BigDecimal.ONE);
                swo.setSellPrice(swo.getSo().getSellPrice());
                swo.getSo().setSoPrice(swo.getSo().getSellPrice());
                swo.setSoPrice(swo.getSo().getSoPrice());
            }else {//商家訂單和平台訂單
                if (swo.getSo().getSellPrice()==null){
                    swo.getSo().setSellPrice(BigDecimal.ZERO);
                    swo.setSellPrice(swo.getSo().getSellPrice());
                }
                swo.setSellPrice(swo.getSo().getSellPrice());
                swo.getSo().setSoPrice(swo.getSo().getSellPrice());
                swo.setSoPrice(swo.getSo().getSoPrice());
            }
            if (swo.getSo().getSoPrice()==null){
                swo.getSo().setSoPrice(BigDecimal.ZERO);
                swo.setSoPrice(swo.getSo().getSoPrice());
            }
            allPrice=allPrice.add(swo.getSoPrice());
        }

        for (int i=0;i<soWriteOffs.size();i++){
            soWriteOffs.get(i).setSoType(soWriteOffs.get(i).getSo().getSoType());
            if (soWriteOffs.get(i).getSo().getShopId()!=null&&soWriteOffs.get(i).getSo().getSoType()==1&&soWriteOffs.get(i).getSkuId()!=406){//食典券訂單
                soWriteOffs.get(i).getSo().setSellPrice(BigDecimal.ONE);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).setSoPrice(soWriteOffs.get(i).getSo().getSoPrice());
            }else  if(soWriteOffs.get(i).getSkuId()==406&&soWriteOffs.get(i).getSo().getSoType() == 1) {//套餐券
                soWriteOffs.get(i).getSo().setSellPrice(BigDecimal.ONE);
                soWriteOffs.get(i).setSellPrice(soWriteOffs.get(i).getSo().getSellPrice());
                soWriteOffs.get(i).getSo().setSoPrice(soWriteOffs.get(i).getSo().getSellPrice());
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
            allPrice=allPrice.add(soWriteOffs.get(i).getSoPrice());
        }
        SoWriteOff soWriteOff = new SoWriteOff();
        soWriteOff.setTotalService(allPrice);
        SoWriteOffBo bo= new SoWriteOffBo(soWriteOff);
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
