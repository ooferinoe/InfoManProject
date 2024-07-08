package infomanproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class citeLogin extends JFrame implements MouseListener
{
    //JComboBox options
    private String[] MonthOptions = {"", "January", "February", "March", "April",
    "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] DayOptions = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
    "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] YearOptions = {"", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
    "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"};
    
    private JPanel header, footer, dark;
    private ImageIcon Logo, Logo2;
    private JComboBox<String> cbMonth = new JComboBox<>(MonthOptions);
    private JComboBox<String> cbDay = new JComboBox<>(DayOptions);
    private JComboBox<String> cbYear = new JComboBox<>(YearOptions);
    private JLabel lblLogo, lblLogo2, lblTitle, lblLogin, lblID, lblPass, lblMonth, lblDay, lblYear, lblCreate, lblContact, lblAbout, lblCD;
    private JTextField tfID;
    private JPasswordField pfPass;
    private JButton btnLogin, btnForgot;
    private JCheckBox chShow;
    
    private int Logins = 0;
    private long cdEnd = 0;
    private final long cdDuration = 10000;
    private Timer cdTimer;
    
    citeLogin()
    {
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(255,247,216));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
        //Background Settings
        Logo = new ImageIcon("Images/PUP_Logo.png");
        Image ResizedLogo = Logo.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon FinalLogo = new ImageIcon(ResizedLogo);
        lblLogo = new JLabel(FinalLogo);
        
        Logo2 = new ImageIcon("Images/PUPBC_Logo.png");
        Image ResizedLogo2 = Logo2.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon FinalLogo2 = new ImageIcon(ResizedLogo2);
        lblLogo2 = new JLabel(FinalLogo2);
        lblLogo2.setBounds(110,160,300,300);
        
        
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
        add(lblLogo2);
        
        lblCD = new JLabel();
        lblCD.setBounds(50,530,300,30);
        lblCD.setFont(new Font("Times New Roman", Font.BOLD,20));
        lblCD.setVisible(false);
        add(lblCD);
        
        //Login
        lblLogin = new JLabel("ADMIN LOGIN");
        lblLogin.setBounds(640, 100, 200, 40);
        lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblLogin);
        
        //Student ID
        lblID = new JLabel("Username:");
        lblID.setBounds(550, 150, 120, 40);
        lblID.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblID);
        
        tfID = new JTextField();
        tfID.setBounds(540,180,330,30);
        tfID.setEditable(true);
        add(tfID);
        
        //Password
        lblPass = new JLabel("Password:");
        lblPass.setBounds(550,230,120,40);
        lblPass.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblPass);
        
        pfPass = new JPasswordField();
        pfPass.setBounds(540,260,330,30);
        pfPass.setEditable(true);
        add(pfPass);
        
        chShow = new JCheckBox();
        chShow.setBounds(840,295,20,20);
        chShow.setBackground(new Color(235,227,196));
        chShow.addMouseListener(this);
        add(chShow);
        
        //Birthday
        lblMonth = new JLabel("Month:");
        lblMonth.setBounds(550,310,100,30);
        lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblMonth);
        
        lblDay = new JLabel("Day:");
        lblDay.setBounds(665, 310,100,30);
        lblDay.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblDay);
        
        lblYear = new JLabel("Year:");
        lblYear.setBounds(780,310,100,30);
        lblYear.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblYear);
        
        cbMonth.setBounds(540,340,100,30);
        add(cbMonth);
        
        cbDay.setBounds(655,340,100,30);
        add(cbDay);
        
        cbYear.setBounds(770,340,100,30);
        add(cbYear);
        
        //Bottom Part
        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(606,400,200,40);
        btnLogin.setBackground(new java.awt.Color(0,162,232));
        btnLogin.setFont(new Font("Arial",Font.BOLD,15));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setEnabled(true);
        btnLogin.addMouseListener(this);
        add(btnLogin);
        
        btnForgot = new JButton("FORGOT PASSWORD");
        btnForgot.setBounds(606,470,200,40);
        btnForgot.setBackground(new java.awt.Color(217,0,0));
        btnForgot.setFont(new Font("Arial",Font.BOLD,15));
        btnForgot.setForeground(Color.WHITE);
        add(btnForgot);
        
        lblCreate = new JLabel("REGISTER");
        lblCreate.setBounds(580,520,120,40);
        lblCreate.setFont(new Font("Arial",Font.BOLD,12));
        lblCreate.setForeground(new java.awt.Color(0,162,232));
        lblCreate.addMouseListener(this);
        add(lblCreate);
        
        lblContact = new JLabel("CONTACT");
        lblContact.setBounds(685,520,120,40);
        lblContact.setFont(new Font("Arial",Font.BOLD,12));
        lblContact.setForeground(new java.awt.Color(0,162,232));
        add(lblContact);
        
        lblAbout = new JLabel("ABOUT");
        lblAbout.setBounds(790,520,120,40);
        lblAbout.setFont(new Font("Arial",Font.BOLD,12));
        lblAbout.setForeground(new java.awt.Color(0,162,232));
        add(lblAbout);
        
        dark = new JPanel();
        dark.setBackground(new java.awt.Color(235,227,196));
        dark.setBounds(525,90,375,510);
        add(dark);
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource()==lblCreate)
        {
            dispose();
            citeRegister regis = new citeRegister();
            regis.setVisible(true);
        }
        else if(e.getSource()==btnLogin)
        {
            String number = tfID.getText();
            String pass = pfPass.getText();
            Object month = cbMonth.getSelectedIndex();
            Object day = cbDay.getSelectedIndex();
            Object year = cbYear.getSelectedIndex();
            
            if(number.equalsIgnoreCase("Atomoz") && pass.equals("ooferinoe") && month.equals(7)
                    && day.equals(7) && year.equals(5))
            {
                Logins = 0;
                JOptionPane.showMessageDialog(null, "Redirecting to Viewing Table...","Login Success",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                citeView view = new citeView();
                view.setVisible(true);
            }
            
            else if(number.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter your student ID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if(pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter your password.", "Missing password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if(month.equals(0))
            {
                JOptionPane.showMessageDialog(null, "Please enter your birth month.", "Missing birth month", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if(day.equals(0))
            {
                JOptionPane.showMessageDialog(null, "Please enter your birth day.", "Missing birth day", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            else if(year.equals(0))
            {
                JOptionPane.showMessageDialog(null, "Please enter your birth year.", "Missing birth year", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            
            else 
            {
                Logins ++;
                if (Logins >= 5)
                {
                    cdEnd = System.currentTimeMillis() + cdDuration;
                    JOptionPane.showMessageDialog(null, "Too many failed login attempts. Please try again later.", "Login limit reached",JOptionPane.ERROR_MESSAGE);
                    lblCD.setVisible(true);
                    startCDTimer();
                    btnLogin.setEnabled(false);
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Information incorrect. Please try again.","Login invalid",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
            
            
        }
        else if(e.getSource()==chShow)
        {
            if(chShow.isSelected())
            {
                pfPass.setEchoChar((char)0);
            }
            else
            {
                pfPass.setEchoChar('•');
            }
        }
    }
    
    private void startCDTimer()
    {
        cdTimer = new TimerImpl(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            long currentTime = System.currentTimeMillis();
            if (currentTime < cdEnd)
            {
                long remCD = (cdEnd - currentTime) / 1000;
                lblCD.setText("Cooldown: " + remCD + " seconds remaining.");
            }
            
            else
            {
                cdTimer.stop();
                lblCD.setVisible(false);
                btnLogin.setEnabled(true);
                Logins = 0;
            }
            }
        });
        cdTimer.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private static class TimerImpl extends Timer
    {
        public TimerImpl(int delay, ActionListener listener)
        {
            super(delay, listener);
        }
    }
}
