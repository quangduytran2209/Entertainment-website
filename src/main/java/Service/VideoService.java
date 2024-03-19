package Service;

import java.util.List;

import Entity.Video;

public interface VideoService {
	Video findById(Integer id);
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAll(int pageNumber, int pageSize);
	void create(Video video);
	void update(Video video);
	void delete(Video video);
}
