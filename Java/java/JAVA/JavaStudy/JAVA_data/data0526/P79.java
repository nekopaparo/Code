package data0526;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class P79 {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\bingo.txt";//儲存位置
		FileWriter fw = new FileWriter(filePath, true);//true = 寫在後面
		BufferedWriter bfw = new BufferedWriter(fw);
		
		//產生10個
		for(int i=0; i<10; i++) {
			if(i<9) bfw.write( "\s" );
			bfw.write( i+1 + ".\s" );
			bfw.write( bingo() );
			bfw.newLine(); //寫入換行
		}
		bfw.flush();//寫入檔案
		fw.close();
	}
	
	static String bingo() {
		//隨機7個數字 1~49
		int[] intBingo = new int[7];
		for(int i = 0; i<7; ) {
			int rand = (int)(Math.random()*49+1);
			ck:{
				for(int ii=0; ii<i; ii++)
					if(intBingo[ii] == intBingo[i])
						break ck;
				intBingo[i] = rand;
				i++;
			}
		}
		//轉成字串
		String strBingo = "";
		for(int i:intBingo) {
			if(i<10) strBingo += "\s";
			strBingo += i;
			strBingo += "\s";
		}
		return strBingo;
	}
}

