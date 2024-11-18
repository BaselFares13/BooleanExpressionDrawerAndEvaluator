package PartOne;

import ExpressionPackage.Expression;
import Input_OutputPackage.Write;
import Input_OutputPackage.Read;
import java.util.ArrayList;

class PartOne
{   
    public static void main(String []args)
    {
        ArrayList<Expression> Expressions = Read.read_Expressions_From_File("MyExpressions.txt"); 
        
        ArrayList<String> variables = Read.read_the_used_variables_from_the_expressions(Expressions);
        Expression.setVariables(variables);
        
        ArrayList<Integer> variableValues = new ArrayList<>();
        System.out.println("You used " + variables.size() + " characters as variables in the expressions, you have to enter thier values, either 0 or 1: ");   
        Read.read_variablesValues_from_terminal(variables.size(), variableValues);
        Expression.setVariablesValues(variableValues);
       
        System.out.println("\n================================================================");
      
        Write.write_Expression_and_its_value_with_Substitution_Explanation(Expressions);
      
    }
}
