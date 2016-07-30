package pane;

import java.awt.*;       // Using AWT layouts
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing components and containers

 
// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class SwingCounter extends JFrame {   // JFrame instead of Frame
   private final JTextField tfCount;  // Use Swing's JTextField instead of AWT's TextField
   private final JTextField length;
   private final JTextField width;
   private final JButton btnCount;    // Using Swing's JButton instead of AWT's Button
   private final JButton setLayout;
   private int count = 0;
 
   // Constructor to setup the GUI components and event handlers
   public SwingCounter () {
      // Retrieve the content-pane of the top-level container JFrame
      // All operations done on the content-pane
      final Container cp = getContentPane();
//      final GroupLayout layout = new GroupLayout(cp);
      cp.setLayout(new GridLayout(2, 5,2,5));   // The content-pane sets its layout
      
      
      
      
      
      
      
      
      
      
 
      cp.add(new JLabel("Counter"));
      tfCount = new JTextField("0", 10);
      tfCount.setEditable(false);
      cp.add(tfCount);
      
      cp.add(new JLabel("length"));
      length = new JTextField("0", 10);
      length.setEditable(true);
      cp.add(length);
      
      cp.add(new JLabel("width"));
      width = new JTextField("0", 10);
      width.setEditable(true);
      cp.add(width);
 
      btnCount = new JButton("Count");
      cp.add(btnCount);
      
      setLayout = new JButton("Set");
      cp.add(setLayout);
 
      // Allocate an anonymous instance of an anonymous inner class that
      //  implements ActionListener as ActionEvent listener
      btnCount.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(final ActionEvent evt) {
            ++count;
            tfCount.setText(count+"");
         }
      });
      
      setLayout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(final ActionEvent e) {
			// TODO Auto-generated method stub
			final int w = Integer.parseInt(width.getText());
			final int l = Integer.parseInt(length.getText());
			setSize(w,l);
			
		}
	});
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
      setTitle("Swing Counter"); // "super" JFrame sets title
      setSize(500, 500);         // "super" JFrame sets initial size
      setVisible(true);          // "super" JFrame shows
      
   }
 
   // The entry main() method
   public static void main(final String[] args) {
      // Run the GUI construction in the Event-Dispatching thread for thread-safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SwingCounter(); // Let the constructor do the job
            new SwingAccumulator();
         }
      });
   }
}