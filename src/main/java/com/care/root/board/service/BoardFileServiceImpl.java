package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

public class BoardFileServiceImpl implements BoardFileService {

	@Override
	public String getMessage(int result, HttpServletRequest request) {
		String message=null;
		if(result == 1) {
			message = "<script>alert('추가 되었습니다');";
			message += "location.href='/root/board/boardAllList';</script>";
		}else {
			message = "<script>alert('문제가 발생했습니다');";
			message += "location.href='/root/board/writeForm';</script>";			
		}
		return message;
	}

}
