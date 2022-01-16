package demoprojekti.todo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;
import demoprojekti.todo.domain.Category;
import demoprojekti.todo.domain.CategoryRepository;
import demoprojekti.todo.domain.Task;
import demoprojekti.todo.domain.TaskRepository;
import demoprojekti.todo.domain.User;
import demoprojekti.todo.domain.UserRepository;


@SpringBootApplication
public class TodoApplication {

	private static final Logger log = (Logger) LoggerFactory.getLogger(TodoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	// testdata
	@Bean
	public CommandLineRunner demo(TaskRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {

		

			log.info("fetch all tasks");
			for (Task task : repository.findAll()) {
				log.info(task.toString());
			}

		};

	}
}
