package com.example.newcode;

import com.example.newcode.dao.DiscussPostMapper;
import com.example.newcode.dao.UserMapper;
import com.example.newcode.entity.DiscussPost;
import com.example.newcode.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewCodeApplicationTests {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDiscussPostsMapper(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost post:discussPosts)
            System.out.println(post);

        int i = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(i);
    }

    @Test
    public void testUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

}
