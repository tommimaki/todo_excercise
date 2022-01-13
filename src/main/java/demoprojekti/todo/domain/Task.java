package demoprojekti.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import demoprojekti.todo.domain.Category;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // creates automatically by DB
	private long id;
	private String taskName, taskCreator;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Task() {
	}

	// constructor
	public Task(String taskName, String taskCreator, Category category) {
		super();
		this.taskName = taskName;
		this.taskCreator = taskCreator;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCreator() {
		return taskCreator;
	}

	public void setTaskCreator(String taskCreator) {
		this.taskCreator = taskCreator;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
