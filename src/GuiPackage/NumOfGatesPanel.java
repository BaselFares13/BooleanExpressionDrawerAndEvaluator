package GuiPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumOfGatesPanel extends JPanel
{
    private JLabel NumOfOrGates = new JLabel("");
    private JLabel NumOfAndGates = new JLabel("");
    private JLabel NumOfInvertor = new JLabel("");
    
    public NumOfGatesPanel()
    {
        setLayout(new FlowLayout());
        
        NumOfOrGates.setPreferredSize(new Dimension(150,20));
        NumOfAndGates.setPreferredSize(new Dimension(150,20));
        NumOfInvertor.setPreferredSize(new Dimension(150,20));
        
        add(NumOfOrGates);
        add(NumOfAndGates);
        add(NumOfInvertor);
    }

    public void setNumOfOrGates(JLabel NumOfOrGates) {
        this.NumOfOrGates = NumOfOrGates;
    }

    public void setNumOfAndGates(JLabel NumOfAndGates) {
        this.NumOfAndGates = NumOfAndGates;
    }

    public void setNumOfInvertor(JLabel NumOfInvertor) {
        this.NumOfInvertor = NumOfInvertor;
    }

    public JLabel getNumOfOrGates() {
        return NumOfOrGates;
    }

    public JLabel getNumOfAndGates() {
        return NumOfAndGates;
    }

    public JLabel getNumOfInvertor() {
        return NumOfInvertor;
    }
    
}
