package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public static final String IMAGE_REPO="C:\\LJW\\SPRING\\image_repo";
	public String getMessage(int result, HttpServletRequest request);
	public String saveFile(MultipartFile file);
}
