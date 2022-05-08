package data0527;

public class P89 {

	public static void main(String[] args) throws InterruptedException {
		for(int count = 0; count<10; count++) {
			Print A = new Print("A",1000,count);
			Print B = new Print("B",2000,count);
			Print C = new Print("C",3000,count);
				
				A.start();
				B.start();
				C.start();
				
				A.join(); //A1執行完才會進A2，避免所有for同時運作
		}
	}

}
class Print extends Thread{
	String number;
	int time;
	int count;
	Print(String number, int time, int count){
		this.number = number;
		this.time = time;
		this.count = count+1;
	}
	public void run() {
		try {
			sleep( time );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(number + "...run..." + count);
	}
}
