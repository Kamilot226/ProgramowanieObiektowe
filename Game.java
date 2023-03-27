package MojOgrodek;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		int width=1134;
		int height = 756;
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layers = new JLayeredPane();

		Game1 panel1 = new Game1();
		Game2 panel2 = new Game2("Grafika/kajtek.png",70,250,5);
		Game2 panel3 = new Game2("Grafika/pupil.png",0,110,5);
		Game2 panel4 = new Game2("Grafika/kwiatki.png",207,275,5);
		Game2 panel5 = new Game2("Grafika/budowa.png",140,20,5);
		
		Game2 panel6 = new Game2("Grafika/kajtek.png",60,35,6);
		Game2 panel7 = new Game2("Grafika/pupil.png",55,210,4);
		
		Game2 panel8 = new Game2("Grafika/pilka.png",0,250,13);
		
		panel2.setSize(1080,720);
		panel3.setSize(1080,720);
		panel4.setSize(1080,720);
		panel5.setSize(1080,720);
		panel8.setSize(1080,720);
		
		
		layers.add(panel1);
		layers.setLayer(panel1, JLayeredPane.DEFAULT_LAYER);
		
		layers.add(panel2);
		layers.setLayer(panel2, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel3);
		layers.setLayer(panel3, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel4);
		layers.setLayer(panel4, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel5);
		layers.setLayer(panel5, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel6);
		layers.setLayer(panel6, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel7);
		layers.setLayer(panel7, JLayeredPane.DRAG_LAYER);
		
		layers.add(panel8);
		layers.setLayer(panel8, JLayeredPane.DRAG_LAYER);
		
		
		JLabel imie = new JLabel("Kajtek");
		imie.setFont(new Font("Sans_Serif", Font.PLAIN, 30));
		layers.add(imie);
		layers.setLayer(imie, JLayeredPane.DRAG_LAYER);
		imie.setBounds(55,100,90,130);
		
		JLabel pupil = new JLabel("Pupilek");
		pupil.setFont(new Font("Sans_Serif", Font.PLAIN, 30));
		layers.add(pupil);
		layers.setLayer(pupil, JLayeredPane.DRAG_LAYER);
		pupil.setBounds(44,217,104,247);
		
		JLabel data = new JLabel("29.03.2023 10:32");
		data.setFont(new Font("Sans_Serif", Font.PLAIN, 23));
		layers.add(data);
		layers.setLayer(data, JLayeredPane.DRAG_LAYER);
		data.setBounds(30,444,200,474);
		
		JLabel hajs = new JLabel("$1234");
		hajs.setFont(new Font("Sans_Serif", Font.PLAIN, 30));
		layers.add(hajs);
		layers.setLayer(hajs, JLayeredPane.DRAG_LAYER);
		hajs.setBounds(30,410,200,440);
		
		JLabel glod = new JLabel("Głód");
		glod.setFont(new Font("Sans_Serif", Font.PLAIN, 40));
		layers.add(glod);
		layers.setLayer(glod, JLayeredPane.DRAG_LAYER);
		glod.setBounds(730,375,900,405);
		
		JLabel energia = new JLabel("Energia");
		energia.setFont(new Font("Sans_Serif", Font.PLAIN, 40));
		layers.add(energia);
		layers.setLayer(energia, JLayeredPane.DRAG_LAYER);
		energia.setBounds(710,419,880,449);
		
		JLabel szczescie = new JLabel("Szczęście");
		szczescie.setFont(new Font("Sans_Serif", Font.PLAIN, 40));
		layers.add(szczescie);
		layers.setLayer(szczescie, JLayeredPane.DRAG_LAYER);
		szczescie.setBounds(870,395,1040,425);
		
		frame.getContentPane().add(layers);
		
		frame.setVisible(true);
	}
}
