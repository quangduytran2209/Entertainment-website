package dao.impl;

import java.util.List;

import Entity.Video;
import dao.AbstractDao;
import dao.VideoDao;

public class VideoDaoImpl extends AbstractDao<Video> implements VideoDao {

	@Override
	public Video findById(Integer id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql =  "SELECT o FROM Video o WHERE o.href =?0";
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public void create(Video video) {
		super.Create(video);
	}

	@Override
	public void update(Video video) {
		super.update(video);
	}

	@Override
	public void delete(Video video) {		
		video.setIsActive(Boolean.FALSE); 
	}
	
}
