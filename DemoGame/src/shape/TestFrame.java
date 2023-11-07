package shape;

import java.util.Random;

public class TestFrame {

	public TestFrame() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String[] args) {
		Random radom = new Random();
		for(int i = 0;i<10;i++) {
		int x  = radom.nextInt(0,9);
		System.out.println(x);}
	}

}
