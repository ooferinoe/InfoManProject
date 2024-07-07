package infomanproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class citeStartUp extends JFrame
{
    private JPanel header, footer;
    private JLabel lblLogo, lblTitle, lblLoad;
    private ImageIcon Logo;
    private JProgressBar pbLoad;
    
    citeStartUp()
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
        
        //Progress Bar Settings
        lblLoad = new JLabel("STARTING UP PLEASE WAIT...");
        lblLoad.setBounds(215,300,500,40);
        lblLoad.setFont(new Font("Arial", Font.BOLD,30));
        add(lblLoad);
        
        pbLoad = new JProgressBar();
        pbLoad.setValue(0);
        pbLoad.setStringPainted(false);
        pbLoad.setBounds(185,350,500,30);
        pbLoad.setBackground(new Color(245,237,207));
        pbLoad.setForeground(Color.WHITE);
        add(pbLoad);
        
        new BackgroundTask().execute();
    }
    
    private class BackgroundTask extends SwingWorker<Void, Integer>
    {
        @Override
        protected Void doInBackground() throws Exception
        {
            int i = 0;
            while (i <= 100)
            {
                publish(i);
                Thread.sleep(600);
                i += 29;
            }
            return null;
        }
        
        @Override
        protected void process(java.util.List<Integer> chunks)
        {
            int value = chunks.get(chunks.size() - 1);
            pbLoad.setValue(value);
        }
        
        @Override
        protected void done()
        {
            dispose();
            citeLogin log = new citeLogin();
            log.setVisible(true);
                pbLoad.setValue(100);
        }
    }
}
