import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField cardText;
    JTextField pinText;

    JButton signUp, clear, login;

    Login(){
        setTitle("Automated Teller machine");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logo = new JLabel(i3);
        logo.setBounds(120,10,60,60);
        add(logo);

        JLabel headerText = new JLabel("Welcome to MY Bank");
        headerText.setBounds(200,10,400,60);
        headerText.setFont(new Font("Osward",Font.BOLD,38));
        add(headerText);

        JLabel card = new JLabel("Card No :");
        card.setBounds(150,100,150,50);
        card.setFont(new Font("Osward",Font.BOLD,30));
        add(card);

        cardText = new JTextField();
        cardText.setBounds(320,110,150,30);
        add(cardText);


        JLabel pin = new JLabel("PIN         :");
        pin.setBounds(150,180,150,50);
        pin.setFont(new Font("Osward",Font.BOLD,30));
        add(pin);

        pinText = new JTextField();
        pinText.setBounds(320,190,150,30);
        add(pinText);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(170,260,120,50);
        signUp.setFocusable(false);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        clear = new JButton("CLEAR");
        clear.setBounds(330,260,120,50);
        clear.setFocusable(false);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        login = new JButton("LOGIN");
        login.setBounds(170,330,280,50);
        login.setFocusable(false);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        setSize(800,480);
        setLocation(300,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            Conn conn = new Conn();
            String cardNumber = cardText.getText();
            String pin = pinText.getText();
            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pin+"' ";

            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect PIN or card number");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        } else if (e.getSource() == signUp) {
            setVisible(false);
            new PersonalDetails().setVisible(true);

        } else if(e.getSource() == clear){
            cardText.setText(" ");
            pinText.setText(" ");
        }
    }
}


