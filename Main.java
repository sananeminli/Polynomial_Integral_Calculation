import java.util.ArrayList;
import java.util.Scanner;
//Sanan Eminli
//2021719204
//10.06.2022
//In main method we will read inputs from user and parse them into calculateIntegral method.
// And return calculated integral to user.

public class Main {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        System.out.printf("Please enter polynomial= ");
        Scanner input = new Scanner(System.in);
        String line=input.nextLine();
        char[] chars = line.toCharArray();
        //In this list we will add coefficient of single elements after we decide which elemet it is we will clear list.
        ArrayList<String> coefficient =  new ArrayList<>();
        if (chars[0]=='x')coefficient.add("1");
        // This for loop will loop trough input polynomial equation and read that chacter by character
        //if character is not number or '+','-' it will countunie
        //else it will add to coefficient list
        //if character is 'x' it will look for power of x and then put this coefficient as a,b or c value.
        for (int i = 0 ;i< chars.length;i++){
           if (i!=0&&(chars[i]=='^'||chars[i-1]=='^'||chars[i]=='+')) continue;
           if (chars[i]!='x')coefficient.add(String.valueOf(chars[i]));
           else if (i!=0&&chars[i]=='x'&&(chars[i-1]=='+'||chars[i-1]=='-'))coefficient.add("1");
            // This block will be executed if coefficient that we store belongs to x^2 or x^3
           if (i+1<=chars.length-1&&!coefficient.isEmpty()&&chars[i]=='x'&&chars[i+1]=='^'){

               if (i+2<chars.length&&chars[i+2]=='3') {
                   String res = "";
                   for (int  k =0 ; k< coefficient.size();k++) res+=coefficient.get(k);
                   res =res.replaceAll("\\s", "");
                   a = Integer.valueOf(res);
                   coefficient.clear();
                   continue;
               }
               if (i+2<chars.length&&chars[i+2]=='2') {
                   String res = "";

                   for (int  k =0 ; k< coefficient.size();k++) res+=coefficient.get(k);
                   res =res.replaceAll("\\s", "");
                   b = Integer.valueOf(res);
                   coefficient.clear();
                   continue;
               }
           }
           // This block will be executed if coefficient that we store belongs to only x
           else if (chars[i]=='x'){
               String res = "";
               for (int  k =0 ; k< coefficient.size();k++) res+=coefficient.get(k);
               res =res.replaceAll("\\s", "");
               c = Integer.valueOf(res);
               coefficient.clear();
           }
            // This block will be executed if coefficient that we store not belongs to x^2, x^3 or x.
            //Then we store this coefficient as a d value.
           if (i==chars.length-1&&!coefficient.isEmpty()){
               String res = "";
               for (int  k =0 ; k< coefficient.size();k++) res+=coefficient.get(k);
               res =res.replaceAll("\\s", "");
               d = Integer.valueOf(res);
           }

        }
        //getting range from user
        System.out.printf("Enter the range= ");

        Scanner inputRange = new Scanner(System.in);

        String rangeLine = inputRange.nextLine();
        //spiting range string with comma and store first value as minX and second value as maxX
        String[] rangeArr = rangeLine.split(",");

        double range1 = Double.parseDouble(rangeArr[0]);

        double range2 = Double.parseDouble(rangeArr[1]);


        //getting deltaX from user
        System.out.printf("Enter deltaX= ");
        Scanner inputDeltaX = new Scanner(System.in);
        double lastDeltaX = Double.parseDouble(inputDeltaX.nextLine());
        Polynomial polynomial = new Polynomial(a,b,c,d);
        polynomial.setDeltaX(lastDeltaX);
        System.out.println( "Calculated integral= "+ polynomial.calculateIntegral(range1,range2));





    }
}