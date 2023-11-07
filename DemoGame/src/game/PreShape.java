package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import shape.BigRectangle;
import shape.HalfPlus;
import shape.OtherShape;
import shape.OtherShapeTwo;
import shape.Shape;
import shape.Square;

public class PreShape extends JPanel{

	private int color1,color2,color3;
	private int preShape;
	//Random random;
	public PreShape() {
		// TODO Auto-generated constructor stub
		//random = new Random();
		setBounds(0,0,250,250);
		
	}
	
	
	public int getColor1() {
		return color1;
	}


	public void setColor1(int color1) {
		this.color1 = color1;
	}


	public int getColor2() {
		return color2;
	}


	public void setColor2(int color2) {
		this.color2 = color2;
	}


	public int getColor3() {
		return color3;
	}


	public void setColor3(int color3) {
		this.color3 = color3;
	}


	public int getPreShape() {
		return preShape;
	}


	public void setPreShape(int preShape) {
		this.preShape = preShape;
	}
	
	
	public void setShape(int preShape,int color1,int color2,int color3)
	{
		setColor1(color1);
		setColor2(color2);
		setColor3(color3);
		setPreShape(preShape);
		repaint();
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Shape shape = pickShape(preShape);
		shape.setIndexPreShape();
		for(int i = 0;i<4;i++)
		{
			g.setColor(new Color(color1,color2,color3));
			g.fillRect(shape.getX()[i], shape.getY()[i]-50, 50, 50);
		}
	}
	
	private Shape pickShape(int i) {
		switch (i) {
		case 0:
			return new BigRectangle();
		case 1:
			return new HalfPlus();
		case 2:
			return new OtherShape();
		case 3:
			return new OtherShapeTwo();
		case 4:
			return new Square();
		default:
			return null;
		}
	}

}
