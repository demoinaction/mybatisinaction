package com.demoinaction.mybatis.model.po;

import lombok.Data;

@Data
public class StudentPo {
    private Integer id;
    private String name;
    private Integer age;
    private Integer classId;
    private String fileType;
    private String fileName;
    private byte[] file;
}
