package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Tweet;

public interface TweetRepository extends JpaRepository <Tweet, Long>{
	@Query(value = "SELECT * FROM tweeter_tweet WHERE user_id = ?1", nativeQuery = true)
	public List <Tweet> getTweetListByUserId(Long id);
	
	@Query("SELECT t FROM Tweet t WHERE t.title LIKE ?1% ORDER BY t.created DESC")
	public List <Tweet> getTweetListByTitleStart(String titleStart);
}