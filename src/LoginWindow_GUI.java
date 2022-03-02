import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class LoginWindow_GUI extends JFrame {

    private static LoginWindow_GUI loginWindow;
    private JPanel mainPnl;
    private JLabel usrIconLbl;
    private JLabel loginLbl;
    private JLabel usrLbl;
    private JLabel pswrdLbl;
    private JTextField usrTxtFld;
    private JPasswordField pswrdFld;
    private JPanel btnPnl;
    private JButton cnctBtn;
    private JButton cnclBtn;

    private LoginWindow_GUI() {
        super("Login Window");
        createUIComponents();
    }

    public static synchronized LoginWindow_GUI getLoginWindow() {
        if (loginWindow == null) {
            loginWindow = new LoginWindow_GUI();
        }
        return loginWindow;
    }

    private void createUIComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPnl);
        this.pack();
        this.setLocationRelativeTo(null);

        cnctBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils utils = new Utils();
                try {
                    String userName = usrTxtFld.getText();
                    String password = new String(pswrdFld.getPassword());
                    if(utils.checkLogin(userName, password)) {
                        JOptionPane.showMessageDialog(null,
                                "User found.\nAccess granted.", "Information", QUESTION_MESSAGE);
                        LoginWindow_GUI.super.setVisible(false);
                        JFrame addFrame = new AddNewUser();
                        addFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "User not found\nAccess denied", "Alert", ERROR_MESSAGE);
                    }
                    usrTxtFld.setText("");
                    pswrdFld.setText("");
                    usrTxtFld.grabFocus();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        cnclBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow_GUI.super.dispose();
            }
        });
    }

}
