import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class PersonalDetails extends JFrame {

    PersonalDetails(){
        setSize(830,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random ranNum = new Random();
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + (Math.abs(ranNum.nextLong() % 9000L) + 1000L));
        formNo.setFont(new Font("Raleway",Font.BOLD,35));
        formNo.setBounds(150,10,600,60);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        personalDetails.setBounds(220,80,400,50);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(150,140,150,40);
        add(name);

        JTextField nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD,20));
        nameText.setBounds(350,140,400,40);
        add(nameText);

        JLabel  fathName = new JLabel("Father's Name: ");
        fathName.setFont(new Font("Raleway",Font.BOLD,20));
        fathName.setBounds(150,200,150,40);
        add(fathName);

        JTextField fathText = new JTextField();
        fathText.setFont(new Font("Raleway", Font.BOLD,20));
        fathText.setBounds(350,200,400,40);
        add(fathText);

        JLabel  dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(150,260,150,40);
        add(dob);

        JDateChooser dobCal = new JDateChooser();
        dobCal.setFont(new Font("Raleway",Font.BOLD,20));
        dobCal.setBounds(350, 260, 400,40);
        add(dobCal);

        JLabel  gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(150,320,150,40);
        add(gender);

        JRadioButton maleButton = new JRadioButton("Male ");
        maleButton.setFont(new Font("Raleway", Font.BOLD,14));
        maleButton.setBounds(350,320,100,40);
        maleButton.setBackground(Color.WHITE);
        add(maleButton);

        JRadioButton femaleButton = new JRadioButton("Female ");
        femaleButton.setFont(new Font("Raleway", Font.BOLD,14));
        femaleButton.setBounds(450,320,100,40);
        femaleButton.setBackground(Color.WHITE);
        add(femaleButton);

        JRadioButton otherButton = new JRadioButton("Other ");
        otherButton.setFont(new Font("Raleway", Font.BOLD,14));
        otherButton.setBounds(580,320,100,40);
        otherButton.setBackground(Color.WHITE);
        add(otherButton);

        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);

        JLabel  email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(150,380,150,40);
        add(email);

        JTextField emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD,20));
        emailText.setBounds(350,380,400,40);
        add(emailText);

        JLabel  marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(150,440,150,40);
        add(marital);

        JRadioButton married = new JRadioButton("Married ");
        married.setFont(new Font("Raleway", Font.BOLD,14));
        married.setBounds(350,440,100,40);
        married.setBackground(Color.WHITE);
        add(married);

        JRadioButton unmarried = new JRadioButton("Unmarried ");
        unmarried.setFont(new Font("Raleway", Font.BOLD,14));
        unmarried.setBounds(450,440,120,40);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        JRadioButton other = new JRadioButton("Other ");
        other.setFont(new Font("Raleway", Font.BOLD,14));
        other.setBounds(580,440,100,40);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel  address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(150,500,150,40);
        add(address);

        JTextField addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD,20));
        addressText.setBounds(350,500,400,40);
        add(addressText);

        JLabel  city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(150,560,150,40);
        add(city);

        JTextField cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD,20));
        cityText.setBounds(350,560,400,40);
        add(cityText);

        JLabel  pinCode = new JLabel("Pin Code: ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(150,620,150,40);
        add(pinCode);

        JTextField pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD,20));
        pinText.setBounds(350,620,400,40);
        add(pinText);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PersonalDetails();
    }
}
