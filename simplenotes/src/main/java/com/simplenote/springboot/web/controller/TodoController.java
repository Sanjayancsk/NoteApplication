package com.simplenote.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplenote.springboot.web.model.Note;
import com.simplenote.springboot.web.service.NoteService;

@Controller
public class TodoController {

	@Autowired
	NoteService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-notes", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("notes", service.retrieveTodos(name));
		return "list-notes";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

	@RequestMapping(value = "/add-note", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("note", new Note(0, getLoggedInUserName(model),
				"Default Title", new Date() ,""));
		return "note";
	}

	@RequestMapping(value = "/delete-note", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		if(id==1)
			throw new RuntimeException("Something went wrong");
		
		service.deleteTodo(id);
		return "redirect:/list-notes";
	}

	@RequestMapping(value = "/update-note", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Note note = service.retrieveTodo(id);
		model.put("note", note);
		return "note";
	}

	@RequestMapping(value = "/update-note", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Note todo,
			BindingResult result) {

		if (result.hasErrors()) {
			return "note";
		}

		todo.setUser(getLoggedInUserName(model));

		service.updateTodo(todo);

		return "redirect:/list-notes";
	}

	@RequestMapping(value = "/add-note", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Note note, BindingResult result) {

		if (result.hasErrors()) {
			return "note";
		}

		service.addTodo(getLoggedInUserName(model), note.getTitle(), note.getTargetDate(),
				note.getDetail());
		return "redirect:/list-notes";
	}
}
