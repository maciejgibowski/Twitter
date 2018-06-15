package pl.coderslab.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private TweetRepository tweetRepo;
	@Autowired
	private GenericController<User> genericController;
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{id}/tweets")
	@ResponseBody
	public String getTweetsByUserId (@PathVariable long id) {
		return tweetRepo.getTweetListByUserId(id).toString();
	}
	
	@GetMapping("/search-tweets")
	@ResponseBody
	public String getTweetsByTitle (@RequestParam String titleStart) {
		return tweetRepo.getTweetListByTitleStart(titleStart).toString();
	}
	
	@GetMapping("/all")
	public String getAllUsersTable (Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "userView";
	}
	
	@GetMapping("/add")
	public String addUserGet (Model model) {
		return genericController.addGet(model, new User (), "user", "user");
	}
	
	@PostMapping("/add")
	public String addUserPost (Model model, @Valid User user, BindingResult result) {
		return genericController.addPost(model, user, result, "user", "success");
	}
	
	@GetMapping("/edit")
	public String editGet(@RequestParam long id, Model model) {
		return genericController.editGet(model, id, User.class, "user", "user");
	}

	@PostMapping("/edit")
	public String editPost(Model model, @Valid User user, BindingResult result) {
		return genericController.editPost(model, user, result, "user", "success");
	}

	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		return genericController.allDelete(id, User.class, "success");
	}
}