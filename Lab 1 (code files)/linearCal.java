
import javax.swing.JOptionPane;
public class linearCal {

    public static void main(String[] args) {

        String strNum1, strNum2;
        String strNotification = "Your result is: ";


        strNum1 = JOptionPane.showInputDialog(null, "Enter your slope a: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Enter your b: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        if (num1 == 0 && num2 != 0) {
            strNotification = "The equation has no results";
            JOptionPane.showMessageDialog(null, strNotification);
        }else if (num1 == 0 && num2 == 0){
            strNotification = "The equation has infinitely many results";
            JOptionPane.showMessageDialog(null, strNotification);
        }else {
            double result = -num2 / num1;
            strNotification += result;
            JOptionPane.showMessageDialog(null, strNotification);
        }
    }    
}
