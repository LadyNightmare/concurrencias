package concurrencias;

public class Abbccc {
	//Not needed for a)
	private static int turn;
	
	static class Threads extends Thread {
		
		private char letter;
		private int id;
		private int repetitions;
		
		public Threads(char letter, int id, int repetitions) {
			
			this.letter = letter;
			this.id = id;
			this.repetitions = repetitions;
			
		}
		
		public void run() {
			
			while(true) {
				
				//Not needed for a)
				
				while (id != turn) {
					
					Thread.yield();
					
				}
				
				for(int i = 0; i < repetitions; ++i) {
					
					System.out.println(letter);
					
				}
				
				//Not needed for a)
				
				++turn;
				
				if (turn == 3) {
					
					turn = 0;
					
				}
				
			}
			
		}
		
	}
	
	public static void main (String[] args) {
		
		Threads a,b,c;
		
		a = new Threads('a', 0, 1);
		b = new Threads('b', 1, 2);
		c = new Threads('c', 2, 3);
		
		a.start();
		b.start();
		c.start();
		
	}

}
