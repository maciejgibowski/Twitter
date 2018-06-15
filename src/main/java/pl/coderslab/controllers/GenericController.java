package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import pl.coderslab.dao.MainDao;

@Controller
public class GenericController<T> {
	@Autowired
	private MainDao<T> mainDao;

	public String addGet(Model model, T newObject, String objectName, String viewName) {
		model.addAttribute(objectName, newObject);
		model.addAttribute("method", "post");
		return viewName;
	}

	public String editGet(Model model, long id, Class<T> className, String attributeName, String viewName) {
		model.addAttribute(attributeName, mainDao.findById(className, id));
		model.addAttribute("method", "put");
		return viewName;
	}

	public String allPost(T recievedObject, String viewName, String successView) {
		mainDao.update(recievedObject);
		return successView;
	}

	public String addPost(Model model, T recievedObject, BindingResult result, String viewName, String successView) {
		if (result.hasErrors()) {
			model.addAttribute("method", "post");
			return viewName;
		}
		mainDao.update(recievedObject);
		return successView;
	}
	
	public String editPost(Model model, T recievedObject, BindingResult result, String viewName, String successView) {
		if (result.hasErrors()) {
			model.addAttribute("method", "put");
			return viewName;
		}
		mainDao.update(recievedObject);
		return successView;
	}

	public String allDelete(long id, Class<T> className, String successView) {
		mainDao.delete(className, id);
		return successView;
	}

}