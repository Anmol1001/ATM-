import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceInquiry extends JFrame implements ActionListener {
    String pinCode;
    JButton back;
    BalanceInquiry(String pinCode){
        this.pinCode = pinCode;
        int balance = 0;

        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.setBounds(400,430,100,25);
        back.addActionListener(this);
        image.add(back);

        try{
            Conn c = new Conn();
            String query = "select * from bank where pin_code ='"+pinCode+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            JLabel text = new JLabel("You have balance of " + balance);
            text.setBounds(170,250,300,25);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Raleway",Font.BOLD,20));
            image.add(text);

        }catch(Exception ex){
            System.out.println(ex);
        }

        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinCode).setVisible(true);
        }
    }
}
