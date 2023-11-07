package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test  {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()/1000);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()/1000);

	}
	public static void change(int a)
	{
		a = 100;
	}

}
