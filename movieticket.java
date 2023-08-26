import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class movieticket extends JFrame {
    private JLabel movieLabel, seatsLabel;
    private JComboBox<String> movieComboBox;
    private JCheckBox[] seatCheckBoxes;
    private JButton bookButton;
    
    private String[] movieOptions = {"Movie A", "Movie B", "Movie C"};
    private int totalSeats = 20;
    
    public movieticket() {
        setTitle("Movie Ticket Booking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        movieLabel = new JLabel("Select Movie:");
        movieComboBox = new JComboBox<>(movieOptions);
        
        seatsLabel = new JLabel("Select Seats:");
        seatCheckBoxes = new JCheckBox[totalSeats];
        
        for (int i = 0; i < totalSeats; i++) {
            seatCheckBoxes[i] = new JCheckBox("Seat " + (i + 1));
        }
        
        bookButton = new JButton("Book Tickets");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process the selected movie and seats
                StringBuilder selectedSeats = new StringBuilder("Selected seats: ");
                
                for (int i = 0; i < totalSeats; i++) {
                    if (seatCheckBoxes[i].isSelected()) {
                        selectedSeats.append("Seat ").append(i + 1).append(", ");
                    }
                }
                
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                selectedSeats.delete(selectedSeats.length() - 2, selectedSeats.length()); // Remove the trailing comma
                
                JOptionPane.showMessageDialog(null, "Movie: " + selectedMovie + "\n" + selectedSeats.toString());
            }
        });
        
        setLayout(new GridLayout(totalSeats + 4, 1));
        
        add(movieLabel);
        add(movieComboBox);
        add(seatsLabel);
        
        for (JCheckBox seatCheckBox : seatCheckBoxes) {
            add(seatCheckBox);
        }
        
        add(bookButton);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new movieticket());
    }
}




 
