package data0526;

import java.io.*;


public class P80 {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\test.jpg";
		String newFilePath = "D:\\newtest.jpg";
		
		File fp = new File( filePath );
		File nfp = new File( newFilePath );
		
		BufferedInputStream bis = new BufferedInputStream( new FileInputStream(fp) );
		BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream(nfp) );
		
		int Intbis = 0;
		while( ( Intbis = bis.read() ) != -1){
			bos.write( Intbis );
		}
		
		
		bis.close();
		bos.close();
	}

}
