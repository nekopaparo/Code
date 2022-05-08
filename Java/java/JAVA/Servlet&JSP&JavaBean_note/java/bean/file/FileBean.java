package bean.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBean {
	//檔案路徑
	private String path;
	
	public FileBean(){
		//預設當前class路徑
		path = this.getClass().getClassLoader().getResource(".").getPath();
	}
	//指定路徑
	public FileBean(String path) {
		this.path = path;
	}
	//顯示路徑
	public String getSite() {
		return path;
	}
	//修改路徑
	public void setSite(String path) {
		this.path = path;
	}
	//刪除檔案
	public void delFile(String name) {
		File file = new File(path + name);
		if(file.exists()) {
			//刪除
			file.delete();
			System.out.println("檔案刪除成功");
		}
		else {
			System.out.println("檔案不存在");
		}
	}
	//修改檔名
	public void rename(String filename, String newFilename) {
		//指定檔案
		String site = path + filename;
		//開啟檔案
		File file=new File(site);
		//檔案是否存在
		if(file.exists()) {
			//改名
			file.renameTo(new File(path + newFilename));
			System.out.println("檔案改名成功");
		}
		else {
			System.out.println("檔案不存在");
		}
	}
	public BufferedReader fileReader(String filename) throws FileNotFoundException  {
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	public BufferedWriter fileWriter(String filename) throws IOException {
		FileWriter fw = new FileWriter(path + filename);
		BufferedWriter bw = new BufferedWriter(fw);
		return bw;
	}
}
