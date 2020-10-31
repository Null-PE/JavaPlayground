package designpattern.strategy.task.logic;

import static java.util.Comparator.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import designpattern.strategy.task.Task;

public class ImportanceTaskStrategy implements ITaskStrategy {

	@Override
	public Optional<Task> nextTask(List<Task> tasks) {
		return tasks.stream().max(comparingInt(Task::getImportance));
	}

	@Override
	public List<Task> sort(List<Task> tasks) {
		return tasks.stream().sorted(comparingInt(Task::getImportance).reversed()).collect(Collectors.toList());
	}
}
