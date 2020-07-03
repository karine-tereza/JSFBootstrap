/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kah
 */
public class DisciplinaRepository extends Conexao{
    
    public void salvar(DisciplinaModel disciplinaModel){
        super.inicializa();
        super.getSess().saveOrUpdate(disciplinaModel);
        super.executar();
    }
    public List<DisciplinaModel> buscarTodos(){
        List<DisciplinaModel> listaDeDisciplinas = new ArrayList<>();
        super.inicializa();
        listaDeDisciplinas = super.getSess().createQuery("from DisciplinaModel").list();
        super.executar();
        return listaDeDisciplinas;
    }
    
    public DisciplinaModel buscarPorID(int id){
        DisciplinaModel disciplina = new DisciplinaModel();
        super.inicializa();
        disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, id);
        super.executar();
        return disciplina;
    }
    public void excluirPorID(int id){
        super.inicializa();
        DisciplinaModel disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, id);
        super.getSess().delete(disciplina);
        super.executar();
    }
    
    public List<DisciplinaModel> buscarPorNome(String nome){
        List<DisciplinaModel> lista = new ArrayList<>();
        super.inicializa();
        lista = super.getSess().createQuery("from DisciplinaModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return lista;
    }
    
    public AlunoModel buscarAluno(long idpessoa){
        AlunoModel aluno = new AlunoModel();
        super.inicializa();
        aluno = (AlunoModel) super.getSess().get(AlunoModel.class, idpessoa);
        super.executar();
        return aluno;
    }
}

