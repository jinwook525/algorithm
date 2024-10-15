package chap1_기본알고리즘;

import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	public static String[] splitSortString(String input) {
		// TODO Auto-generated method stub
		String[] in= input.split(" ");
		Arrays.sort(in);
		
		return in;
	}

    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	private static int[] convertSortToIntArray(String[] sortedStringArray) {
		// TODO Auto-generated method stub
		int[] intArray = new int [sortedStringArray.length];
		
		for(int i = 0; i<sortedStringArray.length; i++) {
			intArray[i] = Integer.parseInt(sortedStringArray[i]);
		}
		Arrays.sort(intArray);
		return intArray;
	}

    // 문자열 배열 출력 함수
	private static void printStringArray(String[] sortedStringArray) {
		// TODO Auto-generated method stub
		for(String item : sortedStringArray) {
			System.out.println(item);
		}
	}

    // 정수 배열 출력 함수
	private static void printIntArray(int[] sortedIntArray) {
		// TODO Auto-generated method stub
		for(int item : sortedIntArray) {
			System.out.println(item);
		}
	}

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }

	

	

	

	
}
