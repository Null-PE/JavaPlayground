package designpattern.facade.exercise.git;

import java.util.List;

import designpattern.facade.exercise.git.outerlib.GitBranchHelper;
import designpattern.facade.exercise.git.outerlib.GitCommandUtils;
import designpattern.facade.exercise.git.outerlib.GitFileUtils;

/**
 * Git操作のFacadeです。
 *
 */
public class GitFacade {
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
	public void upload() {
		String branchName = branchHelper.generateBranchName();
		command.checkout(branchName);

		List<String> files = fileUtils.collectChangedFiles();
		command.add(files);

		command.commit(branchName);
		command.push(branchName);
	}
}
