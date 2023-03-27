package MojOgrodek;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game2 extends JPanel
{
	public Game2(String plik, int X, int Y, int S)
	{
		int width=1080;
		int height = 720;
		this.setSize(width, height);
		//setLayout (new GridBagLayout());
		//setBackground(new Color(0,0,0,50));
		setOpaque(false);

		ImagePanel obrazek = new ImagePanel(plik,X,Y,S);
		setSize(obrazek.getPreferredSize());
		add(obrazek);
	}
}
