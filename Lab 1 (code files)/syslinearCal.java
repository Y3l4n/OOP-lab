//
import javax.swing.JOptionPane;
public class syslinearCal {
    public static void main(String[] args) {

        String strNumA11, strNumA12, strNumA21, strNumA22, strNumB1, strNumB2;

        strNumA11 = JOptionPane.showInputDialog(null, "Enter your A11: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNumA12 = JOptionPane.showInputDialog(null, "Enter your A12: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNumB1 = JOptionPane.showInputDialog(null, "Enter your B1: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNumA21 = JOptionPane.showInputDialog(null, "Enter your A21: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNumA22 = JOptionPane.showInputDialog(null, "Enter your A22: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);
        strNumB2 = JOptionPane.showInputDialog(null, "Enter your B2: ", "Linear Cal", JOptionPane.INFORMATION_MESSAGE);

        double numA11 = Double.parseDouble(strNumA11);
        double numA12 = Double.parseDouble(strNumA12);
        double numB1 = Double.parseDouble(strNumB1);


        double numA21 = Double.parseDouble(strNumA21);
        double numA22 = Double.parseDouble(strNumA22);
        double numB2 = Double.parseDouble(strNumB2);

        double detD0 = numA11 * numA22 - numA21 * numA12;
        double detD1 = numB1 * numA22 - numB2 * numA12;
        double detD2 = numA11 * numB2 - numA21 * numB1;

        double x1 = detD1 / detD0;
        double x2 = detD2 / detD0;

        if (detD0 == 0 && detD1 == 0) { //Chi can detD1 = 0 -> detD2 cung bang 0
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions");
            System.exit(0);
        } else if (detD0 == 0 && detD1 != 0){ //Chi can 1 cai khac 0 -> ca 2 se khac 0
            JOptionPane.showMessageDialog(null, "The system has no solutions");
            System.exit(0);
        } else{
            String strNotification = "The results are: ";
            String strX1 = String.valueOf(x1);  
            strNotification += strX1 + " and ";
            String strX2 = String.valueOf(x2);
            strNotification += strX2;
            JOptionPane.showMessageDialog(null, strNotification, "Results", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }   
    }
}

