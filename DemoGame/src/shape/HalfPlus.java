package shape;

public class HalfPlus extends Shape{

	private int k = 1;
	public HalfPlus() {
		// TODO Auto-generated constructor stub
		int x[] = {300,300,250,350};
		int y[] = {0,-50,-50,-50};
		this.setX(x);
		this.setY(y);
	}

	@Override
	void setLocation() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void changeDirection(int x2[],int y2[]) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i<5;i++) {
		int x1 = this.getX()[1];
		int y1 = this.getY()[1];
		int x[] = this.getX();
		int y[] = this.getY();
		++k;
		if(k == 5) k=1;
		if(k == 1)
		{
			y[1] = y[2] = y[3] = y1;
			y[0] = y1+50;
			x[1] = x[0] = x1;
			x[2] = x1-50;x[3] = x1+50;
		}
		if(k == 2)
		{
			x[0] = x[1] = x[3] = x1;
			x[2] = x1+50;
			y[1] = y[2] = y1;
			y[0] = y1+50;y[3] = y1-50;
		}
		if(k == 3)
		{
			y[0] = y[1] = y[2] = y1;
			y[3] = y1-50;
			x[1] = x[3] = x1;
			x[0] = x1-50;x[2] = x1+50;
		}
		if(k == 4)
		{
			x[0] = x[1] = x[3] = x1;
			x[2] = x1-50;
			y[1] = y[2] = y1;
			y[0] = y1+50;y[3] = y1-50;
		}
		if(predictCheckCollison(x, y, x2, y2))
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
		int x[] = {100,100,50,150};
		int y[] = {175,125,125,125};
		setX(x);
		setY(y);
	}

}
