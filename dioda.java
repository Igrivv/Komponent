/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Fanatic
 */
public class dioda extends Canvas {
    private int rWidth,rHeight;
    private int x,y;
    private Color bg,frm;
    public dioda()
    {
       setPreferredSize(new Dimension(30,50));
       bg = Color.red;
       frm = Color.blue;
       int x = this.getLocation().x + this.getWidth()/4;
       int y = this.getLocation().y + this.getHeight()/2;
       this.setVisible(true);
    }
    public synchronized void paint(Graphics g) 
    { 
      
      rWidth = getWidth();
      rHeight = getHeight();
      g.setColor(Color.red);
      g.fillOval(x, y, rWidth, rHeight);
      g.setColor(Color.blue);
      g.drawOval(x, y, rWidth, rHeight);
    }
    public void setFrameColor(Color f)
    {
        frm = f;
    }
    public void setBackgroundColor(Color b)
    {
        bg = b;
    }
    public Color getFrameColor()
    {
        return frm;
    }
    public Color getBackgroundColor()
    {
        return bg;
    }
    public void setDiodeWidth(int w)
    {
        rWidth = w;
    }
    public void setDiodeHeight(int h)
    {
        rHeight = h;
    }
    public int getDiodeWidth()
    {
        return rWidth;
    }
    public int getDiodeHeight()
    {
        return rHeight;
    }
    public void serializeThis(String plik)
    {
        XMLEncoder encoder = null;
        try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(plik)));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("While Creating File <- Error");
		}
		encoder.writeObject(this);
		encoder.close();     
    }
}