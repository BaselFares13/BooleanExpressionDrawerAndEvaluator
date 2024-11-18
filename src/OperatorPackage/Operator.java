package OperatorPackage;

import java.awt.Graphics;
import java.io.File;

public abstract class Operator 
{
    private char Symbol;
    private File image;

    public abstract String Performer(String str);
    
    public abstract void drawOperator(Graphics g, int x, int y, int size);
    
    public void setSymbol(char Symbol)
    {
        this.Symbol = Symbol;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public char getSymbol() 
    {
        return Symbol;
    }

    public File getImage() {
        return image;
    }
}
