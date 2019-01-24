/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

import java.beans.XMLEncoder;
import java.io.*;

/**
 *
 * @author Fanatic
 */
public class akwadrat {
    private double a;
    public akwadrat()
    { 
    }
    public void setA(double ax)
    {
        a=ax;
    }
    public double getA()
    {
        return a;
    }

    public double getkwadrat()
    {
        return a*a;
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
