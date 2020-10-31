package designpattern.strategy.task.logic;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import designpattern.strategy.task.Task;

public class DefaultTaskStrategy implements ITaskStrategy {

	@Override
	public Optional<Task> nextTask(List<Task> tasks) {
		return Optional.of(tasks.get(0));
	}

	@Override
	public List<Task> sort(List<Task> tasks) {
		return Lists.newArrayList(tasks);
	}

}
