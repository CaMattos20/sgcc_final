package br.com.sgcc;

import static java.lang.Integer.parseInt;
import static org.springframework.data.domain.PageRequest.of;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public class ControllerTemplate<T> {
	
	private Class<T> clazz;
	
	
	public ControllerTemplate(Class<T> clazz) {
		this.clazz = clazz;
	}
	

	public String list(Model model, Optional<String> page, DefaultRepository<T> repository, Filters filters, String url) {
		int pageSize = 5;
		
		int pageInt = parseInt(page.orElse("1"));
		
		List<T> list = repository.findByFilters(filters, of(pageInt-1, pageSize)).getContent();
		
		long count = repository.count(filters);
		
		int pageCount = (int) Math.ceil(count * 1.0 / pageSize);

		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", pageInt);
		model.addAttribute("filters", filters);
		
		return url;
	}

	public String form(DefaultRepository<T> repository, Optional<String> id, Model model, String url) throws Exception {
		T obj = (id.isPresent() ? 
						repository.findById(parseInt(id.get())).get() 
						: clazz.newInstance() 
					);
		
		model.addAttribute("obj", obj);
		
		return url;
	}
	
	public String save(DefaultRepository<T> repository, T obj, String url) {
		repository.save(obj);
		
		return url;
	}
	
	public String delete(DefaultRepository<T> repository, String id, String url) {
		repository.deleteById(parseInt(id));
		
		return url;
	}
	
}
