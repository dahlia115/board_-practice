package com.care.root.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardService {
	public void selectAllBoardList(Model model, int num);
	public String writeSave(MultipartHttpServletRequest mul,
									HttpServletRequest request);
	public void contentView (int writeNo, Model model );
	//삭제
	public String boardDelete(int writeNo,
					String imageFileName,
					HttpServletRequest request);
	//수정
	public String modify(MultipartHttpServletRequest mul,HttpServletRequest request);
	//답글
	public void addReply(BoardRepDTO dto);

	//답글
	public List<BoardRepDTO> getRepList(int write_group);
}

