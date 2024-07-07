package infomanproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class citeView extends JFrame implements ActionListener
{
    private JPanel header, footer, dark, boarder;
    private ImageIcon Logo;
    private JLabel lblLogo, lblTitle, lblID, lblBday, lblBday2, lblFName, lblLName, lblMName, lblContact, lblCourse,
            lblYLevel, lblAddress, lblPosition, lblAffiliation, lblRegis, lblSearch;
    private JTextField tfID, tfFName, tfLName, tfMName, tfContact, tfSearch,
            tfCourse, tfYLevel, tfAddress, tfPosition, tfAffiliation, tfBday;
    private JButton btnLogout, btnClear, btnSearch, btnRegis;
    private Connection conn;
    
    citeView()
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
        
        //Search Bar
        lblSearch = new JLabel("Student No.");
        lblSearch.setBounds(205,100,120,40);
        lblSearch.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(lblSearch);
        
        tfSearch = new JTextField();
        tfSearch.setBounds(320,102,335,30);
        tfSearch.setEditable(true);
        add(tfSearch);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(670,106,80,20);
        btnSearch.setFont(new Font("Arial", Font.BOLD,10));
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        btnRegis = new JButton("Register");
        btnRegis.setBounds(780,106,80,20);
        btnRegis.setFont(new Font("Arial", Font.BOLD, 10));
        btnRegis.addActionListener(this);
        add(btnRegis);
        
        //1st Row (Student ID & Address)------------------------------------------------------------------------------------------------------
        lblID = new JLabel("Student Number:");
        lblID.setBounds(140,155,120,40);
        lblID.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblID);
        
        tfID = new JTextField();
        tfID.setBounds(130,185,300,30);
        tfID.setHorizontalAlignment(JTextField.CENTER);
        tfID.setBackground(Color.WHITE);
        tfID.setEditable(false);
        tfID.setFocusable(false);
        
        add(tfID);
        
        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(480,155,120,40);
        lblAddress.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(470,185,300,30);
        tfAddress.setHorizontalAlignment(JTextField.CENTER);
        tfAddress.setBackground(Color.WHITE);
        tfAddress.setEditable(false);
        tfAddress.setFocusable(false);
        add(tfAddress);
        
        
        //2nd Row (Last Name & Contact Number)-------------------------------------------------------------------------------------------------
        lblLName = new JLabel("Last Name:");
        lblLName.setBounds(140,235,120,40);
        lblLName.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblLName);
        
        tfLName = new JTextField();
        tfLName.setBounds(130,265,300,30);
        tfLName.setHorizontalAlignment(JTextField.CENTER);
        tfLName.setBackground(Color.WHITE);
        tfLName.setEditable(false);
        tfLName.setFocusable(false);
        add(tfLName);
        
        lblContact = new JLabel("Contact Number:");
        lblContact.setBounds(480,235,120,40);
        lblContact.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblContact);
        
        tfContact = new JTextField();
        tfContact.setBounds(470,265,300,30);
        tfContact.setHorizontalAlignment(JTextField.CENTER);
        tfContact.setBackground(Color.WHITE);
        tfContact.setEditable(false);
        tfContact.setFocusable(false);
        add(tfContact);
        
        
        //3rd Row (First Name & Birthday)-----------------------------------------------------------------------------------------------------
        lblFName = new JLabel("First Name:");
        lblFName.setBounds(140,315,120,40);
        lblFName.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblFName);
        
        tfFName = new JTextField();
        tfFName.setBounds(130,345,300,30);
        tfFName.setHorizontalAlignment(JTextField.CENTER);
        tfFName.setBackground(Color.WHITE);
        tfFName.setEditable(false);
        tfFName.setFocusable(false);
        add(tfFName);
        
        lblBday = new JLabel("Birthday:");
        lblBday.setBounds(480,315,120,40);
        lblBday.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblBday);
        
        tfBday = new JTextField();
        tfBday.setBounds(470,345,300,30);
        tfBday.setHorizontalAlignment(JTextField.CENTER);
        tfBday.setBackground(Color.WHITE);
        tfBday.setEditable(false);
        tfBday.setFocusable(false);
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
        tfMName.setBackground(Color.WHITE);
        tfMName.setEditable(false);
        tfMName.setFocusable(false);
        add(tfMName);
        
        lblPosition = new JLabel("Position:");
        lblPosition.setBounds(480,395,120,40);
        lblPosition.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblPosition);
        
        tfPosition = new JTextField();
        tfPosition.setBounds(470,425,300,30);
        tfPosition.setHorizontalAlignment(JTextField.CENTER);
        tfPosition.setBackground(Color.WHITE);
        tfPosition.setEditable(false);
        tfPosition.setFocusable(false);
        add(tfPosition);
        
        
        //5th Row (Course, Year Level, & Affiliation)------------------------------------------------------------------------------------------
        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(140,475,120,40);
        lblCourse.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblCourse);
        
        tfCourse = new JTextField();
        tfCourse.setBounds(130,505,145,30);
        tfCourse.setHorizontalAlignment(JTextField.CENTER);
        tfCourse.setBackground(Color.WHITE);
        tfCourse.setEditable(false);
        tfCourse.setFocusable(false);
        add(tfCourse);
        
        lblYLevel = new JLabel("Year Level:");
        lblYLevel.setBounds(295,475,120,40);
        lblYLevel.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblYLevel);
        
        tfYLevel = new JTextField();
        tfYLevel.setBounds(285,505,145,30);
        tfYLevel.setHorizontalAlignment(JTextField.CENTER);
        tfYLevel.setBackground(Color.WHITE);
        tfYLevel.setEditable(false);
        tfYLevel.setFocusable(false);
        add(tfYLevel);
        
        lblAffiliation = new JLabel("Affiliation:");
        lblAffiliation.setBounds(480,475,120,40);
        lblAffiliation.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblAffiliation);
        
        tfAffiliation = new JTextField();
        tfAffiliation.setBounds(470,505,300,30);
        tfAffiliation.setHorizontalAlignment(JTextField.CENTER);
        tfAffiliation.setBackground(Color.WHITE);
        tfAffiliation.setEditable(false);
        tfAffiliation.setFocusable(false);
        add(tfAffiliation);
        
        
        //Buttons
        btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(150,550,175,35);
        btnLogout.setBackground(new java.awt.Color(0,162,232));
        btnLogout.setFont(new Font("Arial",Font.BOLD,15));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(this);
        add(btnLogout);
        
        btnClear = new JButton("CLEAR");
        btnClear.setBounds(575,550,175,35);
        btnClear.setBackground(new java.awt.Color(217,0,0));
        btnClear.setFont(new Font("Arial",Font.BOLD,15));
        btnClear.setForeground(Color.WHITE);
        btnClear.addActionListener(this);
        add(btnClear);
        
        //Panel Settings
        dark = new JPanel();
        dark.setBackground(new java.awt.Color(235,227,196));
        dark.setBounds(102,152,696,441);
        add(dark);
        
        boarder = new JPanel();
        boarder.setBackground(Color.BLACK);
        boarder.setBounds(100,150,700,445);
        add(boarder);
        
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite", "root","");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnLogout)
        {
            dispose();
            citeLogin login = new citeLogin();
        }
        
        else if(e.getSource()==btnClear)
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
        
        else if(e.getSource()==btnSearch)
        {
            Search();
        }
        
        else if(e.getSource()==btnRegis)
        {
            dispose();
            citeRegister regis = new citeRegister();
            regis.setVisible(true);
        }
    }
    
    private void Search()
    {
        String searchNum = tfSearch.getText();
        if(searchNum.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a student number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            String query = "SELECT * FROM tbl_cite WHERE stud_ID = ?";
            PreparedStatement withdrawPS = conn.prepareStatement(query);
            withdrawPS.setString(1, searchNum);
            ResultSet withdrawRS = withdrawPS.executeQuery();
            
            if (withdrawRS.next())
            {
                String ID = withdrawRS.getString("stud_ID");
                String LName = withdrawRS.getString("stud_LName");
                String FName = withdrawRS.getString("stud_FName");
                String MName = withdrawRS.getString("stud_MName");
                String c = withdrawRS.getString("course");
                String yL = withdrawRS.getString("yearLevel");
                String a = withdrawRS.getString("address");
                String cN = withdrawRS.getString("contactNum");
                String BD = withdrawRS.getString("BDAY");
                String pos = withdrawRS.getString("Position");
                String o = withdrawRS.getString("Organization");

                tfID.setText(ID);
                tfLName.setText(LName);
                tfFName.setText(FName);
                tfMName.setText(MName);
                tfCourse.setText(c);
                tfYLevel.setText(yL);
                tfAddress.setText(a);
                tfContact.setText(cN);
                tfBday.setText(BD);
                tfPosition.setText(pos);
                tfAffiliation.setText(o);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Student number not found.","Error",JOptionPane.ERROR_MESSAGE);
            }


        }
        
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Database error.","Error",JOptionPane.ERROR_MESSAGE);
        } 
    }
}
