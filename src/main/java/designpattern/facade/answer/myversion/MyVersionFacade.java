package designpattern.facade.answer.myversion;

import java.util.List;

import designpattern.facade.answer.IRepositoryCommand;
import designpattern.facade.answer.myversion.outerlib.MyVersionBranchHelper;
import designpattern.facade.answer.myversion.outerlib.MyVersionCommand;
import designpattern.facade.answer.myversion.outerlib.MyVersionFileUtils;


public class MyVersionFacade implements IRepositoryCommand{
	MyVersionBranchHelper branchHelper;
	MyVersionCommand command;
	MyVersionFileUtils fileUtils;

	public MyVersionFacade() {
		branchHelper = new MyVersionBranchHelper();
		command = new MyVersionCommand();
		fileUtils = new MyVersionFileUtils();
	}

	/**
	 * MyVersionの窓口として、シンプルなAPIを用意してください。
	 */
	public void upload() {
		String branchName = branchHelper.generateBranchName();
		command.branch(branchName);
		command.checkout(branchName);
		
		List<String> fileNames = fileUtils.collectChangedFiles();
		command.add(fileNames);
		command.commit(branchName);
		command.push(branchName);
	}
}
