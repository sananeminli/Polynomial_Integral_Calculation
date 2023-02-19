import java.util.ArrayList;
//Sanan Eminli
//2021719204
//10.06.2022
//In this class we will store data that needed for calculation and calculate integral with methods.
// And return calculated integral with double data type.

public class Polynomial {
    private ArrayList<Double>  coefficients=  new ArrayList<>();
    private double deltaX;

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public Polynomial(double a, double b , double c, double d) {
        coefficients.add(a);
        coefficients.add(b);
        coefficients.add(c);
        coefficients.add(d);
    }
    //This method calculate function value at given x value.
    public double valueAt(double xvalue){
        double res = 0;
        //Because our a value stored first (means a's index is 0) and we need to multiply this with power of 3
        // we getting size of list which 4 and subtraction one for getting biggest power in function and doing reverse for loop
        // by doing that we get to multiply value of a with x^3 and b with x^2 etc.
        for (int i = coefficients.size()-1; i>=0;i-- ){
            res+=coefficients.get((coefficients.size()-1)-i)*Math.pow(xvalue,i);
        }
        return res;
    }
    //This method calculate rectangle are and add this value to result and return result value.

    public double calculateIntegral(double minX , double maxX){
       double res = 0;
       for (double i = minX; i<maxX;i+=deltaX){
           res+=valueAt(i)*deltaX;
       }

       return res;
    }

}
