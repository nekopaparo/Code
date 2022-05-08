package data0527;

public class P85 {
	static int roadLength = 20; //賽程長度:可修改
	static int turtleSpeed = 1; //烏龜速度:可修改
	static int rabbitSpeed = 3; //兔子速度:可修改
	static int time = 500; //停頓時間(毫秒):可修改
	public static void main(String[] args) {
		int matches = 10;//比賽次數:可修改
		for (int count = 1; count < matches+1; count++) { 
			Contest contest = new Contest(count);
			Thread turtle = new Thread(contest.turtle);
			Thread rabbit = contest.new Rabbit();//巢狀類別的呼叫方式
			rabbit.start();//開始跑
			turtle.start();//開始跑
			try {
				rabbit.join();// *等待Thread結束
			 //	turtle.join();// *等待Thread結束
			} catch (InterruptedException e) { // 拋出例外
				e.printStackTrace();
			}
		}
	}

}

class Contest {
	int count;
	int win;

	Contest(int count) {
		win = 0;
		this.count = count;
	}

/**/Runnable turtle = new Runnable() { //*用Runnable()解決，Thread只能開啟一次的問題
		public void run() {
			int time = P85.time / 5;//讓烏龜慢一點
			for (int i = 1; i < P85.roadLength; ) {
				try {
					Thread.sleep( time ); // 烏龜停頓100毫秒(0.1秒)
				} catch (InterruptedException e) { // 拋出例外
					e.printStackTrace();
				}
				i += P85.turtleSpeed;// 烏龜開跑turtleSpeed
			}
			if (win == 0) {
				System.out.println(count + ".烏龜贏");// 烏龜到達終點
				win++;
			}
		}
	};

/**/class Rabbit extends Thread{//*用類別解決，Thread只能開啟一次的問題
		public void run() {
			for (int i = 1; i < P85.roadLength; ) {
				try {
					Thread.sleep((int) (Math.random() * P85.time));// 兔子隨機睡(停頓)500毫秒(0~0.5)
				} catch (InterruptedException e) { // 拋出例外
					e.printStackTrace();
				}
				i += P85.rabbitSpeed;// 兔子開跑rabbitSpeed
			}

			if (win == 0) {
				System.out.println(count + ".兔子贏");// 兔子到達終點
				win++;
			}
		}
	}
}