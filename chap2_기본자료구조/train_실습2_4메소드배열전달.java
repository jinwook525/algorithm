package chap2_기본자료구조;
/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;
public class train_실습2_4메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		int []data = new int[MAX_LENGTH];
		inputData(data);
		showData("소스데이터",data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력 
		showData("역순 데이터", data);
		
	}
	
	public static void showData(String msg, int data[]) {
		System.out.println(msg+":");
		for(int i=0 ; i< top ; i++) {
			System.out.println(data[i]);
		}
		//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		
	}
	public static void inputData(int data[]) {//교재 63 - 난수의 생성
		//top이 배열에 저장된 갯수를 저장
		Random rand = new Random();
		for (int i = 0; i<10 ; i++) {
			data[i] = rand.nextInt(100);
			top++;
		}
		
	}//최대값을 리턴한다 
	public static int findMax(int data[]) {
		int max= data[0];
		for(int i=0; i<top; i++) {
			if(data[1]> max) {
				max= data[1];
			}
		}
		return max;
	}	
	//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
	public static boolean findValue(int data[], int value) {
		for (int i=0; i<top ; i++) {
			if(data[i]== value) {
				return true;
			}
		}
		return false;
	}
	private static void reverse(int[] data) {
		int start = 0;
		int end = top-1 ;
		while (start < end) {
            // 배열의 앞과 뒤를 교환
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
	}
}
