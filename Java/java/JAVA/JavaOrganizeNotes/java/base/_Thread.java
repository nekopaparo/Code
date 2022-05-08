package base;

//多執行緒(Simultaneous multithreading)，簡單來說就是同步執行
public class _Thread {
	static boolean dinner = false;

	public static void main(String[] args) throws InterruptedException {
		Son son = new Son();
		Mom mom = new Mom();
		son.start();
		mom.start();
		son.join(); // son執行完畢才會往下繼續
		TurtleRabbitRun.main(args);
	}

}

//使用多執行緒 -> 繼承Thread
class Mom extends Thread {
	@Override
	public void run() {
		try {
			sleep(500);
			System.out.println("媽媽開始煮晚餐...");
			sleep(10000);
			System.out.println("經過15分鐘...");
			sleep(2000);
			System.out.println("完成晚餐...");
			_Thread.dinner = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Son extends Thread {
	@Override
	public void run() {
		try {
			sleep((int) (Math.random() * 1000) + 500);
			System.out.println("小明回家...");
			sleep(1000);
			while (!_Thread.dinner) {
				System.out.println("等媽媽煮飯...");
				sleep(5000);
			}
			System.out.println("小明開始吃飯");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class TurtleRabbitRun {
	static int roadLength = 20; // 賽程長度:可修改
	static int turtleSpeed = 1; // 烏龜速度:可修改
	static int rabbitSpeed = 3; // 兔子速度:可修改
	static int rabbitRestTime = 500; // 兔子最多停頓時間(毫秒):可修改

	public static void main(String[] args) {
		final int matches = 5; // 比賽次數:可修改
		System.out.println("------龜兔賽跑開始------");
		for (int count = 1; count < matches + 1; count++) {
			Contest contest = new Contest();
			Thread turtle = new Thread(contest.turtle);
			Thread rabbit = contest.new Rabbit(); // 巢狀類別的呼叫方式
			System.out.print("第" + count + "場 -> ");
			rabbit.start();// 開始跑
			turtle.start();// 開始跑
			try {
				rabbit.join();// *等待rabbit.start()結束
				turtle.join();// *等待turtle.start()結束
			} catch (InterruptedException e) { // 拋出例外
				e.printStackTrace();
			}
		}
	}

}

class Contest {
	private int win;

	Contest() {
		win = 0;
	}

	// 用Runnable()解決，Thread只能開啟一次的問題
	Runnable turtle = new Runnable() {
		public void run() {
			int time = TurtleRabbitRun.rabbitRestTime / 5;// 讓烏龜慢一點
			for (int i = 1; i < TurtleRabbitRun.roadLength;) {
				try {
					Thread.sleep(time); // 烏龜停頓100毫秒(0.1秒)
				} catch (InterruptedException e) { // 拋出例外
					e.printStackTrace();
				}
				i += TurtleRabbitRun.turtleSpeed;// 烏龜開跑turtleSpeed
			}
			if (win == 0) {
				System.out.println("烏龜贏");// 烏龜到達終點
				win++;
			}
		}
	};

	// 用類別解決，Thread只能開啟一次的問題
	class Rabbit extends Thread {
		@Override
		public void run() {
			for (int i = 1; i < TurtleRabbitRun.roadLength;) {
				try {
					Thread.sleep((int) (Math.random() * TurtleRabbitRun.rabbitRestTime));// 兔子隨機睡(停頓)500毫秒(0~0.5)
				} catch (InterruptedException e) { // 拋出例外
					e.printStackTrace();
				}
				i += TurtleRabbitRun.rabbitSpeed;// 兔子開跑rabbitSpeed
			}

			if (win == 0) {
				System.out.println("兔子贏");// 兔子到達終點
				win++;
			}
		}
	}
}
