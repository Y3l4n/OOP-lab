//Example 5: Calculator.java
import javax.swing.JOptionPane;
//Program to calculate sum, difference, product, quotient of 2 numbers
public class Calculator {
    public static void main(String[] args) {
        
        String strNum1, strNum2;
        String strNotification = "Your result is: ";


        strNum1 = JOptionPane.showInputDialog(null, "Enter your first number: ", "Your first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Enter your second number: ", "Your second number", JOptionPane.INFORMATION_MESSAGE);

        String operatorInput = JOptionPane.showInputDialog(null, "Enter your operator: ", "Operator", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        switch (operatorInput) {
            case "+":
                double sumNum = num1 + num2;
                strNotification += sumNum;
                JOptionPane.showMessageDialog(null, strNotification, "Your sum is", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "-":
                double differenceNum = num1 - num2;
                strNotification += differenceNum;
                JOptionPane.showMessageDialog(null, strNotification, "Your difference is", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "*":
                double productNum = num1 * num2;
                strNotification += productNum;
                JOptionPane.showMessageDialog(null, strNotification, "Your product is", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "/":
                double quotientNum = num1 / num2;
                if (num2 == 0) {
                    strNotification += "Invalid divisor";
                    JOptionPane.showMessageDialog(null, strNotification);
                    break;                 
                }else{
                    strNotification += quotientNum;
                    JOptionPane.showMessageDialog(null, strNotification, "Your quotient is", JOptionPane.INFORMATION_MESSAGE);
                    break;}
            default:
                strNotification += "Invalid operator input";
                JOptionPane.showMessageDialog(null, strNotification);
                break;
        }
    }
}
