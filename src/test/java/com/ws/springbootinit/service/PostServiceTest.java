package com.ws.springbootinit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ws.springbootinit.model.dto.post.PostQueryRequest;
import com.ws.springbootinit.model.entity.Post;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 帖子服务测试
 *
 * @author <a href="https://github.com/liws">程序员鱼皮</a>
 * @from <a href="https://ws.icu">编程导航知识星球</a>
 */
@SpringBootTest
class PostServiceTest {

    @Resource
    private PostService postService;

    @Test
    void searchFromEs() {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setUserId(1L);
        Page<Post> postPage = postService.searchFromEs(postQueryRequest);
        Assertions.assertNotNull(postPage);
    }

}