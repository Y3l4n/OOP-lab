package OOP;

import javax.swing.JOptionPane;

public class TwoDoubleNumbers {
	public static void main(String[] args) {
	String strNum1, strNum2;
	double x;
	String Sum = "Sum of two doubles: ";
	String Diff="Difference of two doubles: ";
	String Pro = "Product of two doubles: ";
	String Quo = "Quotient of two doubles: ";

	strNum1 = JOptionPane.showInputDialog(null,
			"Please input the first number: ", "Input the first number: ",
			JOptionPane.INFORMATION_MESSAGE);

	strNum2 = JOptionPane.showInputDialog(null,
			"Please input the second number: ", "Input the second number: ",
			JOptionPane.INFORMATION_MESSAGE);
	double num1 = Double.parseDouble(strNum1);
	double	num2 = Double.parseDouble(strNum2);
		x = num1+num2;
		Sum = Sum + Double.toString(x);
		JOptionPane.showMessageDialog(null, Sum);
		x = num1-num2;
		Diff = Diff + Double.toString(x);
		JOptionPane.showMessageDialog(null, Diff);
		x = num1*num2;
		Pro = Pro + Double.toString(x);
		JOptionPane.showMessageDialog(null, Pro);
		x = num1/num2;
		Quo = Quo + Double.toString(x);
		JOptionPane.showMessageDialog(null, Quo);
		
		System.exit(0);
}
}
