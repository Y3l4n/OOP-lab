
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Top level container
public class AWTAccumulator extends Frame {

    private TextField tfInput;
    private TextField tfOutput;

    private int sum = 0;

    public AWTAccumulator(){
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an integer: ")); // Add first component to Frame

        tfInput = new TextField(10); // Add textfieild component to Frame
        add(tfInput);

        tfInput.addActionListener(new TFInputListener()); // Add listener takes TextField compo as source

        add(new Label("The accumulated sum is: "));
        
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) { 
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
    
}