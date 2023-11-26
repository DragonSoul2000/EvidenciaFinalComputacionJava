package Entidades;

import java.util.Date;

public class Entidades {
    String idPaciente;
    String nombrePaciente;
    String nivelUrgenciaPaciente;
    String CasoPaciente;

    String niveluPaciente;

    String idDoctor;
    String NombreDoctor;
    String especialidadDoctor;
    String nivelUrgenciaDoctor;

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNivelUrgenciaPaciente() {
        return nivelUrgenciaPaciente;
    }

    public void setNivelUrgenciaPaciente(String nivelUrgenciaPaciente) {
        this.nivelUrgenciaPaciente = nivelUrgenciaPaciente;
    }

    public String getCasoPaciente() {
        return CasoPaciente;
    }

    public void setCasoPaciente(String casoPaciente) {
        CasoPaciente = casoPaciente;
    }

    public String getNiveluPaciente() {
        return niveluPaciente;
    }

    public void setNiveluPaciente(String niveluPaciente) {
        this.niveluPaciente = niveluPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreDoctor() {
        return NombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        NombreDoctor = nombreDoctor;
    }

    public String getEspecialidadDoctor() {
        return especialidadDoctor;
    }

    public void setEspecialidadDoctor(String especialidadDoctor) {
        this.especialidadDoctor = especialidadDoctor;
    }

    public String getNivelUrgenciaDoctor() {
        return nivelUrgenciaDoctor;
    }

    public void setNivelUrgenciaDoctor(String nivelUrgenciaDoctor) {
        this.nivelUrgenciaDoctor = nivelUrgenciaDoctor;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return NombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        NombreAdmin = nombreAdmin;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    String idAdmin;
    String NombreAdmin;

    Date fechaConsulta;


}
