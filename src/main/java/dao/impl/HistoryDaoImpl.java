package dao.impl;

import java.util.List;

import Entity.History;
import Entity.User;
import dao.AbstractDao;
import dao.HistoryDao;

public class HistoryDaoImpl extends AbstractDao<History> implements HistoryDao {

	@Override
	public List<History> findByUser(String Username) {
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.video.isActive = 1"
				+ "ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, Username);
	}

	@Override
	public List<History> findByUserisLiked(String username) {
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.isLiked = 1"
				+ "AND o.video.isActive = 1"
				+ "ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String sql =  "SELECT o FROM History o  WHERE o.user.id = ?0 AND o.video.id = ?1";
		return super.findOne(History.class, sql, userId, videoId);
	}

	@Override
	public History create(History history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public History udpate(History history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(History history) {
		// TODO Auto-generated method stub
		return;
	}
}
