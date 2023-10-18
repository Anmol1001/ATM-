import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    String pinCode;
    MiniStatement(String pinCode){

        this.pinCode = pinCode;

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel bankName = new JLabel("Nepal Bank");
        bankName.setFont(new Font("Raleway",Font.BOLD,20));
        bankName.setBounds(120,30,200,25);
        add(bankName);

        JLabel cardText = new JLabel();
        cardText.setFont(new Font("Raleway",Font.BOLD,15));
        cardText.setBounds(30,120,300,20);
        add(cardText);

        JLabel mini = new JLabel();
        mini.setFont(new Font("Raleway",Font.BOLD,12));
        add(mini);

        JLabel balance = new JLabel();
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        balance.setBounds(30,370,300,50);
        add(balance);

        try{

            Conn c = new Conn();
            String query = "select * from login where pin_number = '4623'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cardText.setText("Card Number: " + rs.getString("card_number").substring(0,4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        try{
            int bal = 0;
            Conn c = new Conn();
            String query = "select * from bank where pin_code = '4623'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your balance is " + bal);
        }catch(Exception e){
            System.out.println(e);
        }

        mini.setBounds(30,150,300,200);


        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setLocation(20,20);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
