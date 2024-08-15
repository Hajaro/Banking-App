package frames;

import javax.swing.*;

import frames.AddUserFrame;

import java.awt.*;

public class AdminFrame extends JFrame{
    public AdminFrame(String social_security_number){
        super("Banking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel);

        JButton addUserButton = new JButton("Add user");
        JButton removeUserButton = new JButton("Remove user");
        JButton modifyUserButton = new JButton("Modify user");
        JButton modifyAccountButton = new JButton("Modify account");

        panel.add(addUserButton);

        addUserButton.addActionListener(e -> {
            JFrame addUserFrame = new AddUserFrame(social_security_number, this);
            this.setVisible(false);
        });

        removeUserButton.addActionListener(e -> {
            JFrame removeUserFrame = new RemoveUserFrame(social_security_number, this);
            this.setVisible(false);
        });
    }
}
