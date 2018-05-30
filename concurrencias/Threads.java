package concurrencias;

public class Threads extends Thread {
	
	SharedVariable2 sv;
	Peterson peterson;
	int times, id;
	
	public Threads (int id, SharedVariable2 sv, int times, Peterson p) {
		
		this.sv = sv;
		this.times = times;
		peterson = p;
		this.id = id;
	}
	
	public void run() {
		if (id==0) {
			for (int i = 0; i < times; ++i) {
			peterson.preProt0();
				sv.inc();
				peterson.postProt0();
			}	
		} else {
			for (int i = 0; i < times; ++i) {
				peterson.preProt1();
					sv.inc();
					peterson.postProt1();
				}
		}
		
		
	}
	
}
