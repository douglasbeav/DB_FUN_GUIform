import javax.swing.*;

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
    private JPasswordField pswrdFld;
    private JPanel btnPnl;
    private JButton cnctBtn;
    private JButton cnclBtn;

    public AddNewUser() {
        super("Add User Window");
        createUIComponents();

    }

    private void createUIComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPnl);
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
