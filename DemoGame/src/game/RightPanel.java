package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class RightPanel extends JPanel{

	private PreShape preShape ;
	private ScorePanel scorePanel;
	public RightPanel() {
		// TODO Auto-generated constructor stub
		
		preShape = new PreShape();
		scorePanel = new ScorePanel();
		setBounds(600,0,250,600);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		add(preShape);
		add(scorePanel);
		//setVisible(true);
		
	}
	
	public void setPreShape(int pre,int color1,int color2,int color3)
	{
		preShape.setShape(pre, color1, color2, color3);
		//preShape.repaint();
	}
	
	public void plusScore()
	{
		scorePanel.score = scorePanel.score+1;
	}

}
