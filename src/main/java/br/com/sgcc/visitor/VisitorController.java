package br.com.sgcc.visitor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgcc.core.ControllerTemplate;

@Controller
@RequestMapping("/visitor")
public class VisitorController extends ControllerTemplate<Visitor> {

	@Autowired
	private VisitorRepository repository;
	
	
	public VisitorController() {
		super(Visitor.class);
	}
	
	
	@GetMapping("")
	public String list(Model model, Optional<String> page, VisitorFilters filters) {
		super.list(model, page, repository, filters);
		
		return "visitor/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		return "visitor/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Visitor visitor) {
		super.save(repository, visitor);
		
		return "redirect:/visitor";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/visitor";
	}
	
}
