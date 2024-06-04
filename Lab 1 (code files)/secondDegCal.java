import java.lang.Math;
import java.util.Scanner;
public class secondDegCal {
    
    public static void main(String[] args) {
        
        Scanner doubleInput = new Scanner(System.in);
        double numA = doubleInput.nextDouble();
        double numB = doubleInput.nextDouble();
        double numC = doubleInput.nextDouble();

        if (numA == 0) {
            if (numB == 0){
                System.out.println("The equation has no solution");
            }else {
                double res = -numC / numB;
                System.out.println("The result is: " + res);
            }
        }else {
            double deltaVal = Math.pow(numB, 2) - 4 * numA * numC;
            if (deltaVal == 0) {
                double x1 = -numB / (2 * numA);
                String strx1 = Double.toString(x1);

                double x2 = -numB / (2 * numA);
                String strx2 = Double.toString(x2);

                System.out.println("The result for x1 and x2 are: " + strx1 + " and " + strx2);
            }else if (deltaVal < 0) {
                System.out.println("The equation has no solution");              
            }else {
                double x1 = (-numB + Math.sqrt(deltaVal)) / (2 * numA);
                String strx1 = Double.toString(x1);

                double x2 = (-numB - Math.sqrt(deltaVal)) / (2 * numA);
                String strx2 = Double.toString(x2);

                System.out.println("The result for x1 and x2 are: " + strx1 + " and " + strx2);
            }
        }
        doubleInput.close();
    }
}
