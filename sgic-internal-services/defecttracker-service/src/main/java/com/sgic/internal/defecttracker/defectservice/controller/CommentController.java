//package com.sgic.internal.defecttracker.defectservice.controller;
//
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.eureka.common.api.enums.RestApiResponseStatus;
//import com.eureka.common.api.response.ApiResponse;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.CommentData;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.CommentDtoConverter;
//import com.sgic.internal.defecttracker.defectservice.controller.dto.mapper.CommentMapper;
//import com.sgic.internal.defecttracker.defectservice.entities.Comments;
//import com.sgic.internal.defecttracker.defectservice.services.impl.CommentServiceImp;
//
//@CrossOrigin
//@RestController
//public class CommentController {
//
//	private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImp.class);
//
//	@Autowired
//	CommentDtoConverter commentDtoConverter;
//
//	@Autowired
//	private CommentMapper commentMapper;
//
//	
//	//create comments for defects
//	 	@PostMapping(value = "/comments")
//	public ResponseEntity<Object> createComments(@RequestBody CommentData commentData) {
//		LOG.info("starting creating comments");
//		commentMapper.createComments(commentData);
//		LOG.info(" comments saved");
//		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
//
//	}
//
//	//get all comments for the particular defect
//	@GetMapping(value = "/comments/{defectId}")
//	public List<Comments> getListComments(@PathVariable String defectId) {
//
//		LOG.info("comments getting");
//		return commentMapper.getCommentsById(defectId);
//	}
//
//	//get all comments for the defects
//	@GetMapping(value = "/commentAll")
//	public List<CommentData> getAllComments() {
//
//		LOG.info("comments getting");
//		return commentMapper.getAllById();
//
//	}
//	
//	//delete defects
//	@DeleteMapping(value="/delete/{commentId}")
//	public void deleteById(@PathVariable Long commentId) {
//		LOG.info("Deleting Comment");
//		commentMapper.deleteById(commentId);
//		LOG.info("Comment Deleted" );
//	}
//
//}
