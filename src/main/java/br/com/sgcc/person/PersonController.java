package br.com.sgcc.person;

import static org.springframework.data.domain.PageRequest.of;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository repository;
	
	@GetMapping("/person")
	public String list(Model model) {
		List<Person> list = repository.findAll(of(0, 20)).getContent();
		
		model.addAttribute("list", list);
		
		return "person/list";
	}
	
}
