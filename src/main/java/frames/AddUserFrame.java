package frames;

import javax.swing.*;
import managers.AdminManager;
import java.awt.*;
import java.sql.SQLException;

public class AddUserFrame extends JFrame {

    public AddUserFrame(String social_security_number, AdminFrame adminFrame) {
        super("Add user");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panel);

        JTextField social_security_number_field = new JTextField(20);
        JTextField username_field = new JTextField(20);
        JTextField password_field = new JTextField(20);
        JTextField first_name_field = new JTextField(20);
        JTextField last_name_field = new JTextField(20);
        JTextField age_field = new JTextField(20);
        JTextField role_field = new JTextField(20);

        JLabel social_security_number_label = new JLabel("Social security number");
        JLabel username_label = new JLabel("Username");
        JLabel password_label = new JLabel("Password");
        JLabel first_name_label = new JLabel("First name");
        JLabel last_name_label = new JLabel("Last name");
        JLabel age_label = new JLabel("Age");
        JLabel role_label = new JLabel("Role");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(social_security_number_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(social_security_number_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(username_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(username_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(password_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(password_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(first_name_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(first_name_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(last_name_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(last_name_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(age_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(age_field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(role_label, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(role_field, gbc);

        JButton addUserButton = new JButton("Add user");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addUserButton, gbc);

        addUserButton.addActionListener(e -> {
            if (social_security_number_field.getText().isEmpty() ||
                    username_field.getText().isEmpty() ||
                    password_field.getText().isEmpty() ||
                    first_name_field.getText().isEmpty() ||
                    last_name_field.getText().isEmpty() ||
                    age_field.getText().isEmpty() ||
                    role_field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;
            try {
                age = Integer.parseInt(age_field.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            AdminManager adminManager = new AdminManager(social_security_number);
            try {
                adminManager.addUser(
                        social_security_number_field.getText(),
                        username_field.getText(),
                        password_field.getText(),
                        first_name_field.getText(),
                        last_name_field.getText(),
                        age,
                        role_field.getText()
                );
                JOptionPane.showMessageDialog(this, "User added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                adminFrame.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while adding the user", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                adminFrame.setVisible(true);
            }

            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                adminFrame.setVisible(true);
            }
        });

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
