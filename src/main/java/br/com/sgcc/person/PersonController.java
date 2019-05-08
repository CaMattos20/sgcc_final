package br.com.sgcc.person;

import static java.lang.Integer.parseInt;
import static org.springframework.data.domain.PageRequest.of;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String list(Model model, Optional<String> page, Optional<String> name, Optional<String> email, Optional<String> type, 
						Optional<String> phoneNumber, Optional<String> document) {
		int pageSize = 5;
		
		int pageInt = Integer.parseInt(page.orElse("1"));
		
		List<Person> list = repository.findByFilters(name.orElse(""), email.orElse(""), type.orElse(""), phoneNumber.orElse(""), document.orElse(""), of(pageInt-1, pageSize)).getContent();
		
		long count = repository.count(name.orElse(""), email.orElse(""), type.orElse(""), phoneNumber.orElse(""), document.orElse(""));
		
		int pageCount = (int) Math.ceil(count * 1.0 / pageSize);

		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", pageInt);
		model.addAttribute("name", name.orElse(""));
		model.addAttribute("email", email.orElse(""));
		model.addAttribute("type", type.orElse(""));
		model.addAttribute("phoneNumber", phoneNumber.orElse(""));
		model.addAttribute("document", document.orElse(""));
		
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
