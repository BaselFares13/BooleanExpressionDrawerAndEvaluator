package ExpressionPackage;

import OperatorPackage.BooleanOperators;
import GatePackage.Gate;
import java.util.ArrayList;
import java.util.Stack;


public class Expression extends BooleanOperators
{
    private int NumOfOrGates = 0;
    private int NumOfAndGates = 0;
    private int NumOfInvetor = 0;
    private Gate gatesSystem;
    private String expression;
    private static ArrayList<String> variables;
    private static ArrayList<Integer> variableValues;

    
    public Expression()
    {
        super();
        expression = null;   
        variables = null;
        variableValues = null;
        gatesSystem = null;
    }
    
    
    public Expression(String expression)
    {
        super();
        this.expression = expression;
        
        setGatesSystem();
        calculateTheNumOfGates();
    }
    
   
    public Expression(String expression, char andOperator, char orOperator, char negationOperator)
    {
        super(andOperator, orOperator, negationOperator);
        this.expression = expression;
        
        setGatesSystem();
        calculateTheNumOfGates();
    }
    
    
    public String Substitute_Values_in_Expression(String evaluatedExpression)
    {
        if(expression == null || variables == null || variableValues == null) return "Error in Substituting !";
        
        for(int i = 0; i < variables.size(); i++)
        {
          evaluatedExpression = evaluatedExpression.replaceAll(variables.get(i), Integer.toString(variableValues.get(i)));
        }
        
        return getNegation().Performer(evaluatedExpression);
    }
    
    
    public String evaluate()
    {    
        if(expression == null || variables == null || variableValues == null) return "Error in evaluating !";
        
        String evaluatedExpression = expression;
        
        evaluatedExpression = this.Substitute_Values_in_Expression(evaluatedExpression);
        evaluatedExpression = getAnd().Performer(evaluatedExpression);
        evaluatedExpression = getOr().Performer(evaluatedExpression);

        return evaluatedExpression;
    }
    
    private void calculateTheNumOfGates()
    {
        for(int i = 0; i < expression.length(); i++)
        {
            if(expression.charAt(i) == '+')
            {
                NumOfOrGates++;
            }
            else if(expression.charAt(i) == '.')
            {
                NumOfAndGates++;
            }
            else if(expression.charAt(i) == '~')
            {
                NumOfInvetor++;
            }
        }
    }
    
    public void setGatesSystem()
    {
        String postfixExpression = Converter.convertInfixToPostfix(expression);
        Stack<Gate> systemGates = new Stack<>();

        for(char token : postfixExpression.toCharArray()) 
        {
            if(Converter.isOperator(token)) 
            {
                Gate rightGate = systemGates.pop();
                Gate leftGate = (token == '~')? null : systemGates.pop(); 
                systemGates.push(new Gate(token, rightGate ,leftGate));
            } 
            else 
            {
                systemGates.push(new Gate(token));
            }
        }

        this.gatesSystem =  systemGates.isEmpty()? null : systemGates.pop();
    }
    
    public Gate getGatesSystem() 
    {
        return this.gatesSystem;
    }
    
    public String getExpression() {
        return expression;
    }

    public static ArrayList<String> getVariables() 
    {
        return variables;
    }
    
    public static String getVariables(int index) 
    {
        return variables.get(index);
    }

    public static ArrayList<Integer> getVariablesValues() 
    {
        return variableValues;
    }

    public void setGatesSystem(Gate gatesSystem)
    {
        this.gatesSystem = gatesSystem;
    }
    
    public void setExpression(String expression) 
    {
        this.expression = expression;
    }

    public static void setVariables(ArrayList<String> variables)
    {
        Expression.variables = variables;
    }

    public static void setVariablesValues(ArrayList<Integer> variablesValues) 
    {
        Expression.variableValues = variablesValues;
    }

    public void setNumOfOrGates(int NumOfOrGates) {
        this.NumOfOrGates = NumOfOrGates;
    }

    public void setNumOfAndGates(int NumOfAndGates) {
        this.NumOfAndGates = NumOfAndGates;
    }

    public void setNumOfInvetor(int NumOfInvetor) {
        this.NumOfInvetor = NumOfInvetor;
    }

    public int getNumOfOrGates() {
        return NumOfOrGates;
    }

    public int getNumOfAndGates() {
        return NumOfAndGates;
    }

    public int getNumOfInvetor() {
        return NumOfInvetor;
    }
    
    @Override
    public String toString()
    {
        return (expression);
    }
    
}
