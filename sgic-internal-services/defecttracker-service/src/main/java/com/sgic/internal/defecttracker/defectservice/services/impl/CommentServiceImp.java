package com.sgic.internal.defecttracker.defectservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defectservice.entities.Comments;
import com.sgic.internal.defecttracker.defectservice.repositories.CommentRepository;
import com.sgic.internal.defecttracker.defectservice.services.CommentService;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	//create comments for defects
	@Override
	public Comments createComments(Comments comments) {
		Comments responseComments = commentRepository.save(comments);
		return responseComments;
	}

	//get all comments for the particular defect
	@Override
	public List<Comments> getCommentsById(String defectId) {
		return commentRepository.findCommentsByDefectId(defectId);
	}

	//get all comments for the defects
	@Override
	public List<Comments> getAllComments() {
		return commentRepository.findAll();
	}

	//delete defects
	@Override
	public void deleteById(Long commentId) {
		commentRepository.deleteById(commentId);

	}

}
