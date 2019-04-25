package br.com.sgcc.person;

import static java.lang.Integer.parseInt;
import static org.springframework.data.domain.PageRequest.of;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@GetMapping("")
	public String list(Model model) {
		List<Person> list = repository.findAll(of(0, 20)).getContent();
		
		model.addAttribute("list", list);
		
		return "person/list";
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
