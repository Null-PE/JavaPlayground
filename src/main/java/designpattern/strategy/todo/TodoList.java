package designpattern.strategy.todo;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import designpattern.strategy.todo.logic.DefaultTodoStrategy;
import designpattern.strategy.todo.logic.ITodoStrategy;

public class TodoList {
	private List<Todo> todos;

	public TodoList() {
		this.todos = Lists.newArrayList();
	}

	public void addTodo(Todo todo) {
		todos.add(todo);
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void finishTodo(Todo todo) {
		if(todos.contains(todo)) {
			todos.remove(todo);
		}
	}

	//TODO: 必要に応じて実装してください。
	public Optional<Todo> nextTodo() {
		return new DefaultTodoStrategy().nextTodo(todos);
	}

	//TODO: 必要に応じて実装してください。
	public List<Todo> getSortedTodo() {
		return new DefaultTodoStrategy().sort(todos);
	}

	//TODO: 必要に応じて実装してください。
	void changeStrategy(ITodoStrategy strategy) {
	}
}
