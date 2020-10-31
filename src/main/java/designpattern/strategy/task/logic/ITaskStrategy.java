package designpattern.strategy.task.logic;

import java.util.List;
import java.util.Optional;

import designpattern.strategy.task.Task;

public interface ITaskStrategy {
	Optional<Task> nextTask(List<Task> tasks);
	List<Task> sort(List<Task> tasks);

}