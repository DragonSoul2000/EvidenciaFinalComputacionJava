package DAO;

import Entidades.Entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class NivelUrgencia {
    public Entidades buscarPacientesPorID(String matricula) {
        //obtener lista de alumnos desde Archivo
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Study\\Desktop\\Lista\\Urgencia.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Entidades> otraLista2 = (ArrayList<Entidades>) o;
            for (Entidades a : otraLista2) {
                if (a.getIdPaciente().equals(matricula)) {
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
