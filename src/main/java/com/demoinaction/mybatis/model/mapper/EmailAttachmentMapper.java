package com.demoinaction.mybatis.model.mapper;

import com.demoinaction.mybatis.model.po.EmailAttachmentPo;
import com.demoinaction.mybatis.model.po.StudentPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailAttachmentMapper {

    EmailAttachmentPo findByFileId(String fileId);

    Integer insertEmailAttachment(EmailAttachmentPo email);
}
