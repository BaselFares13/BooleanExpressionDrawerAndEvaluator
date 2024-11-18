package OperatorPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NegationOperator extends Operator
{
    public NegationOperator()
    {
       super.setImage(new File("NOT.png"));
       super.setSymbol('~');
    }
    
    public NegationOperator(char Symbol)
    {
       super.setImage(new File("NOT.png"));
       super.setSymbol('~');
    }
    
    @Override
    public String Performer(String str)
    {
       str = str.replaceAll( (super.getSymbol() + "1"), "0");
       str = str.replaceAll( (super.getSymbol() + "0"), "1");
       
       return str;
    }

    @Override
    public void drawOperator(Graphics g, int x, int y, int size) 
    {
        BufferedImage image = null;    
        try
        {   
            image = ImageIO.read(super.getImage()) ;                    
        }
        catch(IOException e)
        {
        e.printStackTrace();
        }     
 
        Image scaledImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, x - size, y - size/2, null);
    }
}
