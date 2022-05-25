package ch2;

public class FloatToBinEx {

	public static void main(String[] args) {
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);
		
		
		String str;
		Integer Iint;
		Float Ffloat;
		Character ch;
		Double dDouble;
		Short sh;
		Long lg;
		Byte by;
		Boolean b;
		
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);

	}

}
