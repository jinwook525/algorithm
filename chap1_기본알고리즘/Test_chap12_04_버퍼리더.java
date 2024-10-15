package chap1_기본알고리즘;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

//12장 입출력 파일
public class Test_chap12_04_버퍼리더 {

	public static void main(String[] args) {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				System.out.println("*");
				out.write(buf, 0, len);
			}
			byte[] arr = out.toByteArray();
			String s2 = new String(buf);
			System.out.println(s2);
			String[] sa = s2.split(",|\n");
			for (String x : sa) {
				x = x.trim();
				System.out.print(" " + x);
			}
			System.out.println();
			String s = new String(arr);
			System.out.println(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}