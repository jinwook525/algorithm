package chap2_기본자료구조;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {// Object 클래스 상속
		return String.format("이름: %s, 키: %d, 시력: %.1f", name, height, vision);
	}

	@Override
	public int compareTo(PhyscData p) {
		int nameCmp = name.compareTo(p.name);
		if (nameCmp != 0) {
			return nameCmp;
		} else {
			int heightCmp = Integer.compare(height, p.height);
			if (heightCmp != 0) {
				return heightCmp;
			} else {
				return Double.compare(vision, p.vision);
			}
		}
	}

	public boolean equals(Object ob) {// Object 클래스 상속
		PhyscData p = (PhyscData) ob;
		if (this == ob)
			return true;
		if (!(ob instanceof PhyscData))
			return false;
		PhyscData p = (PhyscData) ob;
		return name.equals(p.name) && height == p.height && Double.compare(vision, p.vision) == 0;
	}
}

public class train_실습2_14_1객체배열정렬 {
	public static void swap(PhyscData arr[], int i, int j) {
		PhyscData t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void sortData(PhyscData[] data) {// 객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로
		// compareTo()를 사용하여 구현
		 int n = data.length;
	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                // compareTo를 사용하여 정렬 기준 적용
	                if (data[j].compareTo(data[minIndex]) < 0) {
	                    minIndex = j;
	                }
	            }
	            // 최솟값을 찾으면 교환
	            swap(data, i, minIndex);
	        }
	    }

	

	public static int binarySearch(PhyscData[] data, String msg) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].name.equals(msg)) {
				return i;
			}
		}
		return -1;
		// if (data[i].equals(key)) ***으로 구현

	} // equals()를 사용하여 구현
		// 배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴

	public static PhyscData[] insertObject(PhyscData[] data, PhyscData newData) {
		        PhyscData[] newArray = new PhyscData[data.length + 1];
		        int i = 0;
		        while (i < data.length && data[i].compareTo(newData) <= 0) {
		            newArray[i] = data[i];
		            i++;
		        }
		        newArray[i] = newData;
		        while (i < data.length) {
		            newArray[i + 1] = data[i];
		            i++;
		        }
		        return newArray;
	}  
	
	public static void showData(String title, PhyscData[] data) {
			System.out.println(title);
			for (PhyscData p : data) {
            System.out.println(p);
			}
		 }
		        
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		int resultIndex = binarySearch(data, "사이다");
		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
	}
	
	
}


