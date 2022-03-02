public class DB_Test {

    public static void main(String[] args) {
        Utils.connect("root", "12345678");
        LoginWindow_GUI window = LoginWindow_GUI.getLoginWindow();
//        AddNewUser window = new AddNewUser();
        window.setVisible(true);
    }

}
