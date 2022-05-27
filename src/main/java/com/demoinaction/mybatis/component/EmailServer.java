package com.demoinaction.mybatis.component;

import com.demoinaction.mybatis.model.bo.EmailAttachment;
import org.springframework.stereotype.Component;

import java.io.File;


public interface EmailServer {
    String saveEmailAttach(String from,String fileName,byte[] fileBytes);

    EmailAttachment getEmailAttach(String fileId, String from);

    String getEmailAttach(String directory,String fileId,String from) throws Exception;
}
