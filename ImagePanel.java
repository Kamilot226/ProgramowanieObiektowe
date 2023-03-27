package MojOgrodek;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ImagePanel extends JPanel
{
	private BufferedImage image;
	
	int x;
	int y;
	int skala;
	 
    public ImagePanel(String zdj, int X, int Y, int S)
    {
        super();
        
        this.setSize(1080,720);
        x=X;
        y=Y;
        skala=S;
        
        // Plik umieszczony w podpakiecie "obrazki"
        URL resource = getClass().getResource(zdj);        
        try
        {
            image = ImageIO.read(resource);
        }
        catch (IOException e)
        {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
 
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }
 
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(image, 0, 0, this);
       
        // SKALOWANIE WKLEJANEGO OBRAZKA:
        g2d.drawImage(image, x, y, image.getWidth()/skala, image.getHeight()/skala, this);
    }
}
