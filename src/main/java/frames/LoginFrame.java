package frames;

import menus.MenuCustomer;
import menus.MenuEmployee;
import controllers.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        super("Banking System");
        JFrame loginWindow = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setResizable(false);
        setLayout(new GridLayout(3,1,20,20));

        JLabel login_label = new JLabel("Login");
        login_label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(login_label);

        JPanel text_fields_panel = new JPanel(new BorderLayout(10, 10));
        text_fields_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField username_field = new JTextField(1);
        JTextField password_field = new JTextField(1);
        text_fields_panel.add(username_field,BorderLayout.NORTH);
        text_fields_panel.add(password_field,BorderLayout.SOUTH);

        this.add(text_fields_panel);

        JPanel login_button_panel= new JPanel();
        login_button_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        login_button_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] customer;
                try {
                    String username= username_field.getText();
                    String password = password_field.getText();
                    customer = Login.login(true,username,password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String social_security_number = customer[0];
                String role = customer[1];

                if (social_security_number.equals("Invalid login credentials")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid login credentials", "controllers.Login Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                switch (role) {
                    case "customer" -> {
                        MenuCustomer menu = new MenuCustomer(social_security_number);
                        try {
                            menu.showMenu(social_security_number);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    case "employee" -> {
                        MenuEmployee menu = new MenuEmployee(social_security_number);
                        try {
                            menu.showMenu(social_security_number);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    case "admin" -> {
                        JFrame adminWindow = new AdminFrame(social_security_number);
                    }
                    default -> System.out.println("Invalid role");
                }
                loginWindow.dispose();
            }
        });
        login_button_panel.add(loginButton);
        this.add(login_button_panel);

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
