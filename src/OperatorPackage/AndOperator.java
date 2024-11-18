package OperatorPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AndOperator extends Operator
{   
    private char orSymbol;
    
    public AndOperator()
    {
       super.setImage(new File("AND.png"));
       super.setSymbol('.');
       this.orSymbol = '+';
    }
    
    public AndOperator(char Symbol, char orSymbol)
    {
       super.setImage(new File("AND.png"));
       super.setSymbol('.');
       this.orSymbol = orSymbol;
    }
    
    @Override
    public String Performer(String str)
    {   
        int len = str.length();
        StringBuilder andEvaluatedExpression = new StringBuilder();        
        
        for(int i = 0; i < len-2 ; i++)
        {
            if(str.charAt(i) == '0' && str.charAt(i + 1) == super.getSymbol())
            {
               andEvaluatedExpression.append('0'); 
               i += 2;
            }
            else if(str.charAt(i) == '1' && str.charAt(i + 1) == super.getSymbol())
            {
                
                if(str.charAt(i + 2) == '0')
                {
                    andEvaluatedExpression.append('0');
                }
                else
                {
                    andEvaluatedExpression.append('1');
                }
                
                i += 2;
            }
            else if(str.charAt(i) == super.getSymbol())
            {
                if(andEvaluatedExpression.charAt(andEvaluatedExpression.length() - 1) == '1' && str.charAt(i+1) == '0')
                {
                    andEvaluatedExpression.deleteCharAt(andEvaluatedExpression.length() - 1);
                    andEvaluatedExpression.append('0');
                   
                }
                
                i++;
                
            }
            else 
            {
                andEvaluatedExpression.append(str.charAt(i));
            }
            
            
        }
        
        if(str.charAt(len - 2) ==  orSymbol) 
        {
            andEvaluatedExpression.append(str.charAt(len - 2));
            andEvaluatedExpression.append(str.charAt(len - 1));

        }
        else if(str.charAt(len - 2) == super.getSymbol())
        {
            if(andEvaluatedExpression.charAt(andEvaluatedExpression.length() - 1) == '1' && str.charAt(len-1) == '0')
                {
                    andEvaluatedExpression.deleteCharAt(andEvaluatedExpression.length() - 1);
                    andEvaluatedExpression.append('0');
                   
                }
        }
       
        return andEvaluatedExpression.toString();
    }

    public char getOrSymbol() {
        return orSymbol;
    }

    public void setOrSymbol(char orSymbol) {
        this.orSymbol = orSymbol;
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
