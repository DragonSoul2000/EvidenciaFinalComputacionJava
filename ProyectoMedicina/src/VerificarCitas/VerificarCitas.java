package VerificarCitas;

import DAO.PacientesCRUD;
import Entidades.Entidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VerificarCitas extends JFrame {
    private JPanel MiPanel;
    private JComboBox CMBIdPaciente;
    private JComboBox CMBIdDoctor;
    private JTextField TFPacienteNombre;
    private JTextArea textArea1;
    private JTextField TFDoctorNombre;
    private JButton BTNIngresar;
    private JButton BTNCancelar;
    private JButton BTNLimpiar;
    private JButton BTNBuscar;
    private JButton btnNuevo;
    ArrayList<Entidades> otraLista;



    /*
    Metodo para validar fecha

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
     *///Fin del metodo para validar fecha


    //Metodo para limpiar
    public  void Limpiar(){
        // este for va a ser para seleccionar todos los componentes que tiene en este panel
        for (Component component :MiPanel.getComponents()){
            if (component instanceof JTextField){
                ((JTextField)component).setText("");

            } if (component instanceof JComboBox){
                ((JComboBox)component).setSelectedIndex(0);

            }
            if (component instanceof TextArea){
                ((TextArea)component).setText("");
            }
        }
    }

    //fin del metodo para limpiar


public VerificarCitas() {

    try {

        //Datos Pacientes
        FileInputStream leer =
                new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Paciente.txt");
        ObjectInputStream miStream2 = new ObjectInputStream(leer);
        Object o = miStream2.readObject();
        otraLista = (ArrayList<Entidades>) o;
        for(Entidades a: otraLista){
            CMBIdPaciente.addItem(a.getIdPaciente());
        }

        //Datos Doctor
        FileInputStream leer2 =
                new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Doctores.txt");
        ObjectInputStream miStream3 = new ObjectInputStream(leer2);
        Object l = miStream3.readObject();
        otraLista = (ArrayList<Entidades>) l;
        for(Entidades a: otraLista){
            CMBIdDoctor.addItem(a.getIdDoctor());
        }


    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }







    CMBIdPaciente.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(miPanel,cmbAlumno.getSelectedItem());
            String nombrePaciente="";
            String mat = CMBIdPaciente.getSelectedItem().toString();
            for(Entidades a: otraLista){
                if(a.getIdPaciente().equals(mat)){
                    nombrePaciente =  a.getNombrePaciente();
                    break;
                }
            }

            TFPacienteNombre.setText(nombrePaciente);
            String nombreDoctor="";
            String idDoctor = CMBIdDoctor.getSelectedItem().toString();
            for(Entidades b: otraLista){
                if(b.getIdDoctor().equals(idDoctor)){
                    nombrePaciente =  b.getNombrePaciente();
                    break;
                }
            }


        }

    });

    BTNBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //buscar idPaciente
            PacientesCRUD crud = new PacientesCRUD();
            String idPaciente = CMBIdPaciente.getSelectedItem().toString();
            Entidades a= crud.buscarPacientesPorID(idPaciente);
            if(a == null){
                //JOptionPane.showMessageDialog(miPanel,"No se encuentra el alumno con la matricula: " + matricula,"Alumnos",JOptionPane.ERROR_MESSAGE);
                int respuesta = JOptionPane.showConfirmDialog(MiPanel,"No hay Paciente registrado: "+ "\n¿Desea dar de alta?" ,"Paciente",JOptionPane.YES_NO_OPTION);
                if(respuesta == 0){
                    //sí quiere dar de alta el alumno inexistente
                    btnNuevo.setEnabled(true);
                }else if(respuesta == 1){
                    //no quiere dar de alta
                    //limpiar formulario
                    //invocar método para limpiar


                }
            }
            else{
                TFPacienteNombre.setText(a.getNombrePaciente());
                textArea1.setText("Tiene urgencia de:"+a.getNiveluPaciente()+"\nPor caso del "+a.getCasoPaciente()+"su fecha es la del : "+ a.getFechaConsulta()
                +"con el doctor: " +a.getNombreDoctor());
            }


        }
    });
    BTNLimpiar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Limpiar();

        }
    });
    BTNCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    });
}
    public static void main(String[] args) {
        VerificarCitas citas= new VerificarCitas();
        citas.setContentPane(citas.MiPanel);
        citas.setSize(300,3000);
        citas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        citas.setVisible(true);

    }
}
