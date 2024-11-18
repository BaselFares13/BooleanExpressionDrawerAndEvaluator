package Input_OutputPackage;

import ExpressionPackage.Converter;
import ExpressionPackage.Expression;
import java.util.ArrayList;
import java.util.*; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Read 
{
    private static Scanner input;

    public static ArrayList<Expression> read_Expressions_From_File(String fileAddress) {
        ArrayList<Expression> expressions = new ArrayList<>();
       
        File file = new File(fileAddress);
        
        try 
        {
            input = new Scanner(file);
            while (input.hasNext())
            {
                String StrExp = input.nextLine();
                Expression ObjExp = new Expression(StrExp.replaceAll("\\s", ""));           
                expressions.add(ObjExp);
            }
            input.close();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        return expressions;
    }
    
    public static ArrayList<String> read_the_used_variables_from_the_expressions(ArrayList<Expression> exps)
    {
       ArrayList<String> variables = new ArrayList<>();
       
       for(Expression exp : exps) 
       {    
           String var = new String();
           for(int i = 0; i < exp.getExpression().length(); i++)
           {
               if(Converter.isOperator(exp.getExpression().charAt(i)))
               {
                   if(exp.getExpression().charAt(i) == '~') continue;

                   if(!variables.contains(var))
                   {
                       variables.add(var);
                   }
                   var = "";
                   continue;
               }
                              
               var += exp.getExpression().charAt(i);
           }
           
            if(!variables.contains(var))
            {
                variables.add(var);
            }
           
       }
       
       Collections.sort(variables, Collections.reverseOrder());
       
       return variables;
    }
    
    public static ArrayList<String> read_the_used_variables_from_the_expression(String exp)
    {
       ArrayList<String> variables = new ArrayList<>();
       
       for(int i = 0; i < exp.length(); i++)
       {
            if(Character.isLetter(exp.charAt(i)))
            {
                if(!variables.contains(String.valueOf(exp.charAt(i))))
                {
                    variables.add(String.valueOf(exp.charAt(i)));
                }
            }
       }
       
       return variables;
    }
    
    public static void read_variablesValues_from_terminal(int numVar, ArrayList<Integer> variablesValues)
    {
        input = new Scanner(System.in);
        
        for(int i = 0; i < numVar; i++)
        {
            System.out.print(Expression.getVariables(i) + " = ");
            variablesValues.add(input.nextInt());
        }
    }
    
}

