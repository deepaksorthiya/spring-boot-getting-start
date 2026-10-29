package com.example;

import com.example.entity.Post;
import com.example.entity.PostComment;
import com.example.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class InitialDataLoader implements ApplicationRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(InitialDataLoader.class);

    private final PostRepository postRepository;

    public InitialDataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws ExecutionException, InterruptedException {
        LOGGER.info("InitialDataLoader Running in thread: {}", Thread.currentThread());
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Post post = new Post("title" + i, "content" + i);
            post.addComment(
                    new PostComment("My first review for Post" + i)
            );
            post.addComment(
                    new PostComment("My second review for Post" + i)
            );
            post.addComment(
                    new PostComment("My third review for Post" + i)
            );
            posts.add(post);
        }
        List<Post> saved = postRepository.saveAll(posts);
        LOGGER.info("Total Saved Posts {} Running in thread: {}", saved.size(), Thread.currentThread());
        System.out.println("########################");
    }
}
