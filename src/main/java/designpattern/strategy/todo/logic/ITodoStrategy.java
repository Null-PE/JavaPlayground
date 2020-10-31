package designpattern.strategy.todo.logic;

import java.util.List;
import java.util.Optional;

import designpattern.strategy.todo.Todo;

public interface ITodoStrategy {
	Optional<Todo> nextTodo(List<Todo> todos);
	List<Todo> sort(List<Todo> todos);
}
