package shape;

public class BigRectangle extends Shape {

	private int rand = 1;

	public BigRectangle() {
		// TODO Auto-generated constructor stub
		int x[] = { 300, 300, 300, 300 };
		int y[] = { 0, -50, -100, -150 };
		this.setX(x);
		this.setY(y);
	}

	@Override
	void setLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIndexPreShape() {
		// TODO Auto-generated method stub
		int x[] = {100,100,100,100};
		int y[] = {225,175,125,75};
		setX(x);
		setY(y);

	}

	@Override
	public void changeDirection(int x1[], int y1[]) {
		// TODO Auto-generated method stub

		for (int j = 0; j < 2; j++) {
			int x[] = this.getX();
			int y[] = this.getY();
			++rand;
			if (rand == 3)
				rand = 1;
			if (rand == 2) {
				y[2] = y[3] = y[0] = y[1];
				int k = -50;
				for (int i = 0; i < 4; i++)
					x[i] = x[1] + k + i * 50;
			}
			if (rand == 1) {
				x[2] = x[3] = x[0] = x[1];
				int k = -50;
				for (int i = 0; i < 4; i++)
					y[i] = y[1] + k + i * 50;
			}
			if (this.predictCheckCollison(x, y, x1, y1)) {
				this.setX(x);
				this.setY(y);
				break;
			}
		}

	}

}
