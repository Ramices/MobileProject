package com.example.ramices.projetoramices.base;


import java.io.Serializable;

/**
 * Created by Ramices on 27/10/2016.
 */

public class Museu  implements Serializable {

    private String nome;
    private String descricao;
    private String bairro;
    private String logradouro;
    private String telefone;
    private double  latitude;
    private double  longitude;
    private String site;

    public Museu()
    {
        nome = null;
        descricao = null;
        bairro = null;
        logradouro = null;
        telefone = null;
        latitude = 0;
        longitude= 0;
        site = null;
    }


    public Museu(String nome, String descricao, String bairro, String logradouro, String telefone, double latitude, double longitude, String site)
    {

        this.nome = nome;
        this.descricao = descricao;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.site = site;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getBairro() {
        return bairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString()
    {
        return this.nome + "\n" + this.descricao + "\n" + this.bairro + "\n"+ this.logradouro + "\n" + this.telefone + "\n" + site;
    }

    public void setSite(String site)
    {
        this.site = site;

    }

    public String getSite()
    {
        return this.site;

    }

    public boolean equals(Object museu)
    {

        if(museu.getClass() == Museu.class)
        {

            if(((Museu)museu).getNome().equals(nome) && ((Museu)museu).getDescricao().equals(descricao))
            {
                return true;
            }


        }
        return false;
    }






}
