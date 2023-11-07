package shape;

public class Square extends Shape{

	public Square() {
		// TODO Auto-generated constructor stub
		int x[] = {300,300,350,350};
		int y[] = {0,-50,0,-50};
		this.setX(x);
		this.setY(y);
	}

	@Override
	void setLocation() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void changeDirection(int x[],int y[]) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIndexPreShape() {
		// TODO Auto-generated method stub
		int x[] = {75,75,125,125};
		int y[] = {175,125,175,125};
		setX(x);
		setY(y);
		
	}

}
