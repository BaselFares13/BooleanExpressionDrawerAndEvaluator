package GuiPackage;

import Input_OutputPackage.Read;
import ExpressionPackage.Expression;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener
{
    private TheDrawingPanel drawingPanel;
    private ButtonPanel buttonPanel;
    private NumOfGatesPanel numOfGatesPanel;
    private Expression expression = new Expression("");

    public MyFrame()
    {
        setTitle("Expression Drawer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        
        drawingPanel = new TheDrawingPanel(expression);
        buttonPanel = new ButtonPanel();
        numOfGatesPanel = new NumOfGatesPanel();     

        add(drawingPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
        add(numOfGatesPanel, BorderLayout.SOUTH);
        
        buttonPanel.getCalculateButton().addActionListener(this);
        
        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {   
        expression = new Expression(buttonPanel.getExpressionTextField().getText());
        ArrayList<String> variables = new ArrayList<>();
        ArrayList<Integer> variableValues = new ArrayList<>();
        
                
        variables = Read.read_the_used_variables_from_the_expression(expression.getExpression());
               
        for(int i = 0; i < variables.size(); i++)
        {
            int value = 0;
            boolean con = true;
            
            while(con)
            {
                try
                {
                    value = Integer.parseInt(JOptionPane.showInputDialog(this ,"Enter the Value of " + variables.get(i) + " either 1 or 0 :"));
                    con = false;
                }
                catch(Exception w)
                {
                    JOptionPane.showMessageDialog(this, "You entered an Invalid value to " + variables.get(i));
                }
            }
                
            variableValues.add(value);
        }
                
        Expression.setVariables(variables);
        Expression.setVariablesValues(variableValues);

        drawingPanel = new TheDrawingPanel(expression);
        add(drawingPanel, BorderLayout.CENTER);

        String result =  expression.Substitute_Values_in_Expression(expression.toString()) + " = " + expression.evaluate();
        buttonPanel.getResultTextField().setText(result);
        
        numOfGatesPanel.getNumOfOrGates().setText("Number of Or Gates = " + expression.getNumOfOrGates());
        numOfGatesPanel.getNumOfAndGates().setText("Number of And Gates = " + expression.getNumOfAndGates());
        numOfGatesPanel.getNumOfInvertor().setText("Number of Invertor = " + expression.getNumOfInvetor());
        
    }
            
    public static void main(String[] args)
    {  
        MyFrame frame = new MyFrame();
    }
}
