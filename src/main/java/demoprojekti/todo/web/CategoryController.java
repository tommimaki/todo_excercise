package demoprojekti.todo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demoprojekti.todo.domain.Category;
import demoprojekti.todo.domain.CategoryRepository;




@CrossOrigin
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	 
    
	//lista
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET )
	public String categoryList(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	
	//lisää
	@RequestMapping(value = "/addcategory")
	public String addTask(Model model) {
		model.addAttribute("category", new Category() );
		return "addcategory";
	}
	
	//tallenna
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}
	
	//poisto
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") Long categoryid, Model model) {
    	repository.deleteById(categoryid);
        return "redirect:../categorylist";
    }     
	
	// RESTful allcats
    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategoriesRest() {	
        return (List<Category>) repository.findAll();
    }    

	// REST byid
    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Category> findCategoriesRest(@PathVariable("id") Long cId) {	
    	return repository.findById(cId);
    } 
    
    // RESTful save
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCatRest(@RequestBody Category category) {	
    	return repository.save(category);
    }

	
	
	
	
}
