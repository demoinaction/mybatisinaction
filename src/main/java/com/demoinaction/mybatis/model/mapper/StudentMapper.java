package com.demoinaction.mybatis.model.mapper;

import com.demoinaction.mybatis.model.po.StudentPo;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.scripting.LanguageDriver;

@Mapper
public interface StudentMapper {

    StudentPo findByName(String name);

    Integer insertStudent(StudentPo student);
}
