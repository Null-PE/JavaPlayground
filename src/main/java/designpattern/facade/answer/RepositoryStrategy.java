package designpattern.facade.answer;

import designpattern.facade.answer.git.GitFacade;
import designpattern.facade.answer.myversion.MyVersionFacade;
import designpattern.facade.answer.storage.StorageType;

public class RepositoryStrategy {

	public IRepositoryCommand getCommand(StorageType storageType) {
		switch(storageType) {
			case GIT:
				return new GitFacade();
			case MYVERSION:
				return new MyVersionFacade();
			default:
				throw new IllegalArgumentException("Unexpected StoregeType:" + storageType);
		}
	}
}
