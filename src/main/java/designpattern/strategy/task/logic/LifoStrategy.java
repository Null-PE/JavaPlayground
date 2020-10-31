package designpattern.strategy.task.logic;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import designpattern.strategy.task.Task;

public class LifoStrategy implements ITaskStrategy {

	@Override
	public Optional<Task> nextTask(List<Task> tasks) {
		return Optional.ofNullable(Iterables.getLast(tasks));
	}

	@Override
	public List<Task> sort(List<Task> tasks) {
		return Lists.reverse(Lists.newArrayList(tasks));
	}


}
