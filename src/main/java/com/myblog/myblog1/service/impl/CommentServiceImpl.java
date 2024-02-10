package com.myblog.myblog1.service.impl;

import com.myblog.myblog1.entity.Comment;
import com.myblog.myblog1.entity.Post;
import com.myblog.myblog1.exception.ResourceNotFoundException;
import com.myblog.myblog1.payload.CommentDto;
import com.myblog.myblog1.repository.CommentRepository;
import com.myblog.myblog1.repository.PostRepository;
import com.myblog.myblog1.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private PostRepository postRepository;      //this is for postId



    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }
//    @Autowired
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;







    public CommentDto createPost(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id:"+postId)
        );
        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto=new CommentDto();
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        dto.setId(savedComment.getId());

        return dto;
    }


    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

    public CommentDto updateComment(CommentDto commentDto, long id, long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for ID:" + id));
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment not found for ID:" + id));

        Comment com=mapToEntity(commentDto);

        com.setId(comment.getId());
        com.setEmail(commentDto.getEmail());
        com.setText(commentDto.getText());
        com.setPost(post); //this is for getting post_id
        Comment updatedComment = commentRepository.save(com);

        CommentDto dto = mapToDto(updatedComment);
        return dto;
    }

















    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }


    CommentDto mapToDto(Comment comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }


}
