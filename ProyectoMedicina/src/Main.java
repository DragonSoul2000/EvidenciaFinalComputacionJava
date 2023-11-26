import Entidades.Entidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Entidades> lista = new ArrayList<Entidades>();
        Entidades E = new Entidades();
        Date date= new Date();
        E.setFechaConsulta(date);
        lista.add(E);
        try {

            //Escribir Paciente
            FileOutputStream escribir=
                    new FileOutputStream(" C:\\Users\\David\\OneDrive\\Documents\\Lista\\Paciente.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();
            //LEER lista desde archivo de doctores
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\David\\OneDrive\\Documents\\Lista\\Doctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Entidades> otraLista = (ArrayList<Entidades>)o;
            Entidades pruebaDoctor = otraLista.get(0);
            System.out.println(pruebaDoctor.getNombreDoctor());
            miStream2.close();

        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado.");
        }catch(IOException e){
            System.out.println("Error de E/S");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println("Error al leer lista de clase Alumnos");
        }


    }
}