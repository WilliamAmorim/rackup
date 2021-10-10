package br.com.rackup.model;

import java.util.ArrayList;

public class ProfessorModel {
    private int idProfessor;
    private String nomeProfessor;
    private String senhaProfessor;
    private String disciplina;
    private boolean status;

    public ArrayList getValues() {

        ArrayList values = new ArrayList();
        values.add(getNomeProfessor());
        values.add(getSenhaProfessor());
        values.add(10);
        values.add(isStatus());
        if(getIdProfessor() > 0) values.add(getIdProfessor());

        return values;
    }

    public String getSenhaProfessor() {
        return senhaProfessor;
    }

    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
