package ch5;

public class ArrayEx15 {

	public static void main(String[] args) {
		String sourse ="SOSHELP";
		String[] morse = {".-", "-...", "-.-.", "-..", "."
					    , "..-.", "--.", "....", "..", ".---"
					    , "-.-", ".-..", "--", "-.", "---"
					    , ".--.", "--.-", ".-.", "...", "-"
					    , "..-", "...-", ".--", "-..-", "-.--"
					    , "--.." };
		
		String result = "";
		
		for(int i = 0; i < sourse.length(); i++) {
			result += morse[sourse.charAt(i) - 'A'];
		}
		System.out.println("sourse:"+ sourse);
		System.out.println("morse:"+ result);
	}
}
