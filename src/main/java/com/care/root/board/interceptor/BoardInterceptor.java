package com.care.root.board.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.member.session_name.MemberSessionName;

public class BoardInterceptor extends HandlerInterceptorAdapter implements MemberSessionName {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 실행 컨트롤 전");
		HttpSession session = request.getSession();
		if (session.getAttribute(LOGIN) == null) {
			//response.sendRedirect("login");
			response.setContentType("text/html; charset=utf-8");// 클라이언트로 전달할 타입
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 해라');"+
					//" location.href='/root/member/login';</script>");
					" location.href='"+ request.getContextPath() +"/member/login';</script>");
			
			return false;
		}
		return true;
	}

	

}