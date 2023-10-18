import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton fiveHundred,thousand,twoThousand,threeThousand,fiveThousand,tenThousand,back;
    String pinCode;
    FastCash(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);

        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel transHead = new JLabel("Please Select Your Withdrawl Amount");
        transHead.setFont(new Font("Raleway",Font.BOLD,15));
        transHead.setForeground(Color.WHITE);
        transHead.setBounds(230,300,400,20);
        image.add(transHead);

        thousand = new JButton("1000");
        thousand.setFont(new Font("Raleway",Font.BOLD,12));
        thousand.setForeground(Color.BLACK);
        thousand.setBounds(170,450,120,25);
        thousand.addActionListener(this);
        image.add(thousand);

        fiveHundred = new JButton("500");
        fiveHundred.setFont(new Font("Raleway",Font.BOLD,12));
        fiveHundred.setForeground(Color.BLACK);
        fiveHundred.setBounds(170,415,120,25);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        twoThousand = new JButton("2000");
        twoThousand.setFont(new Font("Raleway",Font.BOLD,12));
        twoThousand.setForeground(Color.BLACK);
        twoThousand.setBounds(170,485,120,25);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        threeThousand = new JButton("3000");
        threeThousand.setFont(new Font("Raleway",Font.BOLD,11));
        threeThousand.setForeground(Color.BLACK);
        threeThousand.setBounds(390,415,120,25);
        threeThousand.addActionListener(this);
        image.add(threeThousand);

        fiveThousand = new JButton("5000");
        fiveThousand.setFont(new Font("Raleway",Font.BOLD,11));
        fiveThousand.setForeground(Color.BLACK);
        fiveThousand.setBounds(390,450,120,25);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("10000");
        tenThousand.setFont(new Font("Raleway",Font.BOLD,11));
        tenThousand.setForeground(Color.BLACK);
        tenThousand.setBounds(390,485,120,25);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,11));
        back.setForeground(Color.BLACK);
        back.setBounds(390,520,120,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinCode).setVisible(true);
        }else{
            String amount = ((JButton)e.getSource()).getText();
            Conn c = new Conn();
            try{
                String query1 = "select * from bank where pin_code = '"+pinCode+"'";
                ResultSet rs = c.s.executeQuery(query1);
                int balance = 0;

                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != back && Integer.parseInt(amount) > balance){
                    JOptionPane.showMessageDialog(null,"Not enough Money");
                    return;
                }

                Date date = new Date();
                String query2 = "insert into bank values('"+pinCode+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs " + amount + " is withdrawn");

            }catch (Exception ex){
                System.out.println(ex);
            }
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
