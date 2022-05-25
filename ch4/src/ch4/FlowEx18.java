package ch4;

public class FlowEx18 {

	public static void main(String[] args) {
		/*for(int i=2;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.printf("%d * %d = %d%n", i, j, i*j);
			}
		}*/
		for(int i=2;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				System.out.printf("%2d * %2d = %3d%n", i, j, i*j);
			}
		}
	}

}
