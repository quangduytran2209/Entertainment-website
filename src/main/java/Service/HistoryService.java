package Service;

import java.util.List;

import Entity.History;
import Entity.User;
import Entity.Video;

public interface HistoryService {
	List<History> findByUser(String Username);
	List<History> findByUserisLiked(String username);
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	History create(User user, Video video);
	boolean  updateLikeOrUnLike(User user, String videohref);
}
