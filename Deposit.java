import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amount;
    String pinCode;
    Deposit(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);
        setSize(900,900);

        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel details = new JLabel("Enter your deposit amount:");
        details.setFont(new Font("Raleway",Font.BOLD,15));
        details.setBounds(200,300,300,25);
        details.setForeground(Color.WHITE);
        image.add(details);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD,15));
        deposit.setBounds(400,450,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

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
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the amount you wanted");
            }else{
                try{
                   Conn conn = new Conn();
                   String query = "insert into bank values('"+pinCode+"','"+date+"','Deposit','"+number+"')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,number + " is deposited");
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
        new Deposit("");
    }
}
