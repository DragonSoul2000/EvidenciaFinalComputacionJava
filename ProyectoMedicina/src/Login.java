import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel miPanel;
    private JTextField TFUsuario;
    private JPasswordField PFPasword;
    private JButton BTNLogin;
    private JButton BTNCancelar;


    public Login() {
        BTNLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hardcodear= meter código estatico en un código que es dinamico (mala práctica pero sirve para hacer pruebas)
                String Password= String.valueOf(PFPasword.getPassword());
                //Bienvenida
                if (TFUsuario.getText().equals("admin")&& Password.equals("1234")){
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido admin");
                    dispose();
                    String[] tipoUsuario={"admin"};
                    Decicion.main(tipoUsuario);
                }
                /*
                //Si es usuario de otro nivel
                else  if (TFUsuario.getText().equals("Usuario")&&Password.equals("4567")){
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido usuario");

                }
                // si el usuario o la contraseña no son validas

                 */

                else {
                    JOptionPane.showMessageDialog(miPanel,"Usuario o contraseña incorrectas","login",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    public static void main(String[] args) {
        Login vlogin= new Login();
        vlogin.setContentPane(vlogin.miPanel);
        vlogin.setSize(300,3000);
        vlogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vlogin.setVisible(true);

    }
}
