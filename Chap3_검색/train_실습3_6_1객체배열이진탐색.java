package Chap3_검색;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;

	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return String.format(name, height,vision);
	}
	@Override
	public int compareTo(PhyscData2 p) {
		// name 비교 버젼
		return this.name.compareTo(p.name);
		// height 비교 버젼
		
	}

}
public class train_실습3_6_1객체배열이진탐색 {
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
		
		key = new PhyscData2("박동", 167, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		key = new PhyscData2("나동", 164, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//compareTo()를 사용되는지를 확인-이해할 수 있어야 한다 
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}

	public static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = data[mid].compareTo(key);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
		return -1;
	}

	public static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		for (int i=0; i<data.length; i++) {
			if(data[i].compareTo(key)==0) {
				return i;
		}
	}
		return -1;
	}

	public static void reverse(PhyscData2[] data) {
		// TODO Auto-generated method stub
		int n = data.length;
		for(int i = 0; i<n/2; i++) {
			PhyscData2 tmp = data[i];
			data[i]= data[n-i-1];
			data[n-i-1] = tmp;
		}
	}

	public static void sortData(PhyscData2[] data) {
		for(int i= 1;i<data.length ; i++ ) {
			PhyscData2 tmp = data[i];
			int j;
			for( j=i; j>0 && data[j-1].compareTo(tmp) >0; j--) {
				data[j]= data[j-1];
			}
			data[j]=tmp;
		}
		
	}

	public static void showData(String msg, PhyscData2[] data) {
		System.out.println(msg);
			for(PhyscData2 p : data) {
				System.out.println(p);
			}
		
	}
	
	

}
