package FinallyTest;

public class FinallyTest {

	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
			deleteTempFiles();
		} catch (Exception e) {
			e.printStackTrace();
			deleteTempFiles();
		}
	}
	
	static void startInstall() { /*���α׷� ��ġ�� �ʿ��� �غ� �ϴ� �ڵ� �ۼ�*/ }
	static void copyFiles() { /*���ϵ��� �����ϴ� �ڵ� �ۼ�*/ }
	static void deleteTempFiles() { /*�ӽ����ϵ��� �����ϴ� �ڵ� �ۼ�*/ }
}
