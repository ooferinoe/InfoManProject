package infomanproject;


import java.awt.*;

public class InfoManProject {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
                    public void run()
                    {
                        citeStartUp start = new citeStartUp();
                        start.setVisible(true);  
                    }
        });
    }
}

