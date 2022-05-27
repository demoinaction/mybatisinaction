package com.demoinaction.mybatis.component.impl;

import com.demoinaction.mybatis.component.EmailServer;
import com.demoinaction.mybatis.model.bo.EmailAttachment;
import com.demoinaction.mybatis.model.mapper.EmailAttachmentMapper;
import com.demoinaction.mybatis.model.po.EmailAttachmentPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component("emailServer")
public class EmailServerImpl implements EmailServer {
    @Autowired
    private EmailAttachmentMapper emailAttachmentMapper;

    @Override
    public String saveEmailAttach(String from,String fileName,byte[] fileBytess) {
        String fileId=String.valueOf(System.currentTimeMillis());
        try{
            EmailAttachmentPo emailAttachmentPo=new EmailAttachmentPo();
            emailAttachmentPo.setFileId(fileId);
            emailAttachmentPo.setSendFrom(from);
            emailAttachmentPo.setFileName(fileName);
            emailAttachmentPo.setFile(fileBytess);
            Integer integer = emailAttachmentMapper.insertEmailAttachment(emailAttachmentPo);
            if (integer>0){
                return fileId;
            }
            else {
                return null;
            }
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public EmailAttachment getEmailAttach(String fileId, String from) {
        try {
            EmailAttachmentPo emailAttachment = emailAttachmentMapper.findByFileId(fileId);
            if (emailAttachment!=null) {
                if (emailAttachment.getSendFrom().equals(from)) {
                    EmailAttachment attachment=new EmailAttachment();
                    attachment.setFile(emailAttachment.getFile());
                    attachment.setFileId(emailAttachment.getFileId());
                    attachment.setFileName(emailAttachment.getFileName());
                    attachment.setFrom(emailAttachment.getSendFrom());
                    return attachment;
                }
            }
            return null;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public String getEmailAttach(String directory,String fileId,String from) throws Exception
    {
        EmailAttachment emailAttach = getEmailAttach(fileId, from);
        if (emailAttach!=null){
            Path path= Paths.get(directory+"/"+fileId);
            Path pathCreate= Files.createDirectories(path);
            File newfile=new File(directory+emailAttach.getFildDirection());
            newfile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream (newfile);
            fileOutputStream.write(emailAttach.getFile());
            fileOutputStream.flush();
            return directory+emailAttach.getFildDirection();
        }
        return null;
    }
}
