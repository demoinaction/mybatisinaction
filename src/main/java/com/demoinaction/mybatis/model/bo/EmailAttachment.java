package com.demoinaction.mybatis.model.bo;

import lombok.Data;

@Data
public class EmailAttachment {
    private byte[] file;
    private String fileName;
    private String fileId;
    private String from;
    public String getFildDirection(){
        return "/"+fileId+"/"+fileName;
    }
}
