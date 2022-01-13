package demoprojekti.todo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO) 
		private long categoryid;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		private List<Task> tasks;

		
		public Category() {}
		
		public Category(String name) {
			super();
			this.name = name;
		}

		public long getCategoryid() {
			return categoryid;
		}

		public void setCategoryId(long categoryid) {
			this.categoryid = categoryid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		
		
	
}
