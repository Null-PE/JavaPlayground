package designpattern.facade.answer.git.outerlib;

import java.util.List;

import com.google.common.base.Joiner;

/**
 * Gitのコマンドを実行するUtilクラスです。</br>
 * 1 -> 4の順に呼び出すことでリモートリポジトリに変更を送ることができます。
 */
public class GitCommandUtils {
	public void checkout(String branchName) {
		System.out.println("1. checkout " + branchName);
	}

	public void add(List<String> fileNames) {
		System.out.println("2. add [" + Joiner.on(",").join(fileNames) + "]");
	}

	public void commit(String branchName) {
		System.out.println("3. commit " + branchName);
	}

	public void push(String branchName) {
		System.out.println("4. push " + branchName);
	}
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
	//以下数十個のAPI
}
