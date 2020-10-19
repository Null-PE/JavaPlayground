package designpattern.facade.answer.git;

import java.util.List;

import designpattern.facade.answer.IRepositoryCommand;
import designpattern.facade.answer.git.outerlib.GitBranchHelper;
import designpattern.facade.answer.git.outerlib.GitCommandUtils;
import designpattern.facade.answer.git.outerlib.GitFileUtils;


/**
 * Git操作のFacadeです。
 *
 */
public class GitFacade implements IRepositoryCommand {
	GitCommandUtils command;
	GitFileUtils fileUtils;
	GitBranchHelper branchHelper;

	public GitFacade() {
		command = new GitCommandUtils();
		fileUtils = new GitFileUtils();
		branchHelper = new GitBranchHelper();
	}

	/**
	 * Gitの窓口として、シンプルなAPIを用意する。
	 */
	@Override
	public void upload() {
		String branchName = branchHelper.generateBranchName();
		command.checkout(branchName);

		List<String> files = fileUtils.collectChangedFiles();
		command.add(files);

		command.commit(branchName);
		command.push(branchName);
	}
}
