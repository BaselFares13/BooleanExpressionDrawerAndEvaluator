package OperatorPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OrOperator extends Operator
{ 
    public OrOperator()
    {
       super.setImage(new File("OR.png"));
       super.setSymbol('+');
    }
    
    public OrOperator(char Symbol)
    {
        super.setImage(new File("OR.png"));
        super.setSymbol('+');    
    }
    
    @Override
    public String Performer(String str)
    {
        if(str.length() == 1) return str;
       
        int len = str.length();
        StringBuilder orEvaluatedExpression = new StringBuilder();        
        
        for(int i = 0; i < len ; i++)
        {
            if(str.charAt(i) == '1')
            {
               orEvaluatedExpression.append('1');
               return orEvaluatedExpression.toString();
            }
            else if(str.charAt(i) == '0')
            {
                
                if(str.charAt(i + 2) == '1')
                {
                    orEvaluatedExpression.append('1');
                    return orEvaluatedExpression.toString();
                }
                else
                {
                    orEvaluatedExpression.append('0');
                }
                
                i += 2;
            }
            else if(str.charAt(i) == super.getSymbol())
            {
                if(orEvaluatedExpression.charAt(orEvaluatedExpression.length() - 1) == '0' && str.charAt(i+1) == '1')
                {
                    orEvaluatedExpression.deleteCharAt(orEvaluatedExpression.length() - 1);
                    orEvaluatedExpression.append('1');
                    return orEvaluatedExpression.toString();
                }
                
                i++;
                
            }
           
        }
        
           
        return orEvaluatedExpression.toString();
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
