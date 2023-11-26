package PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel MiPanel;
    private JButton BTNRegistroPaciente;
    private JButton BTNBuscarDoctor;


    public Ventana() {
        BTNRegistroPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 Registro r = new Registro();
        r.setVisible(true);
        r.pack();
        r.setLocationRelativeTo(null);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
                 */




            }
        });
    }

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setContentPane(v.MiPanel);
        v.setSize(500,500);;
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }


}
