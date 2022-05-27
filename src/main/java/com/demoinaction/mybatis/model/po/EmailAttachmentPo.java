package com.demoinaction.mybatis.model.po;

import lombok.Data;

@Data
public class EmailAttachmentPo {
    private Integer id;
    private String sendFrom;
    private String fileId;
    private String fileName;
    private byte[] file;
}
