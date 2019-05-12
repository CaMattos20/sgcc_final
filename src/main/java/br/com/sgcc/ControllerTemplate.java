package br.com.sgcc;

import static org.springframework.data.domain.PageRequest.of;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public class ControllerTemplate<T> {

	public String list(Model model, Optional<String> page, DefaultRepository<T> repository, Filters filters, String returnFile) {
		int pageSize = 5;
		
		int pageInt = Integer.parseInt(page.orElse("1"));
		
		List<T> list = repository.findByFilters(filters, of(pageInt-1, pageSize)).getContent();
		
		long count = repository.count(filters);
		
		int pageCount = (int) Math.ceil(count * 1.0 / pageSize);

		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", pageInt);
		model.addAttribute("filters", filters);
		
		return returnFile;
	}
	
}
