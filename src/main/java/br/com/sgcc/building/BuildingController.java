package br.com.sgcc.building;

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
@RequestMapping("/building")
public class BuildingController extends ControllerTemplate<Building> {

	@Autowired
	private BuildingRepository repository;	
	
	
	public BuildingController() {
		super(Building.class);
	}
	

	@GetMapping("")
	public String list(Model model, Optional<String> page, BuildingFilters filters) {
		super.list(model, page, repository, filters);
		
		return "building/list";
	}
	
	@GetMapping(value = {"/form", "/form/{id}"})
	public String form(@PathVariable Optional<String> id, Model model) throws Exception {
		super.form(repository, id, model);
		
		return "building/form";
	}
	
	@PostMapping("/")
	public String save(@ModelAttribute Building building) {
		super.save(repository, building);
		
		return "redirect:/building";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		super.delete(repository, id);
		
		return "redirect:/building";
	}

}
