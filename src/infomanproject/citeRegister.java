package infomanproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class citeRegister extends JFrame implements ActionListener
{
    private JPanel header, footer, dark, boarder;
    private ImageIcon Logo;
    private JLabel lblLogo, lblTitle, lblID, lblBday, lblBday2, lblFName, lblLName, lblMName, lblContact, lblCourse,
            lblYLevel, lblAddress, lblPosition, lblAffiliation, lblRegis;
    private JTextField tfID, tfFName, tfLName, tfMName, tfContact,
            tfCourse, tfYLevel, tfAddress, tfPosition, tfAffiliation, tfBday;
    private JButton btnBack, btnClear, btnRegis, btnView;
    
    
    citeRegister()
    {
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(new Color(255,247,216));
        
        //Background Settings
        Logo = new ImageIcon("Images/PUP_Logo.png");
        Image ResizedLogo = Logo.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon FinalLogo = new ImageIcon(ResizedLogo);
        lblLogo = new JLabel(FinalLogo);
        
        header = new JPanel();
        header.setBounds(0,0,900,90);
        header.setBackground(new Color(173,20,0));
        add(header);
        
        footer = new JPanel();
        footer.setBounds(0,600,900,90);
        footer.setBackground(new Color(173,20,0));
        add(footer);
        
        lblTitle = new JLabel("Polytechnic University of the Philippines");
        lblTitle.setForeground(new Color(255,227,0));
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        header.add(lblLogo);
        header.add(lblTitle);
        
        //Registration
                lblRegis = new JLabel("REGISTRATION",SwingConstants.CENTER);
        lblRegis.setBounds(0,100,900,40);
        lblRegis.setFont(new Font("Times New Roman", Font.BOLD,30));
        add(lblRegis);
        
        
        //1st Row (Student ID & Address)------------------------------------------------------------------------------------------------------
        lblID = new JLabel("Student Number:");
        lblID.setBounds(140,155,120,40);
        lblID.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblID);
        
        tfID = new JTextField();
        tfID.setBounds(130,185,300,30);
        tfID.setHorizontalAlignment(JTextField.CENTER);
        add(tfID);
        
        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(480,155,120,40);
        lblAddress.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(470,185,300,30);
        tfAddress.setHorizontalAlignment(JTextField.CENTER);
        add(tfAddress);
        
        
        //2nd Row (Last Name & Contact Number)-------------------------------------------------------------------------------------------------
        lblLName = new JLabel("Last Name:");
        lblLName.setBounds(140,235,120,40);
        lblLName.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblLName);
        
        tfLName = new JTextField();
        tfLName.setBounds(130,265,300,30);
        tfLName.setHorizontalAlignment(JTextField.CENTER);
        add(tfLName);
        
        lblContact = new JLabel("Contact Number:");
        lblContact.setBounds(480,235,120,40);
        lblContact.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblContact);
        
        tfContact = new JTextField();
        tfContact.setBounds(470,265,300,30);
        tfContact.setHorizontalAlignment(JTextField.CENTER);
        add(tfContact);
        
        
        //3rd Row (First Name & Birthday)-----------------------------------------------------------------------------------------------------
        lblFName = new JLabel("First Name:");
        lblFName.setBounds(140,315,120,40);
        lblFName.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblFName);
        
        tfFName = new JTextField();
        tfFName.setBounds(130,345,300,30);
        tfFName.setHorizontalAlignment(JTextField.CENTER);
        add(tfFName);
        
        lblBday = new JLabel("Birthday:");
        lblBday.setBounds(480,315,120,40);
        lblBday.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblBday);
        
        tfBday = new JTextField();
        tfBday.setBounds(470,345,300,30);
        tfBday.setHorizontalAlignment(JTextField.CENTER);
        add(tfBday);
        
        lblBday2 = new JLabel("YYYY-MM-DD");
        lblBday2.setBounds(590,365,120,30);
        lblBday2.setFont(new Font("Arial", Font.PLAIN,10));
        add(lblBday2);
        
        
        //4th Row (Middle Name & Position)-----------------------------------------------------------------------------------------------------
        lblMName = new JLabel("Middle Name:");
        lblMName.setBounds(140,395,120,40);
        lblMName.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblMName);
        
        tfMName = new JTextField();
        tfMName.setBounds(130,425,300,30);
        tfMName.setHorizontalAlignment(JTextField.CENTER);
        add(tfMName);
        
        lblPosition = new JLabel("Position:");
        lblPosition.setBounds(480,395,120,40);
        lblPosition.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblPosition);
        
        tfPosition = new JTextField();
        tfPosition.setBounds(470,425,300,30);
        tfPosition.setHorizontalAlignment(JTextField.CENTER);
        add(tfPosition);
        
        
        //5th Row (Course, Year Level, & Affiliation)------------------------------------------------------------------------------------------
        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(140,475,120,40);
        lblCourse.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblCourse);
        
        tfCourse = new JTextField();
        tfCourse.setBounds(130,505,145,30);
        tfCourse.setHorizontalAlignment(JTextField.CENTER);
        add(tfCourse);
        
        lblYLevel = new JLabel("Year Level:");
        lblYLevel.setBounds(295,475,120,40);
        lblYLevel.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblYLevel);
        
        tfYLevel = new JTextField();
        tfYLevel.setBounds(285,505,145,30);
        tfYLevel.setHorizontalAlignment(JTextField.CENTER);
        add(tfYLevel);
        
        lblAffiliation = new JLabel("Affiliation:");
        lblAffiliation.setBounds(480,475,120,40);
        lblAffiliation.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblAffiliation);
        
        tfAffiliation = new JTextField();
        tfAffiliation.setBounds(470,505,300,30);
        tfAffiliation.setHorizontalAlignment(JTextField.CENTER);
        add(tfAffiliation);
        
        
        //Buttons
        btnBack = new JButton("BACK");
        btnBack.setBounds(150,550,175,35);
        btnBack.setBackground(new java.awt.Color(0,162,232));
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        add(btnBack);
        
        btnClear = new JButton("CLEAR");
        btnClear.setBounds(575,550,175,35);
        btnClear.setBackground(new java.awt.Color(217,0,0));
        btnClear.setFont(new Font("Arial",Font.BOLD,15));
        btnClear.setForeground(Color.WHITE);
        btnClear.addActionListener(this);
        add(btnClear);
        
        btnRegis = new JButton("REGISTER");
        btnRegis.setBounds(360,550,175,35);
        btnRegis.setBackground(new java.awt.Color(232,232,232));
        btnRegis.setFont(new Font("Arial",Font.BOLD,15));
        btnRegis.setForeground(Color.BLACK);
        btnRegis.addActionListener(this);
        add(btnRegis);
        
        btnView = new JButton("View");
        btnView.setBounds(780,106,80,20);
        btnView.setFont(new Font("Arial", Font.BOLD, 10));
        btnView.addActionListener(this);
        add(btnView);
        
        //Panel Settings
        dark = new JPanel();
        dark.setBackground(new java.awt.Color(235,227,196));
        dark.setBounds(102,152,696,441);
        add(dark);
        
        boarder = new JPanel();
        boarder.setBackground(Color.BLACK);
        boarder.setBounds(100,150,700,445);
        add(boarder);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnBack)
        {
            dispose();
            citeLogin log = new citeLogin();
            log.setVisible(true);
        }
        
        else if (e.getSource()==btnClear)
        {
            tfID.setText("");
            tfLName.setText("");
            tfFName.setText("");
            tfMName.setText("");
            tfCourse.setText("");
            tfYLevel.setText("");
            tfAddress.setText("");
            tfContact.setText("");
            tfBday.setText("");
            tfPosition.setText("");
            tfAffiliation.setText("");
        }
        
        else if (e.getSource()==btnRegis)
        {
            Register();
        }
        
        else if(e.getSource()==btnView)
        {
            dispose();
            citeView view = new citeView();
            view.setVisible(true);
        }
        
        
    }
    private void Register()
        {
            String noID = tfID.getText();
            String noLN = tfLName.getText();
            String noFN = tfFName.getText();
            String noC = tfCourse.getText();
            String noYL = tfYLevel.getText();
            String noA = tfAddress.getText();
            String noCN = tfContact.getText();
            String noP = tfPosition.getText();
            String noAf = tfAffiliation.getText();
            
            if (noID.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a student number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noLN.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a last name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noFN.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a first name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noC.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a course.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noYL.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a Year Level.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noA.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a Address.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noCN.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a contact number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noP.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a position.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if (noAf.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a affiliation.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try
            {
                String query = "INSERT INTO `tbl_cite` (`stud_ID`,`stud_LName`,`stud_FName`,`stud_MName`,`course`,`yearLevel`,`address`,`contactNum`,`BDAY`,`Position`,`Organization`)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite","root","");
                PreparedStatement PS = conn.prepareStatement(query);
                
                PS.setString(1,tfID.getText());
                PS.setString(2,tfLName.getText());
                PS.setString(3,tfFName.getText());
                PS.setString(4,tfMName.getText());
                PS.setString(5,tfCourse.getText());
                PS.setString(6,tfYLevel.getText());
                PS.setString(7,tfAddress.getText());
                PS.setString(8,tfContact.getText());
                PS.setString(9,tfBday.getText());
                PS.setString(10,tfPosition.getText());
                PS.setString(11,tfAffiliation.getText());
                
                PS.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Registered Successfully");
            }
            
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            tfID.setText("");
            tfLName.setText("");
            tfFName.setText("");
            tfMName.setText("");
            tfCourse.setText("");
            tfYLevel.setText("");
            tfAddress.setText("");
            tfContact.setText("");
            tfBday.setText("");
            tfPosition.setText("");
            tfAffiliation.setText("");
        }
}