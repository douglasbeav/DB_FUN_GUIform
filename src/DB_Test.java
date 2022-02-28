public class DB_Test {

    public static void main(String[] args) {
        Utils.connect("root", "12345678");
        LoginWindow_GUI window = new LoginWindow_GUI();
        window.setVisible(true);
    }

}
