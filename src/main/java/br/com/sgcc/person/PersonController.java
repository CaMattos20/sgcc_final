package br.com.sgcc.person;

import static java.lang.Integer.parseInt;

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
@RequestMapping("/person")
public class PersonController extends ControllerTemplate<Person> {

	@Autowired
	private PersonRepository repository;
	
	
	@GetMapping("")
	public String list(Model model, Optional<String> page, PersonFilters filters) {
		return super.list(model, page, repository, filters, "person/list");
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) {
		Person obj = new Person();
		
		if(id.isPresent()) {
			obj = repository.findById(parseInt(id.get())).get();
		}
		
		model.addAttribute("obj", obj);
		
		return "person/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Person person) {
		System.out.println(person);
		
		repository.save(person);
		
		return "redirect:/person";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		repository.deleteById(parseInt(id));
		
		return "redirect:/person";
	}
	
}
