package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	int score;
	public ScorePanel() {
		setBounds(0,250,250,350);
		setBackground(Color.darkGray);	
	}

	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,50));
		FontMetrics fm = g.getFontMetrics(g.getFont());
		g.drawString("SCORE", (250-fm.stringWidth("SCORE"))/2, 70);
		String s = String.valueOf(score);
		g.setFont(new Font("Serif",Font.PLAIN,120));
		g.drawString(s, (250-fm.stringWidth(s))/2-10, 200);
	}
}
