package FinallyTest2;

public class FinallyTest2 {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() { /*파일복사코드*/ }
	static void copyFiles( ) { }
	static void deleteTempFiles() { }
}
