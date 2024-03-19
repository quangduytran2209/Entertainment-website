package Service.impl;

import java.sql.Timestamp;
import java.util.List;

import Entity.History;
import Entity.User;
import Entity.Video;
import Service.HistoryService;
import Service.VideoService;
import dao.HistoryDao;
import dao.impl.HistoryDaoImpl;

public class HistoryServiceImpl implements HistoryService {

	private HistoryDao dao;
	private VideoService videoService =  new VideoServiceImpl();
	
	public HistoryServiceImpl() {
		dao = new HistoryDaoImpl();
	}

	@Override
	public List<History> findByUser(String Username) {
		return dao.findByUser(Username);
	}

	@Override
	public List<History> findByUserisLiked(String username) {
		return dao.findByUserisLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existHistory == null) {
			existHistory.setUser(user);
			existHistory.setVideo(video);
			existHistory.setIsLike(Boolean.FALSE);
			existHistory.setViewedDate(new Timestamp(System.currentTimeMillis()));
			return dao.create(existHistory);
		}
		return existHistory;
	}

	@Override
	public boolean updateLikeOrUnLike(User user, String videohref) {
		Video video = videoService.findByHref(videohref);
		History existHistory =  findByUserIdAndVideoId(user.getId(), video.getId());
		
		if(existHistory.getIsLike()==Boolean.FALSE) {
			existHistory.setIsLike(Boolean.TRUE);
			existHistory.setLikeDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLike(Boolean.FALSE);
			existHistory.setLikeDate(null);
		}
		History updateHistory = dao.udpate(existHistory);
		return updateHistory != null?true:false;
	}
	

	
}
