package dao;

import java.util.List;

import Entity.History;

public interface HistoryDao {
	List<History> findByUser(String Username);
	List<History> findByUserisLiked(String username);
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	History create(History history);
	History udpate(History history);
	void delete(History history);
}
