package designpattern.strategy.todo.logic;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import designpattern.strategy.todo.Todo;

public class DefaultTodoStrategy implements ITodoStrategy {

	@Override
	public Optional<Todo> nextTodo(List<Todo> todos) {
		return Optional.of(todos.get(0));
	}

	@Override
	public List<Todo> sort(List<Todo> todos) {
		return Lists.newArrayList(todos);
	}

}
