package br.com.sgcc.core;

import static java.lang.Integer.parseInt;
import static org.springframework.data.domain.PageRequest.of;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public class  ControllerTemplate<T extends NormalizedEntity> {
	
	private Class<T> clazz;
	
	
	public ControllerTemplate(Class<T> clazz) {
		this.clazz = clazz;
	}
	

	public void list(Model model, Optional<String> page, DefaultRepository<T> repository, Filters filters) {
		int pageSize = 5;
		
		int pageInt = parseInt(page.orElse("1"));
		
		List<T> list = repository.findByFilters(filters, of(pageInt-1, pageSize)).getContent();
		
		long count = repository.count(filters);
		
		int pageCount = (int) Math.ceil(count * 1.0 / pageSize);
		
		if(pageCount == 0) {
			pageCount = 1;
		}

		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", pageInt);
		model.addAttribute("filters", filters);
	}

	public void form(DefaultRepository<T> repository, Optional<String> id, Model model) throws Exception {
		T obj = clazz.newInstance();
		
		if(id.isPresent()) { 
			obj = repository.findById(parseInt(id.get())).get();
		}
		
		model.addAttribute("obj", obj);
	}
	
	public void save(DefaultRepository<T> repository, T obj) {
		
		
		repository.save(obj);
	}
	
	public void delete(DefaultRepository<T> repository, String id) {
		repository.deleteById(parseInt(id));
	}
	
}
