package com.example.production_ready_features.services;

import com.example.production_ready_features.dto.PostDto;

import java.util.List;


public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputpost);

    PostDto getPostById(Long postId);
}
