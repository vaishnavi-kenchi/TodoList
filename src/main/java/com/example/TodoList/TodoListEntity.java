package com.example.TodoList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TodoList")
public class TodoListEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="Title")
	private String Title;

	@Column(name="Completed")
	private boolean Completed;

	public TodoListEntity() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public boolean isCompleted() {
		return Completed;
	}

	public void setCompleted(boolean completed) {
		Completed = completed;
	}
	
	
	

}
