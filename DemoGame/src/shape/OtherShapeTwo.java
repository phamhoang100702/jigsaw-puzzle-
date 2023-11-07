package shape;

public class OtherShapeTwo extends Shape{

	private int rand  = 1;
	public OtherShapeTwo() {
		// TODO Auto-generated constructor stub
		int x[] = {300,300,350,350};
		int y[] = {0,-50,-50,-100};
		this.setX(x);
		this.setY(y);
	}

	@Override
	void setLocation() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void changeDirection(int x1[],int y1[]) {
		// TODO Auto-generated method stub
		for(int i = 0;i<4;i++) {
		int x[] = this.getX();
		int y[] = this.getY();
		++rand;
		if(rand == 5) rand = 1;
		if(rand == 1)
		{
			y[2] = y[1];
			y[3] = y[2]-50;
			x[3] = x[2] = x[1] +50;
		}
		if(rand == 2)
		{
			y[2] = y[0];
			y[3] = y[1];
			x[2] = x[1] -50;
			x[3] = x[1] +50;
		}
		if(rand == 3)
		{
			y[2] = y[1];
			y[3] = y[2] -50;
			x[3] = x[2] = x[1] - 50;
		}
		if(rand == 4)
		{
			y[2] = y[0];
			y[3] = y[1];
			x[2] = x[1] + 50;
			x[3] = x[1] - 50;
		}
		if(predictCheckCollison(x, y, x1, y1))
		{
			this.setX(x);
			this.setY(y);
			break;
		}
		}
		
	}

	@Override
	public void setIndexPreShape() {
		// TODO Auto-generated method stub
		int x[] = {75,75,125,125};
		int y[] = {200,150,150,100};
		setX(x);
		setY(y);
	}

}
