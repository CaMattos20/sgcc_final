package br.com.sgcc.company;

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
@RequestMapping("/company")
public class CompanyController extends ControllerTemplate<Company> {

	@Autowired
	private CompanyRepository repository;
	
	public CompanyController() {
		super(Company.class);
	}
	
	
	@GetMapping("")
	public String list(Model model, Optional<String> page, CompanyFilters filters) {
		super.list(model, page, repository, filters);
		
		return "company/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		return "company/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Company company) {
		super.save(repository, company);
		
		return "redirect:/company";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/company";
	}	
	
}
