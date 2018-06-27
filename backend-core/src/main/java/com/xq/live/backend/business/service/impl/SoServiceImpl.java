package com.xq.live.backend.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.live.backend.business.entity.ShopBo;
import com.xq.live.backend.business.entity.SoBo;
import com.xq.live.backend.business.service.SoService;
import com.xq.live.backend.business.vo.SoConditionVO;
import com.xq.live.backend.persistence.beans.So;
import com.xq.live.backend.persistence.beans.SoDetail;
import com.xq.live.backend.persistence.beans.SoShopLog;
import com.xq.live.backend.persistence.mapper.SoDetailMapper;
import com.xq.live.backend.persistence.mapper.SoMapper;
import com.xq.live.backend.persistence.mapper.SoShopLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
}
