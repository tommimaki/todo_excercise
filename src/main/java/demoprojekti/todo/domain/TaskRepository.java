package demoprojekti.todo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findByTaskName(String taskName);

}
