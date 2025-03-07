package chap2_기본자료구조;
/*
 * 2장 과제2 - 정수 배열 정렬
 * 배열의 크기는 20개, top 변수가 현재 배열에 저장된 갯수를 저장 
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		float []data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);//10개의 난수를 입력
		showData("실수 난수 입력", data);//top 개수 만큼 출력

		reverse(data);//역순으로 재배치 - 교재 67페이지 참조
		showData("역순 재배치", data);
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조
		showData("실수 스트링의 정렬", data);
		sortData(data);//교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
		showData("버블정렬", data);
		Random rand = new Random();
		float realData = rand.nextFloat(); //실수 난수 생성;
		insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", data);
	}
	
	public static void showData(String msg, float data[]) {//실수 배열을 top 갯수만 출력
		System.out.println(msg+":");
		for(int i=0; i<top ; i++ ) {
			System.out.println(data[i]);
		}
	}
	public static void inputData(float data[], int count) {
		//난수 실수를 입력
		Random rand = new Random();
		for(int i=0 ; i<count; i++)
			data[i]=rand.nextFloat();
		top += count;

	}
	public static void reverse(float data[]) {//역순으로 재배치 - top 갯수만 역순 재배치
		int start = 0;
		int end = top -1;
		 while (start < end) {
	            swap(data, start, end); // 앞뒤 값을 교환
	            start++;
	            end--;
		}
	}
	public static void swap(float data[], int i, int j) {//교재 67페이지 - 맞교환
		float temp = data[i];
		data[i]=data[j];
		data[j]= temp;
	}
	public static void sortData(float data[]) {//올림차순으로 정렬 - top 갯수를 사용
		for (int i=0; i< top-1 ; i++) {
			for(int j=0 ; j<top-1 ; j++) {
				if(data[j]>data[j+1]) {
					swap(data, j, j+1);
				}
			}
		}
	}
	public static void insertData(float data[], float value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int i;
		for (i = top - 1; i >= 0; i--) {
            if (data[i] > value) {
                data[i + 1] = data[i];
            } else {
                break; 
            }
        }
        data[i + 1] = value;
        top++; 
	}


}
