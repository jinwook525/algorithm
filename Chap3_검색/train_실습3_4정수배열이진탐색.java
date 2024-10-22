package Chap3_검색;
import java.lang.reflect.Array;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class train_실습3_4정수배열이진탐색 {

	public static void inputData(int[]data) {
		Random random = new Random();
		for (int i=0 ; i<data.length; i++) {
			data[i]= random.nextInt(101);
		}
	}
	public static void showList(String msg,int[] data) {
		System.out.println(msg);{
			for (int i=0 ; i<data.length; i++) {
				System.out.println(data[i]);
			}
		}
	}
	public static boolean linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length ; i++) {
			if(data[i]== key) {
				return true;
			}
		}
		return false;
	}
	private static int binarySearch(int[] data, int key) {
		int pl= 0;
		int pr = data.length-1;
		
		do {
			int pc = (pl+pr)/2;
			if (data[pc]== key)
				return pc;
			else if (data[pc] < key)
				pl = pc+1;
			else
				pr= pc-1;
		} while (pl <= pr);
		
		return -1;
	}
	
	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성
		Random random = new Random();
		
		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = random.nextInt(101);
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = random.nextInt(101);
		/*
		 * 교재 109~113
		 */
		int inresultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + inresultIndex);
		
		key = key = random.nextInt(101);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		inresultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + inresultIndex);

	}
	
	
}
