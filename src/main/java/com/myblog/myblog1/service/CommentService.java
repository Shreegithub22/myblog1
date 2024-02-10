package com.myblog.myblog1.service;

import com.myblog.myblog1.payload.CommentDto;

public interface CommentService {
   public CommentDto createPost(CommentDto commentDto, long postId);

   void deleteComment(long id);

   public CommentDto updateComment(CommentDto commentDto, long id, long postId);
}
