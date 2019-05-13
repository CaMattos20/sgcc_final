package br.com.sgcc.company;

import static java.time.LocalDateTime.now;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgcc.ControllerTemplate;

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
		return super.list(model, page, repository, filters, "company/list");
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		return super.form(repository, id, model, "company/form");
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Company company) {
		if(company.getId() == null)
			company.setValidFrom(now());
		
		return super.save(repository, company, "redirect:/company");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		return super.delete(repository, id, "redirect:/company");
	}	
	
}
