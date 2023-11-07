package shape;

public abstract class Shape {

	private int x[];
	private int y[];

	public int[] getX() {
		int x[] = new int[this.x.length];
		for (int i = 0; i < x.length; i++) {
			x[i] = this.x[i];
		}
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		int y[] = new int[this.x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = this.y[i];
		}
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	abstract void setLocation();

	public void firstLocation(int xx) {
		x[0] = xx;
		y[0] = 0;
	}

	public void setIndexArrayX(int i, int k) {
		this.x[i] = k;
	}

	public void setIndexArrayY(int i, int k) {
		this.y[i] = k;
	}

	private int[] fastMove(int x1[], int y1[]) {
		int x[] = getX();
		int y[] = getY();
		while(true)
		{
			for(int i = 0;i<y.length;i++)
			{
				if(y[i]==600) return y;
				for (int j = x1.length - 1; j >= 0; j--) {
					if (y[i] == y1[j] && (x[i]== x1[j])) {
						return y;
					}
				}
			}
			for(int i = 0;i<y.length;i++)
			{
				y[i]+=50;
			}
			
		}
	}
	
	public void fastMoveP(int x1[],int y1[]) {
		int y[] = fastMove(x1, y1);
		this.y = y;
	}

	public void move() {
		if (y[0] == 600)
			return;
		for (int i = 0; i < this.x.length; i++) {
			this.y[i] += 50;
		}
	}

	public void moveLeft(int x2[], int y[]) {

		int x1[] = this.getX();
		for (int i = 0; i < this.x.length; i++) {
			x1[i] -= 50;
		}
		if (predictCheckCollison(x1, this.getY(), x2, y)) {
			for (int i = 0; i < x1.length; i++) {
				this.setIndexArrayX(i, x1[i]);
			}
		}
	}

	public void moveRight(int x2[], int y2[]) {
		int x1[] = this.getX();
		for (int i = 0; i < this.x.length; i++) {
			x1[i] += 50;
		}
		if (predictCheckCollison(x1, this.getY(), x2, y2)) {
			for (int i = 0; i < x1.length; i++) {
				this.setIndexArrayX(i, x1[i]);
			}
		}
	}

	abstract public void changeDirection(int x[], int y[]);

	public boolean predictCheckCollison(int x[], int y[], int x1[], int y1[]) {
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			int x2 = x[i];
			int y2 = y[i];
			if (x2 < 0 || y2 > 600 || x2 > 550)
				return false;
			for (int j = x1.length - 1; j >= 0; j--) {
				if (y2 == y1[j] && (x2 == x1[j])) {
					return false;
				}

			}
		}
		return true;
	}
	
	abstract public void setIndexPreShape();

}
