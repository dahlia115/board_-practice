package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.Message.MessageDTO;

public interface BoardFileService {
	public static final String IMAGE_REPO="C:\\LJW\\SPRING\\image_repo";
	public String getMessage(int result, HttpServletRequest request);
	public String saveFile(MultipartFile file);
	
	public void deleteImage(String imageFileName);
	
	public String getMessage(MessageDTO dto);
}
