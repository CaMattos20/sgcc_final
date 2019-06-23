package br.com.sgcc.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgcc.company.CompanyRepository;
import br.com.sgcc.core.ControllerTemplate;
import br.com.sgcc.visitor.VisitorRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends ControllerTemplate<Employee> {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired 
	private VisitorRepository visitorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public EmployeeController() {
		super(Employee.class);
	}
	
	
	@GetMapping("")
	public String list(Model model, Optional<String> page, EmployeeFilters filters) {
		super.list(model, page, repository, filters);
		
		return "employee/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		model.addAttribute("visitorList", visitorRepository.findAll());
		model.addAttribute("companyList", companyRepository.findAll());
		
		return "employee/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Employee obj) {
		super.save(repository, obj);
		
		return "redirect:/employee";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/employee";
	}
	
}
