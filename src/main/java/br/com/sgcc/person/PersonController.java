package br.com.sgcc.person;

import static org.springframework.data.domain.PageRequest.of;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/form")
	public String form() {
		return "person/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Person person) {
		System.out.println(person);
		
		repository.save(person);
		
		return "redirect:/person";
	}
	
}
