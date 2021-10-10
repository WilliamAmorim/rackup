package br.com.rackup.DAO;

import br.com.rackup.model.ProfessorModel;
import br.com.rackup.sql.Sql;


public class ProfessorDAO extends Sql {

    private final String queryCadastroProfessor =   "INSERT INTO `professor`(`nome_professor`,`senha`,`id_disciplina`, `status`) VALUES (?,?,?,?)";
    private final String queryUpdateProfessor = "UPDATE `professor` SET `nome_professor`='?',`senha`='?',`id_disciplina`='?',`status`='?' WHERE `id_professor`= ?";

    public boolean cadastrarProfessor(ProfessorModel professorModel){

       return executeQuery(queryCadastroProfessor,professorModel.getValues());

    }

    public boolean updateProfessor(ProfessorModel professorModel){

        return executeQuery(queryUpdateProfessor,professorModel.getValues());

    }
}
