package com.demoinaction.mybatis;

import com.demoinaction.mybatis.component.EmailServer;
import com.demoinaction.mybatis.model.bo.EmailAttachment;
import com.demoinaction.mybatis.model.mapper.EmailAttachmentMapper;
import com.demoinaction.mybatis.model.mapper.StudentMapper;
import com.demoinaction.mybatis.model.po.EmailAttachmentPo;
import com.demoinaction.mybatis.model.po.StudentPo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class MybatisinactionApplication {

    public static void main(String[] args) throws Exception{

        SpringApplication.run(MybatisinactionApplication.class, args);

        EmailServer emailServer = SpringContextUtil.getBean(EmailServer.class);

        Path path = Paths.get("D:\\workspace\\mybatisinaction\\蚂蚁链.pdf");
        byte[] data = Files.readAllBytes(path);
        EmailAttachmentPo emailAttachmentPo=new EmailAttachmentPo();
        emailAttachmentPo.setFile(data);
        emailAttachmentPo.setFileName("蚂蚁链.pdf");
        emailAttachmentPo.setSendFrom("pengjinqiang@mszq.com");
        emailAttachmentPo.setFileId(String.valueOf(System.currentTimeMillis()));
        String fileId = emailServer.saveEmailAttach("pengjinqiang@mszq.com","蚂蚁链.pdf",data);

        System.out.println(fileId);

        String emailAddress = emailServer.getEmailAttach("D:/workspace/mybatisinaction",fileId, "pengjinqiang@mszq.com");

        System.out.println(emailAddress);
        System.out.println("end");
    }





}
