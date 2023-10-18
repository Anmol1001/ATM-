import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AdditionalDetails extends JFrame implements ActionListener {

    String formNo;
    JTextField panText, citizenShipText;
    JRadioButton syes, sno, eyes, eno;
    JComboBox  religionOpt, incomeOpt, qualiOpt, occupationOpt;
    JButton next;

    AdditionalDetails(String formNo){
        this.formNo = formNo;
        setSize(830,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 1: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionalDetails.setBounds(220,70,400,50);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(150,130,150,25);
        add(religion);

        String[] religionVal = {"Hindu","Buddhist","Muslim","Christain","Other"};
        religionOpt = new JComboBox(religionVal);
        religionOpt.setFont(new Font("Raleway", Font.PLAIN,15));
        religionOpt.setBounds(350,130,400,25);
        religionOpt.setBackground(Color.WHITE);
        add(religionOpt);

        JLabel  Income = new JLabel("Income: ");
        Income.setFont(new Font("Raleway",Font.BOLD,15));
        Income.setBounds(150,175,150,25);
        add(Income);

        String[] incomeVal = {"less than 10000", "5L to 10L", "10L to 15L", "more than 15L"};
        incomeOpt = new JComboBox(incomeVal);
        incomeOpt.setFont(new Font("Raleway", Font.PLAIN,15));
        incomeOpt.setBounds(350,175,400,25);
        incomeOpt.setBackground(Color.WHITE);
        add(incomeOpt);

        JLabel  qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.PLAIN,15));
        qualification.setBounds(150,220,150,25);
        add(qualification);

        String[] qualiVal = {"Under Graduate","Graduate","Post Graduate","Doctrate","Others"};
        qualiOpt = new JComboBox(qualiVal);
        qualiOpt.setFont(new Font("Raleway",Font.PLAIN,15));
        qualiOpt.setBounds(350, 220, 400,25);
        qualiOpt.setBackground(Color.WHITE);
        add(qualiOpt);

        JLabel  occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,15));
        occupation.setBounds(150,265,150,25);
        add(occupation);

        String[] occupationVal = {"Engineer", "Doctor","Banker","Architect","Others"};
        occupationOpt = new JComboBox(occupationVal);
        occupationOpt.setFont(new Font("Raleway", Font.BOLD,14));
        occupationOpt.setBounds(350,265,100,25);
        occupationOpt.setBackground(Color.WHITE);
        add(occupationOpt);

        JLabel  panNum = new JLabel("Pan Number: ");
        panNum.setFont(new Font("Raleway",Font.BOLD,15));
        panNum.setBounds(150,310,150,25);
        add(panNum);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD,20));
        panText.setBounds(350,310,400,25);
        add(panText);

        JLabel  citizenShip = new JLabel("Citizenship Num: ");
        citizenShip.setFont(new Font("Raleway",Font.BOLD,15));
        citizenShip.setBounds(150,355,150,25);
        add(citizenShip);

        citizenShipText = new JTextField();
        citizenShipText.setFont(new Font("Raleway", Font.BOLD,14));
        citizenShipText.setBounds(350,355,400,25);
        add(citizenShipText);

        JLabel  senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway",Font.BOLD,15));
        senior.setBounds(150,400,150,25);
        add(senior);

        syes = new JRadioButton("Yes ");
        syes.setFont(new Font("Raleway", Font.BOLD,14));
        syes.setBounds(350,400,120,25);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No ");
        sno.setFont(new Font("Raleway", Font.BOLD,14));
        sno.setBounds(550,400,120,25);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCit = new ButtonGroup();
        seniorCit.add(syes);
        seniorCit.add(sno);

        JLabel  existionAccount = new JLabel("Existing Account: ");
        existionAccount.setFont(new Font("Raleway",Font.BOLD,15));
        existionAccount.setBounds(150,445,150,25);
        add(existionAccount);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD,14));
        eyes.setBounds(350,445,120,25);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD,14));
        eno.setBounds(550,445,120,25);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGrp = new ButtonGroup();
        existingGrp.add(eyes);
        existingGrp.add(eno);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD,20));
        next.setBounds(650,570,100,30);
        next.setFocusable(false);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String formNumber = formNo;
        String sReligion = (String) religionOpt.getSelectedItem();
        String sIncome = (String) incomeOpt.getSelectedItem();
        String sQualification = (String) qualiOpt.getSelectedItem();
        String sOccupation = (String) occupationOpt.getSelectedItem();
        String sPan = panText.getText();
        String sCitizen = citizenShipText.getText();

        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes ";
        } else if (sno.isSelected()) {
            seniorCitizen = "No ";
        }

        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Yes ";
        } else if (eno.isSelected()) {
            existingAccount = "No ";
        }

        try{
            if(sCitizen.equals("")){
                JOptionPane.showMessageDialog(null,"Citizen Number is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formNumber+"','"+sReligion+"','"+sIncome+"','"+sQualification+"','"+sOccupation+"','"+sPan+"','"+sCitizen+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        setVisible(false);
        new AccountDetails(formNo);

    }

    public static void main(String[] args) {
        new AdditionalDetails("");
    }
}
