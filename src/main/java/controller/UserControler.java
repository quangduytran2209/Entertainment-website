package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.SetAttribute;

import Entity.User;
import Entity.Video;
import Service.UserService;
import Service.VideoService;
import Service.impl.UserSeriveImpl;
import Service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet( urlPatterns =  { "/login","/logout","/register" , "/forgotPass" })
public class UserControler extends HttpServlet{
	
	UserService uservice = new UserSeriveImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/logout":
			HttpSession session = req.getSession();
			doGetLogOut(session ,req, resp);
			break;
		case "/register":
			doGetRegister(req, resp);
			break;
		case "/forgotPass":
			doGetForgotPass(req, resp);
			break;
		}
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login": 
			doPostLogin(session, req, resp);
			break;
		case "/register": 
			doPostRegister(session, req, resp);
			break;
		case "/forgotPass":
			doGetForgotPass(req, resp);
			break;
		}
	}
	
	
	protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
	}
	protected void doPostLogin( HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user  = uservice.login(username,password);
		
		if(user != null) {
			session.setAttribute("currentUser", user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("login");
		}
	}
	protected void doGetLogOut( HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute("currentUser");
		resp.sendRedirect("index");
	}
	protected void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
	}
	
	protected void doPostRegister(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("confirmpassword");
		String email = req.getParameter("email");
		
		if(!password.equalsIgnoreCase(cpassword)) {
			req.setAttribute("message", "mật khẩu không trùng khớp vui lòng điền lại form");
			resp.sendRedirect("register");
		}else {
			uservice.Create(username, password, email);
			User user =  uservice.findByUsername(username);
			session.setAttribute("currentUser", user);
			resp.sendRedirect("index");
		}
	
	}
	
	protected void doGetForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/forgot-pass.jsp").forward(req, resp);
	}
	
	
}
