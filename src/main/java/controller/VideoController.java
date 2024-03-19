package controller;

import java.io.IOException;

import Entity.History;
import Entity.User;
import Entity.Video;
import Service.HistoryService;
import Service.VideoService;
import Service.impl.HistoryServiceImpl;
import Service.impl.VideoServiceImpl;
import constant.SessionAttribute;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/video")
public class VideoController extends HttpServlet{
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");
		HttpSession session =  req.getSession(); 
		switch (actionParam) {
		case "watch":
			dogetWatch(session, href, req, resp);
			break;
		case "like":
			dogetLike(session, href, req, resp);
			break;
		}
	}

	public void dogetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video =  videoService.findByHref(href);
		req.setAttribute("video", video);
		
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		if(currentUser != null) {
			History history = historyService.create(currentUser, video);
			req.setAttribute("flagLikeBtn", history.getIsLike());
		}
		req.getRequestDispatcher("/views/user/Video-Detail.jsp").forward(req, resp);
	}
	public void dogetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("applicantion/json");
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnLike(currentUser, href);
		if(result = true) {
			resp.setStatus(204);
		}else {
			resp.setStatus(400);
		}
	}
}
