import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AccountDetails extends JFrame implements ActionListener {
    String formNo;
    JCheckBox c1, c2, c3, c4;
    JCheckBox s1,s2,s3,s4,s5,s6,s7;
    JButton submit, cancel;
    AccountDetails(String formNo){

        this.formNo = formNo;
        setSize(800, 830);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,30));
        accountDetails.setBounds(100,30,400,40);
        add(accountDetails);

        JLabel accType = new JLabel("Account Type:");
        accType.setFont(new Font("Raleway",Font.BOLD,20));
        accType.setBounds(100,90,200,40);
        add(accType);

        c1 = new JCheckBox("Saving Account");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(100,150,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Current Account");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(300,150,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Fixed Account");
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBounds(100,200,150,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Recurring Account");
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBounds(300,200,250,30);
        c4.setBackground(Color.WHITE);
        add(c4);

        JLabel cardNum = new JLabel("Card Number:");
        cardNum.setFont(new Font("Raleway",Font.BOLD,15));
        cardNum.setBounds(100,250,200,30);
        add(cardNum);

        JLabel cardDetails = new JLabel("This is your 16 digit card number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,11));
        cardDetails.setBounds(100,270,200,20);
        add(cardDetails);

        JLabel cardText = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardText.setFont(new Font("Raleway",Font.BOLD,15));
        cardText.setBounds(300,260,300,40);
        add(cardText);

        JLabel pinNum = new JLabel("PIN :");
        pinNum.setFont(new Font("Raleway",Font.BOLD,15));
        pinNum.setBounds(100,320,200,30);
        add(pinNum);

        JLabel pinDetails = new JLabel("This is your 4 digit PIN");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,11));
        pinDetails.setBounds(100,340,200,20);
        add(pinDetails);

        JLabel pinText = new JLabel("XXXX");
        pinText.setFont(new Font("Raleway",Font.BOLD,15));
        pinText.setBounds(300,330,300,40);
        add(pinText);

        JLabel services = new JLabel("Service Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,390,200,40);
        add(services);

        s1 = new JCheckBox("ATM card");
        s1.setFont(new Font("Raleway",Font.BOLD,15));
        s1.setBounds(100,450,150,30);
        s1.setBackground(Color.WHITE);
        add(s1);

        s2 = new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway",Font.BOLD,15));
        s2.setBounds(300,450,150,30);
        s2.setBackground(Color.WHITE);
        add(s2);

        s3 = new JCheckBox("Mobile Banking");
        s3.setFont(new Font("Raleway",Font.BOLD,15));
        s3.setBounds(100,490,150,30);
        s3.setBackground(Color.WHITE);
        add(s3);

        s4 = new JCheckBox("Email & SMS Alert");
        s4.setFont(new Font("Raleway",Font.BOLD,15));
        s4.setBounds(300,490,200,30);
        s4.setBackground(Color.WHITE);
        add(s4);

        s5 = new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway",Font.BOLD,15));
        s5.setBounds(100,530,150,30);
        s5.setBackground(Color.WHITE);
        add(s5);

        s6 = new JCheckBox("E-statement");
        s6.setFont(new Font("Raleway",Font.BOLD,15));
        s6.setBounds(300,530,150,30);
        s6.setBackground(Color.WHITE);
        add(s6);

        s7 = new JCheckBox("I hereby declared that i agree all the terms of bank");
        s7.setFont(new Font("Raleway",Font.BOLD,11));
        s7.setBounds(100,590,400,20);
        s7.setBackground(Color.WHITE);
        add(s7);

        submit = new JButton("Submit");
        submit.setBounds(180,630,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(380,630,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setLocation(200,5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){


        if(e.getSource() == submit){
            String formNum = formNo;
            String accType = null;
            if(c1.isSelected()){
                accType = "Saving Account";
            }
            else if(c2.isSelected()){
                accType = "Current Account";
            }
            else if(c3.isSelected()){
                accType = "Fixed Account";
            }
            else if (c4.isSelected()) {
                accType = "Recurring Account";
            }

            Random random = new Random();

            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";

            if(s1.isSelected()){
                facility = facility + " ATM Card";
            }
            else if (s2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            else if (s3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            else if (s4.isSelected()) {
                facility = facility + " Email And SMS";
            }
            else if (s5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            else if (s6.isSelected()) {
                facility = facility + " E-statement";
            }

            try{
                if(accType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                Conn conn = new Conn();
                String query1 = "insert into signupthree values('"+formNum+"','"+accType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formNum+"','"+cardNumber+"','"+pinNumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n" + "PIN: " + pinNumber);

            }catch (Exception ex){
                System.out.println(ex);
            }

        }
        else if (e.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new AccountDetails("");
    }
}
