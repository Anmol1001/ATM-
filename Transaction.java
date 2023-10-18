import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, fastCash, cashWith, balanceInquiry, pinChange, miniStatement, exit;
    String pinCode;
    Transaction(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);

        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel transHead = new JLabel("Please Select Your Transaction");
        transHead.setFont(new Font("Raleway",Font.BOLD,15));
        transHead.setForeground(Color.WHITE);
        transHead.setBounds(230,300,400,20);
        image.add(transHead);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,12));
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(170,415,120,25);
        deposit.addActionListener(this);
        image.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.setFont(new Font("Raleway",Font.BOLD,12));
        fastCash.setForeground(Color.BLACK);
        fastCash.setBounds(170,450,120,25);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setFont(new Font("Raleway",Font.BOLD,12));
        pinChange.setForeground(Color.BLACK);
        pinChange.setBounds(170,485,120,25);
        pinChange.addActionListener(this);
        image.add(pinChange);

        cashWith = new JButton("Cash Withdrawl");
        cashWith.setFont(new Font("Raleway",Font.BOLD,11));
        cashWith.setForeground(Color.BLACK);
        cashWith.setBounds(390,415,120,25);
        cashWith.addActionListener(this);
        image.add(cashWith);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setFont(new Font("Raleway",Font.BOLD,11));
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setBounds(390,450,120,25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setFont(new Font("Raleway",Font.BOLD,11));
        balanceInquiry.setForeground(Color.BLACK);
        balanceInquiry.setBounds(390,485,120,25);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD,11));
        exit.setForeground(Color.BLACK);
        exit.setBounds(390,520,120,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

      if(e.getSource() == deposit){
          setVisible(false);
          new Deposit(pinCode).setVisible(true);
      }
      if(e.getSource() == cashWith){
          setVisible(false);
          new Withdrawn(pinCode).setVisible(true);
      }

        if(e.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinCode).setVisible(true);
        }

        if(e.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinCode);
        }

        if(e.getSource() == balanceInquiry){
            setVisible(false);
            new BalanceInquiry(pinCode);
        }

      if(e.getSource() == exit){
          System.exit(0);
      }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
