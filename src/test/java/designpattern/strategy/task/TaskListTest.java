package designpattern.strategy.task;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import designpattern.strategy.task.Task;
import designpattern.strategy.task.TaskList;
import designpattern.strategy.task.logic.ImportanceTaskStrategy;
import designpattern.strategy.task.logic.LifoStrategy;

public class TaskListTest {
	private TaskList taskList;
	private Task normalTask;
	private Task secondImpTask;
	private Task mostImpTask;

	@Before
	public void setUp() {
		taskList = new TaskList();
		normalTask =  new Task("算数の宿題をやる");
		mostImpTask = new Task("誕生日ケーキを買う", 100); 
		secondImpTask = new Task("晩御飯を作る", 10); 
		taskList.addTask(normalTask);
		taskList.addTask(mostImpTask);
		taskList.addTask(secondImpTask);
	}

	@Test
	public void testTaskContent() {
		Task task = new Task("算数の宿題をやる");
		assertThat(task.getContent(), is("算数の宿題をやる"));
	}

	@Test
	public void testAddTask() {
		assertThat(taskList.getTasks(), is(hasItem(normalTask)));
	}
	
	@Test
	public void testRemoveTask() {
		taskList.finishTask(normalTask);
		assertThat(taskList.getTasks(), is(not(hasItem(normalTask))));
	}
	
	@Test
	public void testGetNextTask() {
		assertThat(taskList.nextTask().get(), is(normalTask));
	}

	@Test
	public void testImportance() {
		Task task = new Task("晩ごはんを作る", 10);
		assertThat(task.getImportance(), is(10));
	}

	@Test
	public void testGetMostImportantTask() {
		taskList.changeStrategy(new ImportanceTaskStrategy());
		assertThat(taskList.nextTask().get(), is(mostImpTask));
	}

	@Test
	public void testLifoTask() {
		taskList.changeStrategy(new LifoStrategy());
		assertThat(taskList.nextTask().get(), is(secondImpTask));
	}

	@Test
	public void testGetSortedTaskDefault() {
		assertThat(taskList.getSortedTask(), is(contains(normalTask, mostImpTask, secondImpTask)));
	}

	@Test
	public void testGetSortedTaskImportance() {
		taskList.changeStrategy(new ImportanceTaskStrategy());
		assertThat(taskList.getSortedTask(), is(contains(mostImpTask, secondImpTask, normalTask)));
	}

	@Test
	public void testGetSortedTaskLifo() {
		taskList.changeStrategy(new LifoStrategy());
		assertThat(taskList.getSortedTask(), is(contains(secondImpTask, mostImpTask, normalTask)));
	}
}
