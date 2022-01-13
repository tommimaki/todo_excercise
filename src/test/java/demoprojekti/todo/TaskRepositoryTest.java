package demoprojekti.todo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import demoprojekti.todo.domain.Category;
import demoprojekti.todo.domain.Task;
import demoprojekti.todo.domain.TaskRepository;


@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test  // testataan StudentRepositoryn findByLastName()-metodin toimivuutta
    public void findByTasknameShouldReturnTask() {
        List<Task> tasks = repository.findByTaskName("Tee läksyt");
        
        assertThat(tasks).hasSize(1);
        assertThat(tasks.get(0).getTaskCreator()).isEqualTo("Tommi");
    }
    
    @Test // testataan StudentRepositoryn save()-metodin toimivuutta
    public void createNewTask() {
    	Task task = new Task("tee läksytTesti", "tommi", new Category("Koti"));
    	repository.save(task);
    	assertThat(task.getId()).isNotNull();
    }    
}
