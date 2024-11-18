package Input_OutputPackage;

import ExpressionPackage.Expression;
import java.util.ArrayList;

public class Write
{
    public static void write_Expression(Expression exp)
    {
        System.out.println(exp);
    }
    
    public static void write_Expression(ArrayList<Expression> exps)
    {
        for(Expression exp : exps)
        {
            write_Expression(exp);        
        }
    }
    
    public static void write_Expression_and_its_value(Expression exp)
    {
        System.out.println(exp + " = " + exp.evaluate());
    }
   
    public static void write_Expression_and_its_value(ArrayList<Expression> exps)
    {
        for(Expression exp : exps)
        {
            write_Expression_and_its_value(exp);
        }
    }
    
    public static void write_Expression_and_its_value_with_Substitution_Explanation(Expression exp)
    {
        System.out.println(exp + " = " + exp.Substitute_Values_in_Expression(exp.getExpression())  + " = " + exp.evaluate());
    }
    
    public static void write_Expression_and_its_value_with_Substitution_Explanation(ArrayList<Expression> exps)
    {
        for(Expression exp : exps)
        {
            write_Expression_and_its_value_with_Substitution_Explanation(exp);
        }
    }
    
    
}
