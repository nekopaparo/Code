package data0527;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class P84 {

	public static void main(String[] args) throws IOException {
		
		int[] A_Z = new int[26];
		int[] a_z = new int[26];
		String filePath = "D:\\test.txt";//檔案位置
		FileReader fr = new FileReader(filePath);
		BufferedReader bfr = new BufferedReader(fr);
		String read;
		while( ( read = bfr.readLine() ) != null ){
			System.out.println(read);
			for(int i=0; i<read.length(); i++) {
				char chr = read.charAt(i);
				if(chr - 'A' < 26 && chr - 'A' >= 0)
					A_Z[chr - 'A'] ++;
				else if (chr - 'a' < 26 && chr - 'a' >= 0)
					a_z[chr - 'a'] ++;
			}
		}
		
		bfr.close();
		
		char A = 'A';
		for(int i:A_Z) {
			if(i!=0)
				System.out.println(A + ".出現" + i + "次");
			A++;
		}
		char a = 'a';
		for(int i:a_z) {
			if(i!=0)
				System.out.println(a + ".出現" + i + "次");
			a++;
		}
	}

}
