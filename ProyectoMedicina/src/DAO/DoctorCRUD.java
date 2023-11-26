package DAO;

import Entidades.Entidades;

import java.io.*;
import java.util.ArrayList;

public class DoctorCRUD {
    public void insertarDoctor(Entidades b){
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Doctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Entidades> otraLista = (ArrayList<Entidades>)o;
            otraLista.add(b);

            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\Users\\Study\\Desktop\\Lista\\Doctores.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Entidades buscarPacientesPorID(String matricula){
        //obtener lista de alumnos desde Archivo
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Doctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Entidades> otraLista = (ArrayList<Entidades>)o;
            for(Entidades a: otraLista){
                if(a.getIdPaciente().equals(matricula)){
                    return a;
                }
            }
            //saliendo del for
            miStream2.close();
            return null;



            // Alumno pruebaAlumno = otraLista.get(0);
            // System.out.println(pruebaAlumno.getNombre());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
