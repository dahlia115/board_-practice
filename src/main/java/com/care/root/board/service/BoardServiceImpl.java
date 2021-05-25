package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.member.session_name.MemberSessionName;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	public void selectAllBoardList(Model model) {
		model.addAttribute("boardList",mapper.selectAllBoardList());
	}
	@Override
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		HttpSession session = request.getSession();
		dto.setId((String) session.getAttribute( MemberSessionName.LOGIN));
	
		MultipartFile file = mul.getFile("image_file_name");

		BoardFileService bfs = new BoardFileServiceImpl();
		
		if(file.isEmpty()) { //파일이 비어있으면 true
			dto.setImageFileName("nan");
		}else { //파일이 존재하는 경우
			dto.setImageFileName( bfs.saveFile(file) ); 
		}
		/*		 
		int result = mapper.writeSave(dto);
		String message = bfs.getMessage(result, request);//성공인지 실패인지 메세지
		return message;
		 */
		return bfs.getMessage(mapper.writeSave(dto), request);
	}
	@Override
	public void contentView(int writeNo, Model model) {//디비에 접근해 번호와 일치하는 데이터를 가져온다
		model.addAttribute("personalData", mapper.contentView(writeNo));
		upHit(writeNo);
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
}






