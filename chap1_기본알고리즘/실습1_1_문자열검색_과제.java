package chap1_기본알고리즘;

/*
 * PCCP 코딩 시험에서 스트링에 대한 기본 함수 사용 숙달이 필요하다
 * 
 */

public class 실습1_1_문자열검색_과제 {
	public static void main(String[] args) {
		String address[] = { 
				"경기도 남양주 별내동", 
				"서울시 영등포구 당산동", 
				"부산시 동래구 온천동144",
				"충남 천안시 서북구", 
				"부산시 연제구 연산동", 
				"서울시 송파구 석촌동", 
				"전북 부안군 부안읍",
				"부산시 금정구 장전동63"
		};

		// 1. "부산시"를 포함하는 문자열 찾기
		System.out.println("1. Contains '부산시':");
		findStrings(address, "부산시", "contains");

		// 2. replaceAll 메서드를 통해 이를 빈 문자열로 대체
		//주소 중에서 99보다 작은 숫자가 있으면 이를 찾아서 출력
		System.out.println("2. 숫자':");//정규 표현식의 [^0-9]은 숫자가 아닌 모든 문자
		findStrings(address, "99", "number");

		// 3. "서울시"로 시작하는 문자열 찾기
		System.out.println("3. Starts with '서울시':");
		findStrings(address, "서울시", "startsWith");

		// 4. "연산동"으로 끝나는 문자열 찾기
		System.out.println("4. Ends with '연산동':");
		findStrings(address, "연산동", "endsWith");
	}

	// 조건에 맞는 문자열을 찾고 출력하는 함수
	public static void findStrings(String[] array, String keyword, String condition) {
		for (String element : array) {
			switch (condition) {
			case"contains":
				if (element.contains("부산시")){
					System.out.println(element);
				}
				break;
			case"number":
				String only = element.replaceAll("[^0-9]", "").trim();
				if(only != "") {
					int number = Integer.parseInt(only); {
						if (number <99) {
							System.out.println(number);
						}
			
					}

				}
				break;
			case"startsWith" :
				if (element.startsWith("서울시")) {
					System.out.println(element);
				}
				break;
			case"endsWith":
				if(element.endsWith("연산동")) {
					System.out.println(element);
				}
				break;
			}
		}
	}
	/*
	 * contains(), replaceAll("[^0-9]", "");
	 * Integer.parseInt(numberString);
	 * startsWith(keyword)
	 * endsWith(keyword)
	 */


}

