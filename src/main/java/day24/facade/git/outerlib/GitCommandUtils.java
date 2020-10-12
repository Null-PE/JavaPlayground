package day24.facade.git.outerlib;

import java.util.List;

import com.google.common.base.Joiner;

public class GitCommandUtils {
	public  String branch() {
		return "create new branch";
	}
	
	public  String checkout(String branchName) {
		return "checkout " + branchName;
	}

	public String add(List<String> fileNames) {
		return "add [" + Joiner.on(",").join(fileNames) + "]";
	}
	
	public String commit(String branchName) {
		return "commit " + branchName;
	}
	
	public String push(String branchName) {
		return "push " + branchName;
	}
}
