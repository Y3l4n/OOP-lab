package OOP;
import javax.swing.*;

public class TheFirstDegree {
	public static void main(String[] args) {
		String strNum1, strNum2;
		 double nghiem;
		String vosoNghiem ="Phương trình này có vô số nghiệm.";
		String voNghiem = "Phương trình vô nghiệm.";
		String htNghiem = "Nghiem phuong trinh la :";
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ", "Input the a number: ",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ", "Input the b number: ",
				JOptionPane.INFORMATION_MESSAGE);
		double aNumber = Double.parseDouble(strNum1);
		double	bNumber = Double.parseDouble(strNum2);
			if (aNumber == 0) {
	            if (bNumber == 0) {
	                JOptionPane.showMessageDialog(null, vosoNghiem);
	            } else {
	            	JOptionPane.showMessageDialog(null, voNghiem);
	            }
	        } else {
	            nghiem = (double) -bNumber / aNumber; 
	           String s = Double.toString(nghiem);
	           s = htNghiem + s;
	           JOptionPane.showMessageDialog(null, s);
	        }	
	}
}
