package Chap3_검색;

/*
 * 3장 과제1: 스트링 배열 합병 정렬
 */
import java.util.Arrays;
import java.util.List;

public class train_실습3_9_0스트링배열합병 {
	public static void showList(String msg, String[] s1) {
		System.out.println(msg);
		for (String str : s1) {
			System.out.println(str);
		}

	}

	public static String[] mergeList(String[] s1, String[] s2) {
		String[] result= new String[s1.length+s2.length]; 
				int i=0, j=0, k=0;
		while (i< s1.length && j< s2.length) {
			if(s1[i].compareTo(s2[j]) <= 0) {
				result[k++]= s1[i++];
			}else {
				result[k++]= s2[j++];
			}
		}
		while(i<s1.length) {
			result[k++]=s1[i++];
		}
		while(j<s2.length) {
			result[k++]=s2[j++];
		}
		return result;
	}

	public static void main(String[] args) {
		String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신", "최치원" };
		String[] s2 = { "독도", "울릉도", "한산도", "영도", "오륙도", "동백섬" };
		Arrays.sort(s1);
		Arrays.sort(s2);

		showList("s1배열 = ", s1);
		showList("s2배열 = ", s2);

		String[] s3 = mergeList(s1, s2);// 정렬된 s1[], s2[]을 합병하여 다시 정렬된 결과를 만드는 함수 구현
		showList("스트링 배열 s3 = s1 + s2:: ", s3);
	}

}
