package com.myblog.myblog1.controller;

import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8082/api/post?id=1
    @GetMapping
    public ResponseEntity<PostDto> getById(@RequestParam long id){
        PostDto dto = postService.getById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


    //http://localhost:8082/api/post/all?pageNo=0&pageSize=3&sortBy=title&sortDir=desc
    @GetMapping("/all")
    public List<PostDto> getAllPosts(
            @RequestParam(name="sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name="sortDir",required = false,defaultValue = "id") String sortDir,
            @RequestParam(name="pageNo",required = false,defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "3") int pageSize
            ){
        List<PostDto> dto =postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return dto;
    }


}
