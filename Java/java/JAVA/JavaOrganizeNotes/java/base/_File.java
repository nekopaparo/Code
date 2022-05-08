package base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _File {
	// 基本write&read
	public static void main(String[] args) throws IOException {
		// 輸出至新檔案
		String filePath = "D:\\filetest.txt";
		FileWriter fw = new FileWriter(filePath);
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write("Hello Java\n");
		bfw.write("peko\n");
		bfw.write("neko");
		bfw.flush(); // bfw.write輸出至檔案中，如有bfw.close()可省略，因為buffere close前會先flush
		fw.close();

		// 讀取
		FileReader fr = new FileReader(filePath);
		BufferedReader bfr = new BufferedReader(fr);
		String read;
		while ((read = bfr.readLine()) != null) {
			System.out.println(read);
		}
		fr.close();

		ImageCopy.main(args);
	}

}

// 圖片複製 -> 圖片為二進位制檔案
class ImageCopy {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\93015981_p0_master1200.jpg";
		String newFilePath = "D:\\newtest.jpg";

		File f = new File(filePath);
		File nf = new File(newFilePath);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nf));

		int by = 0;
		while ((by = bis.read()) != -1) {
			bos.write(by);
		}

		bis.close();
		bos.close();
	}

}

// 檔案刪除改名讀取寫入
class FileCRUD {

	private String path; // 檔案路徑

	public FileCRUD() {
		// 預設當前class路徑
		path = this.getClass().getClassLoader().getResource(".").getPath();
	}

	// 指定路徑
	public FileCRUD(String path) {
		this.path = path;
	}

	// 顯示路徑
	public String site() {
		return path;
	}

	// 修改路徑
	public void set(String path) {
		this.path = path;
	}

	// 刪除檔案
	public void delete(String file) {
		File f = new File(path + file);
		if (f.exists()) {
			// 刪除
			f.delete();
			System.out.println("檔案刪除成功");
		} else {
			System.out.println("檔案不存在");
		}
	}

	// 修改檔名
	public void rename(String filename, String newFilename) {
		// 指定檔案
		String site = path + filename;
		// 開啟檔案
		File f = new File(site);
		// 檔案是否存在
		if (f.exists()) {
			// 改名
			f.renameTo(new File(path + newFilename));
			System.out.println("檔案改名成功");
		} else {
			System.out.println("檔案不存在");
		}
	}

	public BufferedReader read(String filename) throws FileNotFoundException {
		FileReader fr = new FileReader(path + filename);
		BufferedReader bfr = new BufferedReader(fr);
		return bfr;
	}

	public BufferedWriter write(String filename) throws IOException {
		FileWriter fw = new FileWriter(path + filename);
		BufferedWriter bfw = new BufferedWriter(fw);
		return bfw;
	}
}

// 英文字母計算
class LettersCount {
	public static void main(String[] args) throws IOException {

		int[] A_Z = new int[26];
		int[] a_z = new int[26];

		String filePath = "D:\\test.txt"; // 檔案位置
		FileReader fr = new FileReader(filePath);
		BufferedReader bfr = new BufferedReader(fr);
		String read;
		while ((read = bfr.readLine()) != null) {
			System.out.println(read);
			for (int i = 0; i < read.length(); i++) {
				char chr = read.charAt(i);
				if (chr - 'A' < 26 && chr - 'A' >= 0)
					A_Z[chr - 'A']++;
				else if (chr - 'a' < 26 && chr - 'a' >= 0)
					a_z[chr - 'a']++;
			}
		}
		bfr.close();

		char A = 'A';
		for (int i : A_Z) {
			if (i != 0)
				System.out.println(A + ".出現" + i + "次");
			A++;
		}
		char a = 'a';
		for (int i : a_z) {
			if (i != 0)
				System.out.println(a + ".出現" + i + "次");
			a++;
		}

	}
}