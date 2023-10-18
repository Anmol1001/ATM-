import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class PersonalDetails extends JFrame implements ActionListener {


    long random;
    JTextField nameText, fathText, emailText, addressText, cityText , pinText, stateText;
    JDateChooser dobCal;
    JRadioButton maleButton, femaleButton, otherButton, married, unmarried, other;
    JButton next;

    PersonalDetails(){
        setSize(830,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random ranNum = new Random();
        random = Math.abs((ranNum.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway",Font.BOLD,30));
        formNo.setBounds(180,10,600,60);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        personalDetails.setBounds(220,70,400,50);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(150,130,150,25);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD,15));
        nameText.setBounds(350,130,400,25);
        add(nameText);

        JLabel  fathName = new JLabel("Father's Name: ");
        fathName.setFont(new Font("Raleway",Font.BOLD,15));
        fathName.setBounds(150,175,150,25);
        add(fathName);

        fathText = new JTextField();
        fathText.setFont(new Font("Raleway", Font.BOLD,15));
        fathText.setBounds(350,175,400,25);
        add(fathText);

        JLabel  dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(150,220,150,25);
        add(dob);

        dobCal = new JDateChooser();
        dobCal.setFont(new Font("Raleway",Font.BOLD,15));
        dobCal.setBounds(350, 220, 400,25);
        add(dobCal);

        JLabel  gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(150,265,150,25);
        add(gender);

        maleButton = new JRadioButton("Male ");
        maleButton.setFont(new Font("Raleway", Font.BOLD,14));
        maleButton.setBounds(350,265,100,25);
        maleButton.setBackground(Color.WHITE);
        add(maleButton);

        femaleButton = new JRadioButton("Female ");
        femaleButton.setFont(new Font("Raleway", Font.BOLD,14));
        femaleButton.setBounds(450,265,100,25);
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);

        otherButton = new JRadioButton("Other ");
        otherButton.setFont(new Font("Raleway", Font.BOLD,14));
        otherButton.setBounds(580,265,100,25);
        otherButton.setBackground(Color.WHITE);
        add(otherButton);

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);

        JLabel  email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(150,310,150,25);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD,20));
        emailText.setBounds(350,310,400,25);
        add(emailText);

        JLabel  marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(150,355,150,25);
        add(marital);

        married = new JRadioButton("Married ");
        married.setFont(new Font("Raleway", Font.BOLD,14));
        married.setBounds(350,355,100,25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried ");
        unmarried.setFont(new Font("Raleway", Font.BOLD,14));
        unmarried.setBounds(450,355,120,25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other ");
        other.setFont(new Font("Raleway", Font.BOLD,14));
        other.setBounds(580,355,100,25);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel  address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(150,400,150,25);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD,15));
        addressText.setBounds(350,400,400,25);
        add(addressText);

        JLabel  city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(150,445,150,25);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD,15));
        cityText.setBounds(350,445,400,25);
        add(cityText);

        JLabel  pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,15));
        pinCode.setBounds(150,490,150,25);
        add(pinCode);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD,15));
        pinText.setBounds(350,490,400,25);
        add(pinText);

        JLabel  state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(150,535,150,25);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD,15));
        stateText.setBounds(350,535,400,25);
        add(stateText);

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

        String formNo = "" + random;
        String name = nameText.getText();
        String fathName = fathText.getText();
        String address = addressText.getText();
        String email = emailText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();
        String dob = ((JTextField)dobCal.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(maleButton.isSelected()){
            gender = "Male";
        } else if (femaleButton.isSelected()) {
            gender = "Female";
        } else if (otherButton.isSelected()) {
            gender = "Other";
        }

        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fathName+"','"+address+"','"+email+"','"+city+"','"+state+"','"+pin+"','"+dob+"','"+gender+"','"+marital+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        setVisible(false);
        new AdditionalDetails(formNo);


    }

    public static void main(String[] args) {
        new PersonalDetails();
    }
}
