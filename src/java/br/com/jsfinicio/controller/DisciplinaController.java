package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AlunoModel;
import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.repository.AlunoRepository;
import br.com.jsfinicio.repository.DisciplinaRepository;
import br.com.jsfinicio.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kah
 */
@ManagedBean
@SessionScoped
public class DisciplinaController {
    
    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private AlunoModel alunoModel;
    private AlunoRepository alunoRepository;
    private ProfessorModel professorModel;
    private ProfessorRepository professorRepository;
    private List<DisciplinaModel> listaDeDisciplinas;
    private List<AlunoModel>lista;

    public DisciplinaController() {
        this.disciplinaModel = new DisciplinaModel();
        this.disciplinaRepository = new DisciplinaRepository();
        this.professorModel = new ProfessorModel();
        this.professorRepository = new ProfessorRepository();
        this.alunoModel = new AlunoModel();
        this.alunoRepository = new AlunoRepository();
        this.listaDeDisciplinas = new ArrayList<>();
        this.lista = new ArrayList<>();
    }
    public void salvar() {
        try {
            this.professorModel = this.professorRepository.buscarPorID(this.professorModel.getIdpessoa());
            this.disciplinaModel.setProfessor(this.professorModel);
            this.disciplinaRepository.salvar(this.disciplinaModel);
            this.disciplinaModel = new DisciplinaModel();
            
        } catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
    }
   
    public String inscreverAluno(){
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(this.disciplinaModel.getIdDisciplina());
        this.lista = this.disciplinaModel.getListaDeAlunos();
        this.alunoModel = this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
        this.lista.add(this.alunoModel);
        this.disciplinaModel.setListaDeAlunos(this.lista);
        this.disciplinaRepository.salvar(this.disciplinaModel);
        this.disciplinaModel = new DisciplinaModel();
        return "buscarDisciplina.xhtml?faces-redirect=ture";
    }
    
    public String excluirAluno(){
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(this.disciplinaModel.getIdDisciplina());
        this.lista = this.disciplinaModel.getListaDeAlunos();
        this.alunoModel = this.alunoRepository.buscarPorID(this.alunoModel.getIdpessoa());
        this.lista.remove(this.alunoModel);
        this.disciplinaModel.setListaDeAlunos(this.lista);
        this.disciplinaRepository.salvar(this.disciplinaModel);
        this.disciplinaModel = new DisciplinaModel();
        return "listaAluno.xhtml?faces-redirect=ture";
        
    }
                
                
    public void buscarPorNome(){
        this.listaDeDisciplinas = this.disciplinaRepository.buscarPorNome(this.disciplinaModel.getNome());
    }
    public void excluirPorID(int id) {
        this.disciplinaRepository.excluirPorID(id);
    }
  
    public String editarPorID(int id) throws IOException {
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(id);

        return "editarDisciplina.xhtml?faces-redirect=true";
    }
   public String listarDisciplina(int id) throws IOException {
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(id);

        return "listaAluno.xhtml?faces-redirect=true";
    }
    
    public List<AlunoModel> getLista() {
        return lista;
    }

    public void setLista(List<AlunoModel> lista) {
        this.lista = lista;
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }
}

