import java.awt.*;       // Using layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;    // Using Swing components and containers

public class check extends JFrame{
	   private JTextField tfInput;
	   private JTextArea tfOutput;
	   private int sum = 0;    // accumulated sum, init to 0
	   String userInputPattern = new String();
	 
	   // Constructor to setup the GUI components and event handlers
	   public check() {
	      // Retrieve the content-pane of the top-level container JFrame
	      // All operations done on the content-pane
	      Container cp = getContentPane();
	      cp.setLayout(new GridLayout(2, 2, 5, 5));  // The content-pane sets its layout
	 
	      add(new JLabel("Enter RegEx and press Enter: "));
	      tfInput = new JTextField(25);
	      add(tfInput);
	      add(new JLabel("Output Msg: "));
	      tfOutput = new JTextArea();
	      tfOutput.setEditable(false);  // read-only
	      add(tfOutput);
	 
	      // Allocate an anonymous instance of an anonymous inner class that
	      //  implements ActionListener as ActionEvent listener
	      tfInput.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {

	        	 String userInputPattern = tfInput.getText();
	        	 try {
	                 Pattern.compile(userInputPattern);
	                 tfOutput.setText("Syntax is ok.");
	             } catch (PatternSyntaxException exception) {
	            	 String trans = new String(exception.getMessage());
	            	 tfOutput.setText(trans);
	            	 
	             }
	        	 
	            
	         }
	      });
	 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	      setTitle("Swing checkRegEx"); // "super" Frame sets title
	      setSize(500, 200);  // "super" Frame sets initial size
	      setVisible(true);   // "super" Frame shows
	   }
	 
	   // The entry main() method
	   public static void main(final String[] args) {
		      // Run the GUI construction in the Event-Dispatching thread for thread-safety
		      SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		            new check();
		         }
		      });
	   }
}
