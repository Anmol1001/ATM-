import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinCode;

    PinChange(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel pinHead = new JLabel("Please change your pin:");
        pinHead.setBounds(170,300,300,25);
        pinHead.setForeground(Color.WHITE);
        pinHead.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pinHead);

        JLabel pinText1 = new JLabel("Enter your pin:");
        pinText1.setBounds(170,340,200,25);
        pinText1.setForeground(Color.WHITE);
        pinText1.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pinText1);

        pin = new JPasswordField();
        pin.setBounds(370,340,100,25);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pin);

        JLabel pinText2 = new JLabel("Re-enter your pin:");
        pinText2.setBounds(170,380,300,25);
        pinText2.setForeground(Color.WHITE);
        pinText2.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pinText2);

        repin = new JPasswordField();
        repin.setBounds(370,380,100,25);
        repin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(400,450,100,25);
        change.setFont(new Font("Raleway",Font.BOLD,17));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(400,490,100,25);
        back.setFont(new Font("Raleway",Font.BOLD,17));
        back.addActionListener(this);
        image.add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            String pinText = pin.getText();
            String repinText = repin.getText();

            if(pinText.equals("")){
                JOptionPane.showMessageDialog(null,"You have enter your pin");
                return;
            }
            else if(repinText.equals("")){
                JOptionPane.showMessageDialog(null,"You have re-enter your pin");
                return;
            }

            else if(!repinText.equals(pinText)){
                JOptionPane.showMessageDialog(null,"Pin does not match");
                return;
            }

            Conn c = new Conn();

            try{
                String query = "update bank set pin_code = '"+repinText+"' where pin_code = '"+pinCode+"'";
                String query1 = "update login set pin_number = '"+repinText+"' where pin_number = '"+pinCode+"'";
                String query2 = "update signupthree set pin_number = '"+repinText+"' where pin_number = '"+pinCode+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new Transaction(repinText).setVisible(true);


            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinCode);
        }
    }
}
