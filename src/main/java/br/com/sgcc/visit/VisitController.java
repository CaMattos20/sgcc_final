package br.com.sgcc.visit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgcc.building.BuildingRepository;
import br.com.sgcc.company.CompanyRepository;
import br.com.sgcc.core.ControllerTemplate;
import br.com.sgcc.visitor.VisitorRepository;

@Controller
@RequestMapping("/visit")
public class VisitController extends ControllerTemplate<Visit> {

	@Autowired
	private VisitRepository repository;
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	
	public VisitController() {
		super(Visit.class);
	}
	

	@GetMapping("")
	public String list(Model model, Optional<String> page, VisitFilters filters) {
		super.list(model, page, repository, filters);
		
		return "visit/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);

		model.addAttribute("visitorList", visitorRepository.findAll());
		model.addAttribute("companyList", companyRepository.findAll());
		model.addAttribute("buildingList", buildingRepository.findAll());
		
		return "visit/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Visit obj) {
		super.save(repository, obj);
		
		return "redirect:/visit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/visit";
	}

}
