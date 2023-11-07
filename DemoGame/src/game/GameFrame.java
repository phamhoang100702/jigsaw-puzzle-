package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GamePanel panelGame;
	

	public GameFrame() {
		// TODO Auto-generated constructor stub
		panelGame = new GamePanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(panelGame, BorderLayout.WEST);
		setResizable(false);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		new GameFrame();
	}



}
