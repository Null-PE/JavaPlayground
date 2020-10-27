package day24.facade.myversion.outerlib;

import java.util.List;

import com.google.common.base.Joiner;

public class MyVersionCommand {
	public  String branch(String branchName) {
		return "create new branch name is " + branchName;
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
	
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
}
