package data0527;

public class P86 {

	public static void main(String[] args) {
		int time_a = 200;//a停頓時間(毫秒):可修改
		int time_b = 200;//b停頓時間(毫秒):可修改
		
		A a = new A( time_a );
		B b = new B( time_b );
		
		try {
			a.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		a.start();
		b.start();
	}
}
class A extends Thread{
	int time;
	A(int time){
		this.time = time;
	}
	public void run() {
		try {
			sleep( time );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A");
	}
}
class B extends Thread{
	int time;
	B(int time){
		this.time = time;
	}
	public void run() {
		try {
			sleep( time );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("B");
	}
}
