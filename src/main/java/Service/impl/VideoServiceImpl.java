package Service.impl;

import java.util.List;

import javax.persistence.Entity;

import Entity.Video;
import Service.VideoService;
import dao.VideoDao;
import dao.impl.VideoDaoImpl;

public class VideoServiceImpl implements VideoService {

	private VideoDao dao;
	
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();
	}
	
	@Override
	public Video findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public void create(Video video) {
		video.setIsActive(null);;
		video.setViews(0);
		video.setShares(0);
		dao.create(video);
	}

	@Override
	public void update(Video video) {
		dao.update(video);
	}

	@Override
	public void delete(Video video) {
		video.setIsActive(Boolean.FALSE);
		dao.update(video);
	}
	
}
