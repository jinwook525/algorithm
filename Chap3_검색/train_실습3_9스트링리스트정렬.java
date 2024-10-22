package Chap3_검색;
/*
 * 3장 5번 실습과제 - 스트링 리스트 정렬
 * 리스트를 배열로 변환후 중복제거후 다시 리스트 만들기 등 실습
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
public class train_실습3_9스트링리스트정렬 {

	    //public static String[] removeElement1(String[] arr, String item) {}
	    
	    static void getList(List<String> list) {
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");


			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    static void showList(String topic, List<String> list) {//리스트 인덱스를 사용하여 리스트 멤버들을 출력
	    	System.out.println(topic);
	    	for (int i = 0; i<list.size(); i++) {
	    		System.out.println(i+ ":"+list.get(i));
	    	}
	    }
	    static void sortList(List<String> list) {//list는 정렬 안되므로 배열로 변환후 정렬 후 다시 리스트로 리턴
	    	String[]arr = list.toArray(new String[0]);
	    	Arrays.sort(arr);
	    	list.clear();
	    	list.addAll(Arrays.asList(arr));
	    	
	    }
	    
	    static String[] removeDuplicateList(List<String> list) {//중복 제거
	    	 // LinkedHashSet을 사용하면 순서를 유지하며 중복을 제거할 수 있음
	        LinkedHashSet<String> set = new LinkedHashSet<>(list);
	        // LinkedHashSet을 배열로 변환
	        return set.toArray(new String[0]);
	    }
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list);

//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}

