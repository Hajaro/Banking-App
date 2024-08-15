package frames;

import managers.AdminManager;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveUserFrame extends JFrame {
    public RemoveUserFrame(String socialSecurityNumber, AdminFrame adminFrame) {
        super("Remove user");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panel);

        JTextField social_security_number_field = new JTextField(20);

        JLabel social_security_number_label = new JLabel("Social security number");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(social_security_number_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(social_security_number_field, gbc);

        JButton searchUserButton = new JButton("Search user");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(searchUserButton, gbc);

        searchUserButton.addActionListener(e -> {
            String userSocialSecurityNumber = social_security_number_field.getText();
            AdminManager adminManager = new AdminManager(socialSecurityNumber);
            try {
                ResultSet user = adminManager.searchUser(userSocialSecurityNumber);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });


    }
}
