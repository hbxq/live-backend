package com.xq.live.backend.persistence.mapper;

import com.xq.live.backend.persistence.beans.Attachment;
import com.xq.live.backend.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AttachmentMapper extends BaseMapper<Attachment> {
    int insertForId(Attachment record);

    List<Attachment> selectByIds(Map<String, Object> paramsMap);
}
