package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kah
 */
public class CidadeRepository extends Conexao{
    public List<CidadeModel> buscarTodos(){
        List<CidadeModel> listaDeCidades = new ArrayList<>();
        super.inicializa();
        listaDeCidades = super.getSess().createQuery("from CidadeModel").list();
        super.executar();
        return listaDeCidades;
    }
    
    public CidadeModel buscarPorID(int IdCidade){
        CidadeModel cidade = new CidadeModel();
        super.inicializa();
        cidade = (CidadeModel) super.getSess().get(CidadeModel.class, IdCidade);
        super.executar();
        return cidade;
    }
}
