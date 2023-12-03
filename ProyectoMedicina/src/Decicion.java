import VerificarCitas.VerificarCitas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Decicion extends JFrame {
    private JPanel miPanel;
    private JButton BTNRegistro;
    private JButton BTNVerificar;



    public Decicion() {
        BTNRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(miPanel,"Registro de pacientes");
                dispose();
                String[] tipoUsuario={"admin"};
                RegistroPaciente.main(tipoUsuario);
            }
        });
        BTNVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(miPanel,"Registro de pacientes");
                dispose();
                String[] tipoUsuario={"admin"};
                VerificarCitas.main(tipoUsuario);
            }
        });
    }

    public static void main(String[] args) {
        Decicion decicion= new Decicion();
        decicion.setContentPane(decicion.miPanel);
        decicion.setSize(300,3000);
        decicion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        decicion.setVisible(true);

    }
}
