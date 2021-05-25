package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	public void selectAllBoardList(Model model);
	public String writeSave(MultipartHttpServletRequest mul,
									HttpServletRequest request);
	public void contentView (int writeNo, Model model );
	
	public String boardDelete(int writeNo,
					String imageFileName,
					HttpServletRequest request);
	
	public String modify(MultipartHttpServletRequest mul,HttpServletRequest request);
}

