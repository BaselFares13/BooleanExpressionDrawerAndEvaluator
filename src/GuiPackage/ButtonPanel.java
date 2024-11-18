package GuiPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel
{
    private JTextField expressionTextField = new JTextField("");;
    private JTextField resultTextField = new JTextField("");
    private JLabel expressionLabel = new JLabel("Expression =>");
    private JLabel resultLabel = new JLabel("The Result =>");
    private JButton calculateButton = new JButton("Calculate");     
    
    public ButtonPanel()
    {
        setLayout(new FlowLayout());
        
        expressionTextField.setPreferredSize(new Dimension(200, 20));
        resultTextField.setPreferredSize(new Dimension(200,20));
        calculateButton.setPreferredSize(new Dimension(100,20));
        resultLabel.setPreferredSize(new Dimension(100,20));
        resultLabel.setPreferredSize(new Dimension(100,20));
           
        add(expressionLabel);
        add(expressionTextField);
        add(calculateButton);
        add(resultLabel);
        add(resultTextField);
        
    }

    public JTextField getExpressionTextField() {
        return expressionTextField;
    }

    public JTextField getResultTextField() {
        return resultTextField;
    }

    public JLabel getExpressionLabel() {
        return expressionLabel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public void setExpressionTextField(JTextField expressionTextField) {
        this.expressionTextField = expressionTextField;
    }

    public void setResultTextField(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    public void setExpressionLabel(JLabel expressionLabel) {
        this.expressionLabel = expressionLabel;
    }

    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public void setCalculateButton(JButton calculateButton) {
        this.calculateButton = calculateButton;
    }
}
