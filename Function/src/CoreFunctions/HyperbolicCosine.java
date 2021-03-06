
package CoreFunctions;

import Other.MathPoint;
import Other.MathVector;
import Other.Boundry1D;


public class HyperbolicCosine extends UnaryExpression{
    
    protected HyperbolicCosine(Expression innerFunction){
        this.innerFunction = innerFunction;
    }

    @Override
    public Double value(MathPoint p) {
        return Math.cosh(innerFunction.value(p));
    }

    @Override
    public Double derivative(MathVector vector, MathPoint p) {
        return innerFunction.derivative(vector, p) * Math.cosh(innerFunction.value(p));
    }

    @Override
    public SingleOutputFunction derivative(char var) {
        Expression f1 = new HyperbolicSine(innerFunction);
        f1 = new Multiplication(innerFunction.derivative(var),f1);
        return new SingleOutputFunction(f1);
    }

    @Override
    public String toString() {
        return "cosh(" + innerFunction.toString() + ")";
    }

    @Override
    public Expression integral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
