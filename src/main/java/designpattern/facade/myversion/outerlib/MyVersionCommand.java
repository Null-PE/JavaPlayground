package designpattern.facade.myversion.outerlib;

import java.util.List;

import com.google.common.base.Joiner;

/**
 * MyVersion のコマンドを実行する Util クラスです。</br>
 * 1 -> 5 の順に呼び出すことでリモートリポジトリに変更を送ることができます。
 */
public class MyVersionCommand {
	public  String branch(String branchName) {
		return "1. create new branch name is " + branchName;
	}
	
	public  String checkout(String branchName) {
		return "2. checkout " + branchName;
	}

	public String add(List<String> fileNames) {
		return "3. add [" + Joiner.on(",").join(fileNames) + "]";
	}
	
	public String commit(String branchName) {
		return "4. commit " + branchName;
	}
	
	public String push(String branchName) {
		return "5. push " + branchName;
	}
	
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
}
