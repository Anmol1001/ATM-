import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawn extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;
    String pinCode;
    Withdrawn(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);
        setSize(900,900);

        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel details = new JLabel("Enter your withdraw amount:");
        details.setFont(new Font("Raleway",Font.BOLD,15));
        details.setBounds(200,300,300,25);
        details.setForeground(Color.WHITE);
        image.add(details);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway", Font.BOLD,15));
        withdraw.setBounds(400,450,100,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD,15));
        back.setBounds(400,490,100,25);
        back.addActionListener(this);
        image.add(back);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(170,350,300,25);
        image.add(amount);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the amount you want to withdraw");
            }else{
                try{
                   Conn conn = new Conn();
                   String query = "insert into bank values('"+pinCode+"','"+date+"','Withdrawn','"+number+"')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,number + " is withdrawn");
                   setVisible(false);
                   new Transaction(pinCode).setVisible(true);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinCode).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawn("");
    }
}
