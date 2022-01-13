package demoprojekti.todo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	// RESTful service to get all category
    @RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategoriesRest() {	
        return (List<Category>) repository.findAll();
    }    

	// RESTful service to get category by id
    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Category> findCategoriesRest(@PathVariable("id") Long cId) {	
    	return repository.findById(cId);
    } 
    
    // RESTful service to save new category
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveStudentRest(@RequestBody Category category) {	
    	return repository.save(category);
    }

	
	
	
	
}
