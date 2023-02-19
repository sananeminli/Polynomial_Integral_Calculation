# Polynomial_Integral_Calculation

Polynomial class represents a polynomial function with four coefficients (a, b, c, and d) and provides methods to calculate the function value at a given x value and to calculate the area under the curve of the function using rectangular approximation. The coefficients are stored in an ArrayList and the class also has a field for storing a delta x value, which is used in the calculation of the area under the curve. The valueAt method uses a for loop to calculate the value of the polynomial function at a given x value by iterating through the coefficients and using Math.pow to raise x to the appropriate power. The calculateIntegral method uses a for loop to approximate the area under the curve using rectangular approximation and returns the result.

User should write input like this one: 3x^3-5x^2+x+1
