package br.com.sgcc.expenses;

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
@RequestMapping("/expenses")
public class ExpensesController extends ControllerTemplate<Expenses> {

	@Autowired
	private ExpensesRepository repository;	
	
	
	public ExpensesController() {
		super(Expenses.class);
	}
	

	@GetMapping("")
	public String list(Model model, Optional<String> page, ExpensesFilters filters) {
		super.list(model, page, repository, filters);
		
		return "expenses/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		return "expenses/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Expenses expenses) {
		super.save(repository, expenses);
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/expenses";
	}

}
