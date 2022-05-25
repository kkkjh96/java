package 문제;

public class 문제4 {

	public static void main(String[] args) {
		//int dec = 1234;
		int hex = 0xABCD;
		int mask = 0xF;
		
		System.out.printf("hex=%X%n", hex);
		System.out.printf("%X%n", hex & mask);
		
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
				
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
				
		hex = hex >> 4;
		System.out.printf("%X%n", hex & mask);
				
	}

}
