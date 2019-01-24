/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JLabel;

/**
 *
 * @author Fanatic
 */
public class helloworld extends JLabel {
    String hello;
    public helloworld(){
    this.setText("HELLO THERE");}
    public void setHello(String h)
    {
        hello = h;
        this.setText(hello);
    }
    public String getHello()
    {
        return hello;
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
