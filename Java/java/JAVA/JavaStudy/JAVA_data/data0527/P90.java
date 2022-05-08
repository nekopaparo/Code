package data0527;

public class P90 {
	static int[] grades = new int[2];
	
	public static void main(String[] args) throws InterruptedException {
		String[] contestants = {"A", "B"};
		for(int i=0; i<10; i++) {
			Thread A = new Run(0);
			Thread B = new Run(1);
			
			A.start();
			B.start();
			
			A.join();
		//	B.join();
			
		}
		for(int i=0; i<2; i++) {
			System.out.println( contestants[i] + ":" + grades[i]);
		}
	}

}
class Run extends Thread {
	int number;
	Run(int number){
		this.number = number;
	}
	public void run() {
		P90.grades[number] += (int)(Math.random()*10+1);
	}
}
