package br.com.sgcc.renter;

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

@Controller
@RequestMapping("/renter")
public class RenterController extends ControllerTemplate<Renter> {

	@Autowired
	private RenterRepository repository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	
	public RenterController() {
		super(Renter.class);
	}
	

	@GetMapping("")
	public String list(Model model, Optional<String> page, RenterFilters filters) {
		super.list(model, page, repository, filters);
		
		return "renter/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		model.addAttribute("companyList", companyRepository.findAll());
		model.addAttribute("buildingList", buildingRepository.findAll());
		
		return "renter/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Renter obj) {
		super.save(repository, obj);
		
		return "redirect:/renter";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/renter";
	}

}
