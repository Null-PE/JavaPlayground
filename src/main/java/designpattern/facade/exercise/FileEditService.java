package designpattern.facade.exercise;

import designpattern.facade.exercise.git.GitFacade;
import designpattern.facade.exercise.storage.StorageType;

public class FileEditService {
	
	/**
	 * 指定されたStorageTypeにあった処理を実行してください。 
	 *  
	 * ただし、facadeはupload以外の処理も行う必要があるため、今後のメンテナンス性を考慮してif文での分岐をしないように
	 */
	public void upload(StorageType storageType) {
		GitFacade facade = new GitFacade();
		facade.upload();
	}
}
