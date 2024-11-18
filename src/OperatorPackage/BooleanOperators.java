package OperatorPackage;

public class BooleanOperators
{
    private Operator Or;
    private Operator And;
    private Operator Negation;
    
    public BooleanOperators()
    {
        Or = new OrOperator();
        And = new AndOperator();
        Negation = new NegationOperator();
    }
    
    public BooleanOperators(char or, char and, char negation)
    {
        Or = new OrOperator(or);
        And = new AndOperator(and, or);
        Negation = new NegationOperator(negation);
    }
    
    public void setOr(Operator Or) {
        this.Or = Or;
    }

    public void setAnd(Operator And) {
        this.And = And;
    }

    public void setNegation(Operator Negation) {
        this.Negation = Negation;
    }

    public Operator getOr() {
        return Or;
    }

    public Operator getAnd() {
        return And;
    }

    public Operator getNegation() {
        return Negation;
    }
}
