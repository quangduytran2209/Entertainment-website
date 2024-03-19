package Entity;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "history")
public class History {
	
	@Id
	@Column(name="id")
	Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name ="userId", referencedColumnName = "id")
	User user;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="videoId", referencedColumnName = "id")
	Video video;
	
	@Column(name="videoDate")
	@CreationTimestamp
	Date viewedDate;
	@Column(name="isLiked")
	Boolean isLiked;
	@Column(name="likeDate")
	Date likeDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Date getViewedDate() {
		return viewedDate;
	}
	public void setViewedDate(Date viewedDate) {
		this.viewedDate = viewedDate;
	}
	public Boolean getIsLike() {
		return isLiked;
	}
	public void setIsLike(Boolean isLike) {
		this.isLiked = isLike;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}