package br.com.sgcc.room.owner;

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
@RequestMapping("/room-owner")
public class RoomOwnerController extends ControllerTemplate<RoomOwner> {

	@Autowired
	private RoomOwnerRepository repository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	
	public RoomOwnerController() {
		super(RoomOwner.class);
	}
	

	@GetMapping("")
	public String list(Model model, Optional<String> page, RoomOwnerFilters filters) {
		super.list(model, page, repository, filters);
		
		return "roomOwner/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		model.addAttribute("buildingList", buildingRepository.findAll());
		model.addAttribute("companyList", companyRepository.findAll());
		
		return "roomOwner/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute RoomOwner obj) {
		super.save(repository, obj);
		
		return "redirect:/room-owner";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/room-owner";
	}

}
