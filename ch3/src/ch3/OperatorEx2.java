package ch3;

public class OperatorEx2 {

	public static void main(String[] args) {
		int i=5, j=0;
		
		j = i++;
		//j = i;
		//i = i + 1;
		System.out.println("j=i++; ���� ��, i=" + i +", j="+ j);
		
		i=5;
		j=0;
		
		j = ++i;
		//i = 1+ i;
		//j = i;
		System.out.println("j=++i; ���� ��, i=" + i +", j="+ j);

	}

}
