package data0527;

public class P87 {

	public static void main(String[] args) {
		Thread T1 = new Tx("T1", 500);
		Thread T2 = new Tx("T2", 2000);
		T1.start();
		T2.start();
	}

}
class Tx extends Thread{
	String name;
	int time;
	Tx(String name, int time){
		this.name = name;
		this.time = time;
	}
	public void run() {
		int count = 5;
		for(int i = 1; i<count+1; i++) {
			try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "執行第:" + i + "次");
			
		}
	}
}
