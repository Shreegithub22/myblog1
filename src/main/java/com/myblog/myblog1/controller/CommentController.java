package com.myblog.myblog1.controller;

import com.myblog.myblog1.payload.CommentDto;
import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // http://localhost:8082/api/comment?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam long postId){
        CommentDto dto = commentService.createPost(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}/postId/{postId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto ,@PathVariable long id,
                                                    @PathVariable long postId ){
        CommentDto dto=commentService.updateComment(commentDto,id,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
