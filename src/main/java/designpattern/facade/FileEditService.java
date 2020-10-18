package designpattern.facade;

import designpattern.facade.myversion.MyVersionFacade;

public class FileEditService {
	/**
	 * MyVersion用のFacadeを使うメソッド
	 */
	public void myVersionMain() {
		MyVersionFacade facade = new MyVersionFacade();
		facade.upload();
	}

	/**
	 * Git用のFacadeを使うメソッド
	 */
	public void gitMain() {
		
	}

}
