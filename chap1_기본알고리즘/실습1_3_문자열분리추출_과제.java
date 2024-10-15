package chap1_기본알고리즘;

import java.util.Arrays;

public class 실습1_3_문자열분리추출_과제 {
	
	public static String[] splitAndSort(String target) {
		String[] sp = target.split(",");
		
		for (int i = 0; i < sp.length; i++) {
            sp[i] = sp[i].trim();
        } 
		Arrays.sort(sp);
		
		return sp;
		}
	public static int findAllString(String[] sortedArray, String target) {
		 int count = 0;

	        // 배열에서 target 문자열과 동일한 요소가 있는지 확인
	        for (String element : sortedArray) {
	            if (element.equals(target)) {
	                count++;
	            }
	        }

	        return count;
	    }
	
/*
 * split(",")
 * trim()
 * Arrays.sort(list)
 * equals(target)
 */
    // 문자열을 comma로 분리하여 배열로 저장하고 정렬하는 함수
    

    // 배열에서 특정 문자열을 찾는 함수 (있으면 true, 없으면 false 반환)
    

    public static void main(String[] args) {
        String s = "한국, 일본,미국,중국 , 미국 ,   독일   ,   프랑스, 미국 ";
        
        // 문자열을 분리하고 정렬한 배열을 반환, 분리된 문자열의 앞뒤 공백도 제거
        String[] sortedArray = splitAndSort(s);
        
        // 정렬된 배열 출력
        System.out.println("Sorted Array:");
        for (String item : sortedArray) {
            System.out.print(item + " ");
        }
        System.out.println("\nArray length = " + sortedArray.length);
        
        // 특정 문자열 찾기
        String target = "미국";
        int frequency = findAllString(sortedArray, target);
        System.out.println("빈도수 = " + frequency);
  
    }
	
}
