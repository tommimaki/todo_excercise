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

			// Create users: admin1/admin1 user2/user2
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);

						Category Cat1 = new Category("koulu");
						crepository.save(Cat1);
						Category Cat2 = new Category("koti");
						crepository.save(Cat2);

						repository.save(new Task("Tee ruokaa", "Tommi", Cat1));
						repository.save(new Task("Tee läksyt", "Tommi", Cat2));
				

			log.info("fetch all tasks");
			for (Task task : repository.findAll()) {
				log.info(task.toString());
			}

		};

	}
}
