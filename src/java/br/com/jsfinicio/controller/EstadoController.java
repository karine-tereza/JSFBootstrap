/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Kah
 */
@ManagedBean
@ViewScoped
public class EstadoController {
    
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private List<EstadoModel> listaDeEstados;
    private List<CidadeModel>listaDeCidades;
    
    public EstadoController(){
        this.estadoModel = new EstadoModel();
        this.estadoRepository = new EstadoRepository();
        this.listaDeEstados =  new ArrayList<>();
        this.listaDeCidades = new ArrayList<>();
    }
    
    public void buscarTodos(){
        this.listaDeEstados = this.estadoRepository.buscarTodos();
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void onChange(){
        this.listaDeCidades = new ArrayList<>();
        this.estadoModel = this.estadoRepository.buscarPorID(this.estadoModel.getIdEstado());
        this.listaDeCidades = this.estadoModel.getListaDeCidades();
    }
    
    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<EstadoModel> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(List<EstadoModel> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }

    public List<CidadeModel> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<CidadeModel> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }
    
}
