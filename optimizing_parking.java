import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
 
public class ParkingAssistanceApp extends JFrame {
   private JTextField txtInput;
   private JLabel statusLabel;
 
   public ParkingAssistanceApp() {
       setTitle("Parking Maangement App");
       setSize(1000, 8000);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
 
       initUI();
   }
 
   private void initUI() {
       JPanel panel = new JPanel();
     
       panel.setLayout(new GridLayout(10, 1));
       
       
       JLabel title = new JLabel("Car Parking Management System ",JLabel.CENTER);
       
       
       txtInput = new JTextField();
       JButton btnParkCar = new JButton("Park a car");
       JButton btnLeavePrakingLot = new JButton("Leave the parking lot");
       JButton btnViewParking = new JButton("View parking spaces");
       JButton btnExit = new JButton("Exit");
       JButton btnExit1 = new JButton("Exit1");
       statusLabel = new JLabel();
       statusLabel.setHorizontalAlignment(JLabel.CENTER);
     
 
       btnParkCar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           ​parkCar();
           }
       });
 
       btnLeavePrakingLot.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           ​int parkingNo=0;
               String strInput = txtInput.getText().trim();
           ​if(strInput.equalsIgnoreCase(""))
           ​​statusLabel.setText("Enter the space number to leave:");
           ​else​
           ​  parkingNo = Integer.parseInt(txtInput.getText());
           ​
           ​leaveParkingLot(parkingNo);
           }
       });
       
       btnViewParking.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           
           ​ viewParkingSpaces();
           }
       });
       
       btnExit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           
           ​statusLabel.setText("Exiting the program. Goodbye!");
               System.exit(0);
           }
       });
     
       
       
       panel.add(new JLabel());
       panel.add(title);
       
       panel.add(txtInput);
       panel.add(btnParkCar);
     
       panel.add(btnLeavePrakingLot);
     
       panel.add(btnViewParking);
     
       panel.add(btnExit);
     
       panel.add(statusLabel);
 
       add(panel);
 
       setVisible(true);
   }
 
 
 
   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> new ParkingAssistanceApp());
   }
   
   int totalSpaces = 10; // Total parking spaces
   boolean[] parkingSpaces = new boolean[totalSpaces]; // Array to represent parking spaces (true if occupied, false if available)
   
   private  void parkCar() {
       for (int i = 0; i < parkingSpaces.length; i++) {
           if (!parkingSpaces[i]) {
               parkingSpaces[i] = true; // Mark the space as occupied
               statusLabel.setText("Car parked in space " + (i + 1));
               return;
           }
       }
       statusLabel.setText("Sorry, the parking lot is full. Cannot park at the moment.");
   }
 
   private void leaveParkingLot(int parkNo) {
     
       int spaceNumber = parkNo;
 
       if (spaceNumber >= 1 && spaceNumber <= parkingSpaces.length && parkingSpaces[spaceNumber - 1]) {
           parkingSpaces[spaceNumber - 1] = false; // Mark the space as available
           statusLabel.setText("Car has left space " + spaceNumber);
       } else {
       ​statusLabel.setText("Invalid space number or the space is already empty.");
       }
   }
 
   private  void viewParkingSpaces() {
       StringBuffer strParkingLot = new StringBuffer();
       for (int i = 0; i < parkingSpaces.length; i++) {
       ​strParkingLot.append("Space " + (i + 1) + ": " + (parkingSpaces[i] ? "Occupied" : "Available \n"));
       }
       statusLabel.setText("Parking Spaces:"+strParkingLot.toString());
   }
   
}
