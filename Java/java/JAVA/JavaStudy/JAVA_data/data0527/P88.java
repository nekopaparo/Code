package data0527;

public class P88 {
	public static void main(String[] args){
		Thread eat = new Thread(new Eatting());
		eat.start();
	}

}
class Eatting implements Runnable {
	public void run(){
		System.out.println("小明回家...");
		System.out.println("發現還沒煮飯...");
		Thread mom = new Thread(new Cooking());
		mom.start();
		try {
			mom.join();
		} catch (InterruptedException e) {
			System.out.println("煮太慢不想吃了");
		}
		System.out.println("小明開始吃飯..."); 
	}
}
class Cooking implements Runnable{
	public void run() {
		System.out.println("媽媽開始煮晚餐...");
		try {	
			Thread.sleep( 10000 );
			System.out.println("經過15分鐘...");
			Thread.sleep( 2000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("完成晚餐...");
	}
}


/*
 Thread.sleep( 1000 );
			while(P88.dinner == false) {
				System.out.println("等媽媽煮飯...");
				Thread.sleep( 5000 );
			}
			
 */
