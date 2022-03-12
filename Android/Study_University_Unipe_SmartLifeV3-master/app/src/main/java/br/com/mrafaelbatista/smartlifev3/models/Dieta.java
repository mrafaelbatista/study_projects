package br.com.mrafaelbatista.smartlifev3.models;

import com.orm.SugarRecord;

/**
 * Created by mrafa on 27/10/2015.
 */
public class Dieta extends SugarRecord<Dieta>{

    private String nome;
    private String cafe_da_manha;
    private String almoco;
    private String jantar;

    public Dieta() {
    }

    public Dieta(String nome, String cafe_da_manha, String almoco, String jantar) {
        this.nome = nome;
        this.cafe_da_manha = cafe_da_manha;
        this.almoco = almoco;
        this.jantar = jantar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCafe_da_manha() {
        return cafe_da_manha;
    }

    public void setCafe_da_manha(String cafe_da_manha) {
        this.cafe_da_manha = cafe_da_manha;
    }

    public String getAlmoco() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco = almoco;
    }

    public String getJantar() {
        return jantar;
    }

    public void setJantar(String jantar) {
        this.jantar = jantar;
    }
}
