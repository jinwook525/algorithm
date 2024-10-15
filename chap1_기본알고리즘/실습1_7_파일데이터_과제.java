package chap1_기본알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class 실습1_7_파일데이터_과제 {
/*
 * trim(),split(" ")
 */
    // 파일을 읽어 각 라인을 공백으로 분리하여 정렬하는 함수
    public static String[] readSortFromFile(String filename) {
    	// 저장할 데이터
        String data = "12 1 131 2 23";
        String data2 = " 312 32 8 22 7";
        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // 데이터를 파일에 씀
        	 writer.write(data);
             writer.write(data2);
        	} catch (IOException e) {
        		System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] stringArray = sb.toString().trim().split(" ");
        Arrays.sort(stringArray);  
        
        // 정렬된 배열 반환
        return stringArray;
       
    }

    // 문자열 배열을 정수 배열로 변환하고 정렬하는 함수
    private static int[] convertSortToInt(String[] sortedStringArray) {
        int[] intArray = new int[sortedStringArray.length];
        
        for (int i = 0; i < sortedStringArray.length; i++) {
            intArray[i] = Integer.parseInt(sortedStringArray[i]);
        }
        
        Arrays.sort(intArray);  // 정수 배열 정렬
        return intArray;
    }

    // 문자열 배열 출력 함수
    private static void printStringArray(String[] sortedStringArray) {
		for (String str : sortedStringArray) {
			System.out.println(str);
		}
		
	}

    // 정수 배열 출력 함수
    private static void printIntArray(int[] sortedIntArray) {
		// TODO Auto-generated method stub
		for (int num : sortedIntArray) {
			System.out.println(num);
		}
	}


    public static void main(String[] args) {
        String filename = "data.txt";  // 파일 이름 설정 (실제 파일 경로로 변경)

        // 파일에서 읽어온 문자열 배열을 정렬 후 출력
        String[] sortedStringArray = readSortFromFile(filename);
        System.out.println("Sorted String Array from File:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환하고 정렬 후 출력
        int[] sortedIntArray = convertSortToInt(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }

	
	


}
