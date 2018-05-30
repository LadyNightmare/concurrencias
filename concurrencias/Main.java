package concurrencias;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SharedVariable2 sv = new SharedVariable2();
		int times=1000000;
		Peterson p = new Peterson();
		Threads a = new Threads(0, sv,times, p);
		Threads b = new Threads(1, sv,times, p);
		
		a.start();
		b.start();
		
		
	try {
		
		a.join();
		b.join();
		
	} catch (InterruptedException e) {
		
		
	}
		
	System.out.println(sv.getValue());
	
	}

}
