package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	
	@GetMapping("boardAllList")
	public String boardAllList(Model model) {
		bs.selectAllBoardList(model);
		return "board/boardAllList";
	}
	@GetMapping ("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	@PostMapping("writeSave")
	public void writeSave(MultipartHttpServletRequest mul,
							HttpServletResponse response,
							HttpServletRequest request) throws Exception{
		String meseeage = bs.writeSave(mul, request);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(meseeage);
		
	}
	@GetMapping("contentView")
	public String contentView (@RequestParam int writeNo, Model model ) {
		bs.contentView(writeNo, model); // 넘어온 값을 서비스로 넘겨줌
		return "board/contentView";
	}

	@GetMapping("download")
	public void downLoad(@RequestParam String imageFileName,
						HttpServletResponse response) throws Exception{
		response.addHeader("Content-disposition",
				"attachment;imageFileName"+imageFileName);
		File file = new File(BoardFileService.IMAGE_REPO+"/"+imageFileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
}




