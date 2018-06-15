package pl.coderslab.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	private GenericController<Tweet> tweetController;
	@Autowired
	private UserRepository userRepo;
	
	@ModelAttribute("users")
	public List <User> getUserList () {
		return userRepo.findAll();
	}
	
	@GetMapping("/add")
	public String addUserGet (Model model) {
		return tweetController.addGet(model, new Tweet (), "tweet", "tweet");
	}
	
	@PostMapping("/add")
	public String addUserPost (Model model, @Valid Tweet tweet, BindingResult result) {
		return tweetController.addPost(model, tweet, result, "tweet", "success");
	}
}