package designpattern.facade.answer;

import designpattern.facade.answer.storage.StorageType;

public class FileEditService {
	
	/**
	 * 指定されたStorageTypeにあった処理を実行してください。 
	 * ただし、facadeはupload以外の処理も行う必要があるため、今後のメンテナンス性を考慮してif文での分岐をしないように
	 */
	public void upload(StorageType storageType) {
		IRepositoryCommand facade = new RepositoryStrategy().getCommand(storageType);
		facade.upload();
	}
}
