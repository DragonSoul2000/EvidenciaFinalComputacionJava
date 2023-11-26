import DAO.PacientesCRUD;
import Entidades.Entidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RegistroPaciente extends JFrame {
    private JComboBox CMBUrgenciaMedica;
    private JComboBox TFPAciente;
    private JTextField TFFecha;
    private JTextField TFCasoPaciente;
    private JButton BTNAceptar;
    private JPanel MiPanel;
    private JTextField TFMatricula;
    private JComboBox CMBDoctor;
    private JTextField TFNombrePaciente;
    private JButton BTNCancelar;
    ArrayList<Entidades> otraLista;
    ArrayList<Entidades> otraLista2;


    /* Verificar la fecha para el combobx
    public boolean validarFecha(String fecha){

        try{
            SimpleDateFormat formatoFecha =
                    new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        }catch(Exception e){
            return false;
        }
        return true;


    }

     */


    public RegistroPaciente() {
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Doctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Entidades>) o;
            for(Entidades a: otraLista){
                CMBDoctor.addItem(a.getIdPaciente());

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        BTNAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //instanciar objeto
                // Guardar en archivo Paciente:
                Entidades a= new Entidades();
                a.setIdPaciente(TFMatricula.getText());
                a.setNombrePaciente(TFNombrePaciente.getText());
                a.setCasoPaciente(TFCasoPaciente.getText());
                //duda
                a.setNivelUrgenciaPaciente(CMBUrgenciaMedica.toString());
                //fecha

                /* Inento de hacer la fecha con combobox
                String date= cmbDia.getSelectedItem().toString() + "/" +cmbMes.getSelectedItem().toString()+ "/"+ cmbYear.getSelectedItem().toString();
                boolean result= validarFecha(date);
                if (result){
                    TFDATE.setText(date);
                }
                else{
                    JOptionPane.showMessageDialog(MiPanel,"error en la fecha");
                    TFDATE.requestFocus();
                }

                 */



                a.setFechaConsulta(new Date());
                //Verificar
                a.setNombreDoctor(CMBDoctor.toString());

                /* //Guardar en archivo Doctor

                Entidades b= new Entidades();
                b.setIdDoctor(CMBDoctor.toString());
                b.setNombreDoctor(CMBDoctor.toString());
                b.setIdPaciente(TFMatricula.getText());

                 */

                //invocar metodo de insertarPaciente
                PacientesCRUD crud = new PacientesCRUD();
                crud.insertarPaciente(a);
                /*invocar metodo de insertarDoctor
                DoctorCRUD crud1= new DoctorCRUD();
                crud1.insertarDoctor(b);

                 */






            }
        });
        BTNCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        CMBUrgenciaMedica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nivelUrgencia="";
                String nivel = CMBUrgenciaMedica.getSelectedItem().toString();
                for (Entidades a:otraLista2){
                    if (a.getNiveluPaciente().equals(nivel)){
                        nivelUrgencia= a.getNivelUrgenciaPaciente();
                        break;
                    }
                }
            }
        });
        CMBDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreDoctor="";
                String name=CMBDoctor.getSelectedItem().toString();
                for (Entidades b:otraLista){
                    if (b.getNombreDoctor().equals(name)){
                        nombreDoctor= b.getNombreDoctor();
                        break;
                    }

                }

            }
        });
    }

    public static void main(String[] args) {
        RegistroPaciente M = new RegistroPaciente();
        M.setContentPane(M.MiPanel);
        M.setSize(500,500);;
        M.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        M.setVisible(true);
    }





}
