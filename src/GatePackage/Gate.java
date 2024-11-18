package GatePackage;

import OperatorPackage.BooleanOperators;
import java.awt.Font;
import java.awt.Graphics;

public class Gate 
{
    private char val;
    private Gate leftGate;
    private Gate rightGate;
    private BooleanOperators boolOp;

    public Gate(char val) {
        this.val = val;
        this.leftGate = null;
        this.rightGate = null;
        this.boolOp = new BooleanOperators();
    }
    
    public Gate(char val, Gate rightNode, Gate leftNode)
    {
        this.val = val;
        this.leftGate = leftNode;
        this.rightGate = rightNode;
        this.boolOp = new BooleanOperators();        
    }

    public void drawGate(Graphics g,int x, int y, int size, boolean isVaraible) 
    {
        if(isVaraible == false)
        {           
              switch (val) 
                {
                    case '+':
                        boolOp.getOr().drawOperator(g, x, y, size);
                        break;
                    case '.':
                        boolOp.getAnd().drawOperator(g, x, y, size);
                        break;
                    default:
                        boolOp.getNegation().drawOperator(g, x, y, size);
                        break;
                }
            
        }
        else 
        {
            String Var = String.valueOf(val);
            g.setFont(new Font("",Font.BOLD, size));
            g.drawString(Var, x+3 , y+8);
        }
    }

    public Gate getLeftGate() {
        return leftGate;
    }

    public Gate getRightGate() {
        return rightGate;
    }

    public BooleanOperators getBoolOp() {
        return boolOp;
    }
    
    public char getVal() {
        return val;
    }

    public void setLeftGate(Gate leftGate) {
        this.leftGate = leftGate;
    }

    public void setRightGate(Gate rightGate) {
        this.rightGate = rightGate;
    }

    public void setBoolOp(BooleanOperators boolOp) {
        this.boolOp = boolOp;
    }
    
    public void setVal(char val) {
        this.val = val;
    } 
}
