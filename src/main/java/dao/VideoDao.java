package dao;

import java.util.List;

import Entity.Video;

public interface VideoDao {
	Video findById(Integer id);
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAll(int pageNumber, int pageSize);
	void create(Video video);
	void update(Video video);
	void delete(Video video);
}
