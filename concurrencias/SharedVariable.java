package concurrencias;

public class SharedVariable {
	
	private int value;
	
	static class Threads extends Thread {
	
	
	volatile private boolean hasDoneIt = false;
	
	public Threads (int v) {
		
		value = v;
		
	}
	
	public Threads () {
		
		value = 0;
		
	}
	
	public void setValue (int v) {
		
		while (this.hasDoneIt) {
			
			Thread.yield();
			
		}
		
		value = v;
		System.out.println(value);
		this.hasDoneIt = true;
		
	}
	
	public int getValue () {
		
		while (!this.hasDoneIt) {
			
			Thread.yield();
			
		}
		
		return value;
		
	}
	
	public void inc () {
		
		++value;
		System.out.println(value);
		
	}
	}
	
	public static void main (String[] args) {
		
		Threads a,b;
		int value = 0;
		
		
		a = new Threads(value);
		b = new Threads(value);
		
		a.start();
		b.start();
		
		for (int i = 0; i < 10; ++i) {
			
			a.inc();
			b.inc();
			
		}
		
	}

}


