package br.com.mrafaelbatista.smartlifev3.Controllers;

import java.util.List;

import br.com.mrafaelbatista.smartlifev3.models.Atividade;

/**
 * Created by mrafa on 26/10/2015.
 */
public class ControllerCadastroTreino {

    private static ControllerCadastroTreino instance = null;

    private String nomeTreino;
    private String objTreino;
    private List<Atividade> listaAtividades;

    //Método para instanciar classe
    public static ControllerCadastroTreino getInstance() {
        if (instance == null) {
            instance = new ControllerCadastroTreino();
        }
        return instance;
    }

    public List<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(List<Atividade> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public String getObjTreino() {
        return objTreino;
    }

    public void setObjTreino(String objTreino) {
        this.objTreino = objTreino;
    }
}
