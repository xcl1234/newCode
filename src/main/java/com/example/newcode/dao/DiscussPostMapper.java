package com.example.newcode.dao;

import com.example.newcode.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //如果只有一个参数，且要在<if>里使用，就要起别名
    int selectDiscussPostRows(@Param("userId") int userId);


}
