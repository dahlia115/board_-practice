package com.care.root.board.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.Message.MessageDTO;

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

	@Override
	public String saveFile(MultipartFile file) {
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
		String sysFileName =
				simpl.format(calendar.getTime()) + file.getOriginalFilename();
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		
	
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
	
		return sysFileName;
	}
	public void deleteImage(String imageFileName) {//db값을 삭제했다면 해당 이미지도 지운다
		File file = new File(IMAGE_REPO+"/"+imageFileName);
		file.delete();
	}

	@Override
	public String getMessage(MessageDTO dto) {
		String message = null;
		String path = dto.getRequest().getContextPath();
		if(dto.getResult() == 1) {
			message = "<script>alert('"+dto.getSuccessMessage()+"');";
			message += "location.href='"+path+dto.getSuccessURL()+"'</script>";
		}else {
			message = "<script>alert('"+dto.getFailMessage()+"');";
			message += "location.href='"+path+dto.getFailURL()+"'</script>";
		}
		return message;
	}
}  







