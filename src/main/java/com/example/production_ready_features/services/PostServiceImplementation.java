package com.example.production_ready_features.services;

import com.example.production_ready_features.dto.PostDto;
import com.example.production_ready_features.entities.PostEntity;
import com.example.production_ready_features.exceptions.ResourceNotFound;
import com.example.production_ready_features.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream().map(postEntity -> modelMapper.map(postEntity, PostDto.class)).toList();
    }

    @Override
    public PostDto createNewPost(PostDto inputpost) {

        PostEntity postEntity = modelMapper.map(inputpost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).
                orElseThrow(() -> new ResourceNotFound("Post not found with id"+ postId));
        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputpost, Long postId) {
        PostEntity olderpost = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFound("Post not found with id"+ postId));
        inputpost.setId(postId);
        modelMapper.map(inputpost, olderpost);
        PostEntity savedEntity = postRepository.save(olderpost);
        return modelMapper.map(savedEntity, PostDto.class);
    }
}
