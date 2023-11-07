package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.text.PlainDocument;

import shape.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	
	static final int GAME_HEIGHT = 600;
	static final int GAME_WIDTH = 600;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNIT = (GAME_HEIGHT * GAME_WIDTH) / UNIT_SIZE;
	private UnitGame unitG[] = new UnitGame[GAME_UNIT];
	private boolean running = false;
	private Shape shape;
	private final int GAME_DELAY = 350;
	private Timer time;
	private int index = 0;
	private int color1, color2, color3;
	private int pre[];
	private Random random;
	private RightPanel rightPanel;
	private long startTime ;
	
	public GamePanel() {
		rightPanel = new RightPanel();
		pre = new int[4];
		setPreferredSize(new Dimension(850, 600));
		setLayout(null);
		add(rightPanel);
		setBackground(Color.black);
		setFocusable(true);
		addKeyListener(new MyKeyAdapter());
		start();
	}
	



	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		draw(g);
	}

	private void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= GAME_HEIGHT / UNIT_SIZE; i++) {
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, GAME_HEIGHT);
			g.drawLine(0, i * UNIT_SIZE, GAME_WIDTH, i * UNIT_SIZE);
		}

		for (int i = 0; i < index; i++) {
			g.setColor(new Color(unitG[i].color1, unitG[i].color2, unitG[i].color3));
			g.fillRect(unitG[i].x, unitG[i].y, UNIT_SIZE, UNIT_SIZE);
		}

		for (int i = 0; i < shape.getX().length; i++) {
			g.setColor(new Color(color1, color2, color3));
			g.fillRect(shape.getX()[i], shape.getY()[i] - 50, UNIT_SIZE, UNIT_SIZE);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free",Font.BOLD,50));
		
		FontMetrics font = g.getFontMetrics(g.getFont());
		g.drawString("TIME", (GAME_WIDTH-font.stringWidth("TIME"))/2, 100);
		long nowTime = System.currentTimeMillis()/1000-startTime;
		String nowTime1 = String.valueOf(nowTime);
		g.drawString(nowTime1, (GAME_WIDTH-font.stringWidth(nowTime1))/2, 200);
	

	}

	private void start() {
		running = true;
		random = new Random();
		preShape();
		newShape();
		time = new Timer(GAME_DELAY, this);
		time.start();
		startTime = System.currentTimeMillis()/1000;

	}

	public  void newShape() {
		
		shape = pickShape(pre[0]);
		color1 = pre[1];
		color2 = pre[2];
		color3 = pre[3];
		preShape();
		
		//return shape;
	}
	
	public void preShape()
	{
		pre[0] = random.nextInt(0,5);
		 //shape = pickShape(k);
		pre[1] = random.nextInt(0,255);
		pre[2] = random.nextInt(0,255);
		pre[3] = random.nextInt(0,255);
		rightPanel.setPreShape(pre[0], pre[1], pre[2], pre[3]);
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

	int checkColision() {
		if (checkShape()) {

			for (int i = 0; i < shape.getX().length; i++) {
				this.unitG[index] = new UnitGame();
				this.unitG[index].x = shape.getX()[i];
				this.unitG[index].y = shape.getY()[i] - 50;
				this.unitG[index].color1 = color1;
				this.unitG[index].color2 = color2;
				this.unitG[index].color3 = color3;
				index++;
			}
			repaint();
			checkEnd();
			newShape();
			checkHoriontal();
			return 1;
		}
		return 0;

	}

	private boolean checkShape() {
		for (int i = 0; i < shape.getX().length; i++) {
			int x = shape.getX()[i];
			int y = shape.getY()[i];
			for (int j = index - 1; j >= 0 && index != 0; j--) {

				if (y == this.unitG[j].y && (x == this.unitG[j].x)) {
					return true;
				}
			}
			if (y == 600) {
				return true;
			}

		}
		return false;
	}

	void checkFit() {

	}

	void checkEnd() {

		for (int i = index - 1; i >= 0 && index != 0; i--) {
			if (this.unitG[i].y < 0) {
				JOptionPane.showMessageDialog(this.getParent(), "END");
				time.stop();
				break;
			}
		}
	}

	private void checkHoriontal() {
		if (index < 10)
			return;
		int x[] = new int[20];
		for (int i = 0; i < 12; i++) {
			x[i] = 0;
		}

		for (int i = index - 1; i >= 0 && index != 0; i--) {
			if(this.unitG[i].y < 0) return;
			x[this.unitG[i].y / 50]++;
		}

		int check = 0;
		for (int i = 0; i < 12; i++) {
			if (x[i] == 12) {
				check = 1;
				for (int j = index - 1; j >= 0 && x[i] >= 0; j--) {
					if (this.unitG[j] != null && this.unitG[j].y / 50 == i) {
						unitG[j] = null;
						x[i]--;
					}
					if (this.unitG[j] != null && x[this.unitG[j].y / 50] != 12 && this.unitG[j].y / 50 < i) {
						unitG[j].y += 50;
					}
				}
				rightPanel.plusScore();
			}
		}
		if (check == 0)
			return;
		UnitGame unitG[] = new UnitGame[GAME_UNIT];
		int newIndex = 0;
		for (int i = 0; i < index; i++) {
			if (this.unitG[i] != null) {
				unitG[newIndex++] = this.unitG[i];
			}
		}
		this.unitG = unitG;
		unitG = null;
		index = newIndex;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (running == true) {
			this.shape.move();
			checkColision();
		} else {
			time.stop();
		}
		repaint();
	}

	public boolean isRunning() {
		return running;
	}



	private class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int x[] = new int[GAME_UNIT];
			int y[] = new int[GAME_UNIT];
			for (int i = 0; i < index; i++) {
				x[i] = unitG[i].x;
				y[i] = unitG[i].y;
			}

			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				shape.moveLeft(x, y);
				checkColision();
				break;
			case KeyEvent.VK_RIGHT:
				shape.moveRight(x, y);
				checkColision();
				break;
			case KeyEvent.VK_DOWN:
				shape.fastMoveP(x, y);
				checkColision();
				break;
			case KeyEvent.VK_UP:
				shape.changeDirection(x, y);
				break;
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int x[] = new int[GAME_UNIT];
			int y[] = new int[GAME_UNIT];
			for (int i = 0; i < index; i++) {
				x[i] = unitG[i].x;
				y[i] = unitG[i].y;
			}

			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				shape.moveLeft(x, y);
				checkColision();
				break;
			case KeyEvent.VK_RIGHT:
				shape.moveRight(x, y);
				checkColision();
				break;
			case KeyEvent.VK_DOWN:
				shape.fastMoveP(x, y);
				checkColision();
				break;
			case KeyEvent.VK_UP:
				shape.changeDirection(x, y);
				break;
			}

		}
	}

}
