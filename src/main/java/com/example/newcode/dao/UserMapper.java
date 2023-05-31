package com.example.newcode.dao;

import com.example.newcode.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);


}
