package com.myblog.myblog1.service.impl;


import com.myblog.myblog1.entity.Post;
import com.myblog.myblog1.exception.ResourceNotFoundException;
import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.repository.PostRepository;
import com.myblog.myblog1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {



    @Autowired
    private PostRepository postRepository;
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    public PostDto createPost(PostDto postDto){
        Post post =new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost=postRepository.save(post);


        PostDto dto = new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }


    public PostDto getById(long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id:"+id)
        );
        PostDto dtos = mapToDto(post);
        return dtos;
    }

    public List<PostDto> getAllPosts(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> all = pagePost.getContent();
        List<PostDto> dtos = all.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
        
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        return dto;
    }




}
