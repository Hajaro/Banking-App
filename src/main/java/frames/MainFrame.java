package frames;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame(){
        super("Banking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);
        this.setVisible(true);

        JLabel login_label = new JLabel("controllers.Login");
        login_label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(login_label);
    }

}