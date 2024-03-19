package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

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

@WebServlet(urlPatterns = { "/index", "/favorites", "/history",})
public class HomeControllwe extends HttpServlet{
	
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService =  new HistoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/favorites":
			doGetFavorites(session ,req, resp);
			break;
		case "/history":
			doGetHistory(session, req, resp);
			break;
		}
		
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
	
	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
	
	private void doGetFavorites(HttpSession session ,HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		List<History> histories = historyService.findByUserisLiked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/favorites.jsp").forward(req, resp);
	}
	
	private void doGetHistory(HttpSession session, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		List<History> histories = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/history.jsp").forward(req, resp);
	}
}

	