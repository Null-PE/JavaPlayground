package designpattern.strategy.todo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class TodoListTest {
	private TodoList todoList;
	private Todo normalTodo;
	private Todo secondImpTodo;
	private Todo mostImpTodo;

	@Before
	public void setUp() {
		todoList = new TodoList();
		normalTodo =  new Todo("算数の宿題をやる");
		mostImpTodo = new Todo("誕生日ケーキを買う"); 
		secondImpTodo = new Todo("晩御飯を作る"); 
		todoList.addTodo(normalTodo);
		todoList.addTodo(mostImpTodo);
		todoList.addTodo(secondImpTodo);
	}

	@Test
	public void testTodoContent() {
		Todo todo = new Todo("算数の宿題をやる");
		assertThat(todo.getContent(), is("算数の宿題をやる"));
	}

	@Test
	public void testTodoImportance() {
		throw new AssertionError("実装してください");
	}

	@Test
	public void testAddTodo() {
		assertThat(todoList.getTodos(), is(hasItem(normalTodo)));
	}

	@Test
	public void testRemoveTodo() {
		todoList.finishTodo(normalTodo);
		assertThat(todoList.getTodos(), is(not(hasItem(normalTodo))));
	}

	@Test
	public void testGetNextTodo() {
		assertThat(todoList.nextTodo().get(), is(normalTodo));
	}

	@Test
	public void testGetMostImportantTodo() {
		throw new AssertionError("実装してください");
	}

	@Test
	public void testGetSortedTodoDefault() {
		assertThat(todoList.getSortedTodo(), is(contains(normalTodo, mostImpTodo, secondImpTodo)));
	}

	@Test
	public void testGetSortedTodoImportance() {
		throw new AssertionError("実装してください");
	}
}