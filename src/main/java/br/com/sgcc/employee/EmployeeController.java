package br.com.sgcc.employee;

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

import br.com.sgcc.core.ControllerTemplate;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends ControllerTemplate<Employee> {

	@Autowired
	private EmployeeRepository repository;
	
	
	public EmployeeController() {
		super(Employee.class);
	}
	
	
	@GetMapping("")
	public String list(Model model, Optional<String> page, EmployeeFilters filters) {
		return super.list(model, page, repository, filters, "employee/list");
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		return super.form(repository, id, model, "employee/form");
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Employee obj) {
		if(obj.getId() == null)
			obj.setValidFrom(now());
		
		return super.save(repository, obj, "redirect:/employee");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		return super.delete(repository, id, "redirect:/employee");
	}
	
}