package concurrencias;

public class SharedVariable2 {

	private int value;

	public void setValue(int v) {

		value = v;
		System.out.println(value);

	}

	public int getValue() {

		return value;

	}

	public void inc() {

		++value;


	}

}
