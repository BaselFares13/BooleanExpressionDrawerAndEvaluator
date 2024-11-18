package GuiPackage;

import ExpressionPackage.Converter;
import GatePackage.Gate;
import ExpressionPackage.Expression;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TheDrawingPanel extends JPanel
{
    private Expression expression;
    
    public TheDrawingPanel(Expression expression)
    {
        setPreferredSize(new Dimension(700, 700));
        this.expression = expression;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawTheGates(g, 70, getHeight() / 2, expression.getGatesSystem(), getHeight() / 4); 
    }
    
    private void drawTheGates(Graphics g, int x, int y, Gate gate, int difference_between_y_and_future_y) 
    {
        try
        {
            int nodeSize = 35;
            int fontSize = 25;
    
            if(Converter.isOperator(gate.getVal())) 
            {
                gate.drawGate(g, x, y, nodeSize, false); 
            } 
            else 
            {
                gate.drawGate(g, x, y, fontSize, true); 
            }
        
            if(gate.getLeftGate()!= null) 
            {
                drawConnector(g, x, y, false, difference_between_y_and_future_y);
                drawTheGates(g, x + 40, y + difference_between_y_and_future_y, gate.getLeftGate(), difference_between_y_and_future_y / 2);
            }
            
            if(gate.getRightGate()!= null) 
            {
                drawConnector(g, x, y, true, difference_between_y_and_future_y);
                drawTheGates(g, x + 40, y - difference_between_y_and_future_y, gate.getRightGate(), difference_between_y_and_future_y / 2);
            }
        }
        catch(NullPointerException n)
        {
            return;
        }
    }

    private void drawConnector(Graphics g, int x, int y, boolean isRight, int difference_between_y_and_future_y) 
    {
        g.drawLine(x, y, x+20, y);       

        if(isRight)
        {
            g.drawLine(x+20, y, x+20, y-difference_between_y_and_future_y);
            g.drawLine(x+20, y-difference_between_y_and_future_y, x+40, y-difference_between_y_and_future_y);

        }
        else
        {
            g.drawLine(x+20, y, x+20, y+difference_between_y_and_future_y);
            g.drawLine(x+20, y+difference_between_y_and_future_y, x+40, y+difference_between_y_and_future_y);
        }
    }

    public Expression getExpression() 
    {
        return expression;
    }

    public void setExpression(Expression expression) 
    {
        this.expression = expression;
    }
    
    
}
