package pl.coderslab.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tweeter_tweet")
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min = 5, max = 50)
	private String title;
	@NotBlank
	@Size(max = 160)
	private String tweetText;
	@Column(updatable = false)
	@CreationTimestamp
	private Date created;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	public Tweet() {
		super();
	}

	public Tweet(String title, String tweetText, User user) {
		super();
		this.title = title;
		this.tweetText = tweetText;
		this.user = user;
	}

	public Tweet(long id, String title, String tweetText, User user) {
		super();
		this.id = id;
		this.title = title;
		this.tweetText = tweetText;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return String.format("Tweet [id=%s, title=%s, tweetText=%s, created=%s, user=%s]", id, title, tweetText,
				created, user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}