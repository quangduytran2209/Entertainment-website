package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@Column(name = "title")
	String title;
	@Column(name = "href")
	String href;
	@Column(name = "poster")
	String poster;
	@Column(name = "views")
	Integer views;
	@Column(name = "share")
	Integer share;
	@Column(name = "description")
	String description;
	@Column(name = "isActive")
	Boolean isActive;
	
	@OneToMany(mappedBy = "video")
	List<History> history;
	public Video() {
		super();
	}
	public Video(String title, String href, String poster, Integer views, Integer shares, String description,
			Boolean idActive) {
		super();
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.share = share;
		this.description = description;
		this.isActive = idActive;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getShares() {
		return share;
	}
	public void setShares(Integer share) {
		this.share = share;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean idActive) {
		this.isActive = idActive;
	}
	
}
