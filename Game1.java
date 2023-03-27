package MojOgrodek;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game1 extends JPanel
{
	static final int szer=150;//wartosc domyslna 150
	static final int wys=(int)(szer*2/3);
	Color grass = new Color(88, 138, 66);//123, 199, 66 | 252, 227, 134 | 88, 138, 66
	Color grass2 = new Color(58, 89, 44);//75, 120, 42 | 194, 175, 107 | 58, 89, 44
	Color edge = new Color(0,0,0);
	Color house = new Color(110, 110, 110);//133, 81, 181 | 87, 64, 15 | 110, 110, 110
	Color floor = new Color(201, 162, 113);
	Color door = new Color(61, 34, 0);
	Color okno = new Color(149, 230, 224);
	Color garden = new Color(110, 68, 14);
	Color profile = new Color(255,255,255);
	Color stats = new Color(255,255,255);
	Color statLevel = new Color(0,255,0);
	Color menu = new Color(109, 192, 201);
	Color carpet = new Color(119, 201, 52);//235, 75, 47 | 247, 144, 0 | 119, 201, 52
	Color carpet2 = new Color(55, 122, 0);//171, 55, 34 | 194, 113, 0 | 55, 122, 0
	Color fridge = new Color(150, 150, 150);
	Color bed = new Color(58, 54, 186);//232, 56, 56 | 201, 107, 171 | 58, 54, 186
	Color bowl = new Color(145, 0, 0);
	
	int glod;
	int energia;
	int szczescie;
	
	public Game1()
	{
		int width=1080;
		int height = 720;
		this.setSize(width, height);
		setLayout (new GridLayout(wys,szer));
		JPanel panel[][] = new JPanel[wys][szer];
		
		glod=5;
		energia=5;
		szczescie=10;
		
		for(int i=0;i<wys;i++)//tworzenie paneli do gridlayoutu + trawa
		{
			for(int j=0;j<szer;j++)
			{
				panel[i][j] = new JPanel();
				
				panel[i][j].setBackground(grass);
				if((Math.random()*100)>95)panel[i][j].setBackground(grass2);
					
				add(panel[i][j]);
			}
		}
		
		//--------TLO / WYPELNIENIE----------
		
		for(int i=1;i<=(wys/2)-1;i++)//profile
		{
			for(int j=1;j<=szer/7-1;j++)
			{
				panel[i][j].setBackground(profile);
			}
		}
		
		for(int i=wys-2;i>=(wys-(wys/12)+1);i--)//pole czasu/daty
		{
			for(int j=1;j<=szer/5-1;j++)
			{
				panel[i][j].setBackground(stats);
			}
		}
		
		for(int i=wys-(wys/12)-1;i>=(int)((1+wys-(wys/6.5)));i--)//pole hajsu
		{
			for(int j=1;j<=szer/7-1;j++)
			{
				panel[i][j].setBackground(stats);
			}
		}
		
		for(int i=wys-2;i>=(wys-(wys/4)+1);i--)//pole statystyk
		{
			for(int j=szer-2;j>=3*szer/5+1;j--)
			{
				panel[i][j].setBackground(stats);
			}
		}
		
		for(int i=wys/31;i<=3*wys/31;i++)//pole menu
		{
			for(int j=3*szer/5+wys/2+1;j<=39*szer/40-1;j++)
			{
				panel[i][j].setBackground(menu);
			}
		}
				
		for(int i=13*wys/36+1;i<=11*wys/18-1;i++)//pole uprawne
		{
			for(int j=14*szer/30+1;j<=14*szer/25-1;j++)
			{
				panel[i][j].setBackground(garden);
			}
		}
				
		for(int i=wys/9+1;i<=wys/9+wys/2-1;i++)//dom - podloga
		{
			for(int j=3*szer/5+1;j<=3*szer/5+wys/2-1;j++)
			{
				panel[i][j].setBackground(floor);
			}
		}
		
		for(int i=wys/9+wys/10;i<=wys/9+wys/2-wys/10;i++)//dom - dywan
		{
			for(int j=3*szer/5+wys/10;j<=3*szer/5+wys/2-wys/10;j++)
			{
				panel[i][j].setBackground(carpet);
				//if((Math.random()*100)>95)panel[i][j].setBackground(carpet2);
				panel[wys/9+wys/10][j].setBackground(carpet2);
				panel[wys/9+wys/2-wys/10][j].setBackground(carpet2);
			}
			panel[i][3*szer/5+wys/10].setBackground(carpet2);
			panel[i][3*szer/5+wys/2-wys/10].setBackground(carpet2);
		}
		
		for(int i=5*wys/9;i<=6*wys/9-wys/13;i++)//dom - lodówka
		{
			for(int j=3*szer/5+szer/30;j<=3*szer/5+wys/2-szer/5;j++)
			{
				panel[i][j].setBackground(fridge);
			}
		}
		
		for(int i=wys/9+wys/30;i<=2*wys/9-wys/30;i++)//dom - miska
		{
			for(int j=3*szer/5+szer/9;j<=3*szer/5+3*szer/20;j++)
			{
				panel[i][j].setBackground(bowl);
				if((Math.random()*100)>70)panel[i][j].setBackground(Color.yellow);
			}
		}
		
		for(int i=wys/9+wys/30;i<=2*wys/9-wys/35;i++)//dom - łóżko - poduszka
		{
			for(int j=5*szer/6;j<=5*szer/6+wys/10;j++)
			{
				panel[i][j].setBackground(new Color(240, 240, 240));
			}
		}
		for(int i=2*wys/9-wys/35;i<=2*wys/9+wys/10;i++)//dom - łóżko - koc
		{
			for(int j=5*szer/6;j<=5*szer/6+wys/10;j++)
			{
				panel[i][j].setBackground(bed);
			}
		}
		
		for(int i=(szer-13*szer/36);i<=(szer-szer/5);i++)//poziom glodu
		{
			for(int j=wys-(5*wys/36);j>=wys-(wys/6);j--)
			{
				panel[j][i].setBackground(statLevel);
			}
		}
		
		for(int i=szer-szer/5;i>=(szer-13*szer/36);i--)//poziom energii
		{
			for(int j=wys-(5*wys/36)+wys/10;j>=wys-(wys/6)+wys/10;j--)
			{
				panel[j][i].setBackground(statLevel);
			}
		}
		
		for(int i=4*szer/5+7*szer/38;i>=23*szer/36+7*szer/38;i--)//poziom szczescia
		{
			for(int j=wys-(5*wys/36)+wys/18;j>=wys-(wys/6)+wys/18;j--)
			{
				panel[j][i].setBackground(statLevel);
			}
		}
		
		//------KRAWEDZIE--------
		
		for(int i=0;i<wys;i++)//pionowe krawedzie ekranu
		{
			panel[i][0].setBackground(edge);//lewa
			panel[i][szer-1].setBackground(edge);//prawa
		}
		for(int i=0;i<szer;i++)//poziome krawedzie ekranu
		{
			panel[0][i].setBackground(edge);//gorna
			panel[wys-1][i].setBackground(edge);//dolna
		}
		
		for(int i=0;i<=(wys/2);i++)//pionowa linia profilów
		{
			panel[i][szer/7].setBackground(edge);
		}
		for(int i=0;i<=szer/7;i++)//poziome linie profilów
		{
			panel[(wys/2)][i].setBackground(edge);//od dołu, pierwsza
			panel[(wys/2)-wys/15][i].setBackground(edge);//druga
			panel[(wys/4)][i].setBackground(edge);//trzecia
			panel[(wys/4)-wys/15][i].setBackground(edge);//czwarta
		}
		
		for(int i=0;i<=szer/5;i++)//pozioma linia czasu/daty
		{
			panel[wys-(wys/12)][i].setBackground(edge);//od dołu, pierwsza
		}
		for(int i=wys-1;i>=(wys-(wys/12));i--)//pionowa linia czasu/daty
		{
			panel[i][szer/5].setBackground(edge);
		}
		
		for(int i=0;i<=szer/7;i++)//pozioma linia hajsu
		{
			panel[(int)(wys-(wys/6.5))][i].setBackground(edge);
		}
		for(int i=wys-(wys/12);i>=(int)((wys-(wys/6.5)));i--)//pionowa linia hajsu
		{
			panel[i][szer/7].setBackground(edge);
		}
		
		for(int i=szer-1;i>=(szer-2*szer/5);i--)//pozioma linia statystyk
		{
			panel[wys-(wys/4)][i].setBackground(edge);
		}
		for(int i=wys-1;i>=(wys-(wys/4));i--)//pionowa linia statystyk
		{
			panel[i][szer-2*szer/5].setBackground(edge);
		}
		
		for(int i=szer-szer/5;i>=(szer-13*szer/36);i--)//poziome linie glodu
		{
			panel[wys-(6*wys/36)][i].setBackground(edge);//gorna
			panel[wys-(5*wys/36)][i].setBackground(edge);//dolna
		}
		for(int i=wys-(5*wys/36);i>=wys-(wys/6);i--)//pionowe linie glodu
		{
			panel[i][szer-szer/5].setBackground(edge);//prawa
			panel[i][(szer-13*szer/36)].setBackground(edge);//lewa
		}
		
		for(int i=szer-szer/5;i>=(szer-13*szer/36);i--)//poziome linie energii
		{
			panel[wys-(6*wys/36)+wys/10][i].setBackground(edge);//gorna
			panel[wys-(5*wys/36)+wys/10][i].setBackground(edge);//dolna
		}
		for(int i=wys-(5*wys/36)+wys/10;i>=wys-(wys/6)+wys/10;i--)//pionowe linie energii
		{
			panel[i][szer-szer/5].setBackground(edge);//prawa
			panel[i][(szer-13*szer/36)].setBackground(edge);//lewa
		}
		
		for(int i=4*szer/5+7*szer/38;i>=23*szer/36+7*szer/38;i--)//poziome linie szczescia
		{
			panel[wys-(6*wys/36)+wys/18][i].setBackground(edge);//gorna
			panel[wys-(5*wys/36)+wys/18][i].setBackground(edge);//dolna
		}
		for(int i=wys-(5*wys/36)+wys/18;i>=wys-(wys/6)+wys/18;i--)//pionowe linie szczescia
		{
			panel[i][4*szer/5+7*szer/38].setBackground(edge);//prawa
			panel[i][23*szer/36+7*szer/38].setBackground(edge);//lewa
		}
		
		for(int i=wys/9;i<=wys/9+wys/2;i++)//pionowe krawedzie domu
		{
			panel[i][3*szer/5].setBackground(house);//lewa
			panel[i][3*szer/5+wys/2].setBackground(house);//prawa
		}
		for(int i=3*szer/5;i<=3*szer/5+wys/2;i++)//poziome krawedzie domu
		{
			panel[wys/9][i].setBackground(house);//gorna
			panel[wys/9+wys/2][i].setBackground(house);//dolna
		}
		
		for(int i=wys/9+wys/30;i<=2*wys/9-wys/35;i++)//dom - łóżko - góra
		{
			for(int j=5*szer/6;j<=5*szer/6+wys/10;j++)
			{
				panel[wys/9+wys/30][j].setBackground(edge);
				panel[2*wys/9-wys/35][j].setBackground(edge);
				panel[i][5*szer/6].setBackground(edge);
				panel[i][5*szer/6+wys/10].setBackground(edge);
			}
		}
		for(int i=2*wys/9-wys/35;i<=2*wys/9+wys/10;i++)//dom - łóżko - dół
		{
			for(int j=5*szer/6;j<=5*szer/6+wys/10;j++)
			{
				panel[2*wys/9+wys/10][j].setBackground(edge);
				panel[2*wys/9-wys/35][j].setBackground(edge);
				panel[i][5*szer/6].setBackground(edge);
				panel[i][5*szer/6+wys/10].setBackground(edge);
			}
		}
		
		for(int i=5*wys/9;i<=6*wys/9-wys/13;i++)//dom - lodówka
		{
			for(int j=3*szer/5+szer/30;j<=3*szer/5+wys/2-szer/5;j++)
			{
				panel[5*wys/9-1][j].setBackground(edge);
				panel[6*wys/9-wys/13+1][j].setBackground(edge);
				panel[i][3*szer/5+szer/30].setBackground(edge);
				panel[i][3*szer/5+wys/2-szer/5].setBackground(edge);
			}
		}
		
		for(int i=wys/9+wys/30;i<=2*wys/9-wys/30;i++)//dom - miska
		{
			for(int j=3*szer/5+szer/9;j<=3*szer/5+3*szer/20;j++)
			{
				panel[wys/9+wys/30][j].setBackground(edge);
				panel[2*wys/9-wys/30][j].setBackground(edge);
				panel[i][3*szer/5+szer/9].setBackground(edge);
				panel[i][3*szer/5+3*szer/20].setBackground(edge);
			}
		}
		
		for(int i=wys/9+wys/23;i<=11*wys/36;i++)//drzwi
		{
			panel[i][3*szer/5].setBackground(door);
		}
		
		for(int i=3*szer/5+szer/18;i<=3*szer/5+wys/2-szer/6;i++)//okno - góra
		{
			panel[wys/9][i].setBackground(okno);
		}
		
		for(int i=3*szer/5+szer/18+szer/9;i<=3*szer/5+wys/2-szer/6+szer/9;i++)//okno - dół
		{
			panel[wys/9+wys/2][i].setBackground(okno);
		}
		
		for(int i=13*wys/36;i<=11*wys/18;i++)//pionowe krawedzie pola uprawnego
		{
			panel[i][14*szer/30].setBackground(edge);//lewa
			panel[i][14*szer/25].setBackground(edge);//prawa
		}
		for(int i=14*szer/30;i<=14*szer/25;i++)//poziome krawedzie pola uprawnego
		{
			panel[13*wys/36][i].setBackground(edge);//gorna
			panel[11*wys/18][i].setBackground(edge);//dolna
		}
		
		for(int i=wys/31;i<=3*wys/31;i++)//pionowe krawedzie menu
		{
			panel[i][3*szer/5+wys/2].setBackground(edge);//lewa
			panel[i][39*szer/40].setBackground(edge);//prawa
		}
		for(int i=3*szer/5+wys/2;i<=39*szer/40;i++)//glowne poziome krawedzie menu
		{
			panel[wys/31][i].setBackground(edge);//gorna
			panel[3*wys/31][i].setBackground(edge);//dolna
		}
		for(int i=3*szer/5+wys/2+2;i<=39*szer/40-2;i++)//srodkowe poziome krawedzie menu
		{
			panel[wys/31+2][i].setBackground(edge);//srodek gora
			panel[3*wys/31-2][i].setBackground(edge);//srodek dol
		}
		
	}
	
}
