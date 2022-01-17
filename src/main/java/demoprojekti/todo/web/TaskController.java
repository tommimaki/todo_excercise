package demoprojekti.todo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demoprojekti.todo.domain.Category;
import demoprojekti.todo.domain.CategoryRepository;
import demoprojekti.todo.domain.Task;
import demoprojekti.todo.domain.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	
	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	

	@RequestMapping(value = { "/", "/tasklist" })
	public String taskList(Model model) {
		model.addAttribute("tasks", repository.findAll());
		return "tasklist";
	}

	@RequestMapping(value = "/add")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("categories", crepository.findAll() );
		return "addtask";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Task task) {
		repository.save(task);
		return "redirect:tasklist";
	}

    @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") Long taskId, Model model) {
    	repository.deleteById(taskId);
        return "redirect:../tasklist";
    }     
	
	
    //rest
	
    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> TaskListRest() {	
        return (List<Task>) repository.findAll();
    }    


    @RequestMapping(value="/tasks/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long taskId) {	
    	return repository.findById(taskId);
    }      
    
   
    @RequestMapping(value="/tasks", method = RequestMethod.POST)
    public @ResponseBody Task saveTaskRest(@RequestBody Task task) {	
    	return repository.save(task);
    }
	
	
	
	
}
