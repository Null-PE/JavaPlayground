package day24.facade.myversion;

import java.util.List;

import day24.facade.myversion.outerlib.MyVersionBranchHelper;
import day24.facade.myversion.outerlib.MyVersionCommand;
import day24.facade.myversion.outerlib.MyVersionFileUtils;

public class MyVersionFacade {
	MyVersionCommand command;
	MyVersionFileUtils fileUtils;
	MyVersionBranchHelper branchHelper;

	public MyVersionFacade() {
		this.command = new MyVersionCommand();
		this.fileUtils = new MyVersionFileUtils();
		this.branchHelper = new MyVersionBranchHelper();
	}

	/**
	 * outerlibの窓口として、シンプルなAPIを用意する。
	 */
	public void upload() {
		String branchName = branchHelper.generateBranchName();
		command.branch(branchName);
		command.checkout(branchName);

		List<String> files = fileUtils.collectChangedFiles();
		command.add(files);


		command.commit(branchName);
		command.push(branchName);
	}
}
