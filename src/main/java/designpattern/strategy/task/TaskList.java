package designpattern.strategy.task;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import designpattern.strategy.task.logic.DefaultTaskStrategy;
import designpattern.strategy.task.logic.ITaskStrategy;


public class TaskList {
	private List<Task> tasks;
	private ITaskStrategy strategy;

	public TaskList() {
		this.tasks = Lists.newArrayList();
		this.strategy = new DefaultTaskStrategy();
	}

	public TaskList(ITaskStrategy strategy) {
		this.tasks = Lists.newArrayList();
		this.strategy = strategy;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void finishTask(Task task) {
		if(tasks.contains(task)) {
			tasks.remove(tasks.indexOf(task));
		}
	}

	void changeStrategy(ITaskStrategy strategy) {
		this.strategy =strategy; 
	}

	public Optional<Task> nextTask() {
		return strategy.nextTask(tasks);
	}

	public List<Task> getSortedTask() {
		return strategy.sort(tasks);
	}
}