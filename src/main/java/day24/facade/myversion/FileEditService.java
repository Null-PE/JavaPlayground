package day24.facade.myversion;

public class FileEditService {
	
	/**
	 * Facadeを使うクラス。
	 */
	public void main() {
		MyVersionFacade facade = new MyVersionFacade();
		facade.upload();
	}
}
