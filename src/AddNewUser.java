import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class AddNewUser extends JFrame {

    private JPanel mainPnl;
    private JLabel iconLbl;
    private JLabel addNewUsrLbl;
    private JLabel usernameLbl;
    private JLabel usrIconLbl;
    private JLabel loginLbl;
    private JLabel usrLbl;
    private JLabel pswrdLbl;
    private JPasswordField passwordField1;
    private JTextField usrTxtFld;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel btnPnl;

    public AddNewUser() {
        super("Add User Window");
        createUIComponents();



    }

    private void createUIComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPnl);
        this.pack();
        this.setLocationRelativeTo(null);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils utils = new Utils();
                try {
                    String userName = usrTxtFld.getText();
                    String password = new String(passwordField1.getPassword());
                    if(utils.addNewUser(userName, password)) {
                        JOptionPane.showMessageDialog(null,
                                "User already exists.", "Information", QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "User added", "Alert", ERROR_MESSAGE);
                    }
                    usrTxtFld.setText("");
                    passwordField1.setText("");
                    usrTxtFld.grabFocus();

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                    e1.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewUser.super.dispose();
                JFrame login = LoginWindow_GUI.getLoginWindow();
                login.setVisible(true);
            }
        });

    }
}
