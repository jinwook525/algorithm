package Chap3_검색;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 3장 4번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparator 구현
 * 3장 실습 3-8를 수정하여 객체 배열의 정렬 구현
 */

class PhyscData3 {
    String name;
    int height;
    double vision;

    public PhyscData3(String name, int height, double vision) {
        this.name = name;
        this.height = height;
        this.vision = vision;
    }

    public String getName() {
        return name;
    }
}

// 이름으로 비교하는 Comparator
class NameOrder implements Comparator<PhyscData3> {
    @Override
    public int compare(PhyscData3 p1, PhyscData3 p2) {
        return p1.name.compareTo(p2.name);
    }
}

// 키로 비교하는 Comparator
class HeightOrder implements Comparator<PhyscData3> {
    @Override
    public int compare(PhyscData3 p1, PhyscData3 p2) {
        return Integer.compare(p1.height, p2.height);
    }
}

// 시력으로 비교하는 Comparator
class VisionOrder implements Comparator<PhyscData3> {
    @Override
    public int compare(PhyscData3 p1, PhyscData3 p2) {
        return Double.compare(p1.vision, p2.vision);
    }
}

// 메인 클래스
public class train실습3_8객체비교연산자 {
    // 객체 배열을 출력하는 메서드
    public static void showData(String msg, PhyscData3[] data) {
        System.out.println(msg);
        for (PhyscData3 p : data) {
            System.out.println(p.name + " " + p.height + "cm " + p.vision);
        }
    }

    public static void main(String[] args) {
        // PhyscData3 배열 생성
        PhyscData3[] data = {
            new PhyscData3("홍길동", 162, 0.3),
            new PhyscData3("나가자", 164, 1.3),
            new PhyscData3("다정해", 152, 0.7),
            new PhyscData3("소주다", 172, 0.4),
            new PhyscData3("사이다", 182, 0.6),
            new PhyscData3("신정신", 166, 1.2),
            new PhyscData3("이기자", 167, 1.5),
        };

        // 정렬 전 출력
        showData("정렬전 객체 배열", data);

        // 키로 정렬
        Arrays.sort(data, new HeightOrder());
        showData("키로 정렬후 객체 배열", data);

        // 이진 검색
        PhyscData3 key = new PhyscData3("길동", 167, 0.2);
        int idx = Arrays.binarySearch(data, key, new HeightOrder());
        System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx);

        // 시력으로 정렬
        Arrays.sort(data, new VisionOrder());
        showData("시력으로 정렬후 객체 배열", data);

        // 이름으로 정렬
        Arrays.sort(data, new NameOrder());
        showData("이름으로 정렬후 객체 배열", data);
    }
}
