package com.myblog.myblog1.service;

import com.myblog.myblog1.payload.PostDto;

import java.util.List;

public interface PostService{
    public PostDto createPost(PostDto postDto);
    public PostDto getById(long id);
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);


}
