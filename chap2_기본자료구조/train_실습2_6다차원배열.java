package chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;

public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];

		inputData(A);
		inputData(B);
		int[][] D = A.clone();// 교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int[][] E = addMatrix(A, D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A, B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int[][] F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C = multiplyMatrixTransposed(A, F);
		showData("행렬 곱셈 결과-전치행렬 사용", F);
	}

	static void inputData(int[][] data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = rand.nextInt(10);
			}
		}
	}

	static void showData(String msg, int[][] items) {
		System.out.println(msg);
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				System.out.print(items[i][j]);
			} System.out.println();
		}

	}

	static boolean equals(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

	static int[][] addMatrix(int[][] X, int[][] Y) {
		int result [][] = new int[X.length][Y.length];
		for(int i = 0; i<X.length ; i++) {
			for(int j = 0; i<X[i].length; j++) {
				result[i][j]= X[i][j]+Y[i][j];
			}
		}
		return result;
	}

	static int[][] multiplyMatrix(int[][] X, int[][] Y) {
		int result [][] = new int[X.length][Y[0].length]; 
			for(int i = 0; i<X.length ; i++) {
				for(int j = 0 ; j<Y[0].length; j++) {
					for(int k = 0; k<X[0].length; k++) {
						result[i][j] += X[i][k]*Y[k][j];
					}
				}
		}
			return result;
	}

	static int[][] transposeMatrix(int[][] X) {
		 int[][] result = new int[X[0].length][X.length]; 

		    for (int i = 0; i < X.length; i++) {
		        for (int j = 0; j < X[i].length; j++) {
		            result[j][i] = X[i][j]; 
		        }
		    }
			return result;
	}

	static int[][] multiplyMatrixTransposed(int[][] X, int[][] Y) {
		    int[][] transposedY = transposeMatrix(Y); 
		    return multiplyMatrix(X, transposedY); 
		}
	}

