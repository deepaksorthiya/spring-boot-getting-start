package com.example.service;

import com.example.entity.Post;
import com.example.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with id " + id + " not found"));
    }

    @Transactional
    public Post createPost(Post post) {
        Post newPost = postRepository.save(post);
        return newPost;
    }

    @Transactional
    public Post deletePost(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with id " + id + " not found"));
        postRepository.delete(post);
        return post;

    }

    @Transactional
    public Post updatePost(int id, Post post) {
        Post originalPost = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post with id " + id + " not found"));
        if (id != post.getId()) {
            throw new IllegalArgumentException("Invalid Post");
        }
        post.setId(originalPost.getId());
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }
}
