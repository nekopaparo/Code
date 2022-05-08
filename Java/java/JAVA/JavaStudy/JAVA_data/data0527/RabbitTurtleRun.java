package data0527;

public class RabbitTurtleRun {

	public static void main(String[] args) {
		int roadLength = 20;
		int turtleSpeed = 1;
		int rabbitSpeed = 3;
		
		Thread turtle = new Thread() {
			public void run() {
				for(int i =1; i<roadLength; i+=turtleSpeed) {
					try {
						Thread.sleep( 50 );
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("烏龜跑 " +  i);
				}
					
				System.out.println("烏龜到達終點...");
			}
		};
		Thread rabbit = new Thread( () -> { //簡化寫法，直接寫run()的內容
		
				for(int i =1; i<roadLength; i+=rabbitSpeed) {
					try {
						System.out.println("兔子睡覺中... ");
						Thread.sleep( (int)(Math.random()*500 ) );
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("兔子跑 " +  i);
				}
				System.out.println("兔子到達終點...");
		
		});
		rabbit.start();
		turtle.start();
	
	}

}
