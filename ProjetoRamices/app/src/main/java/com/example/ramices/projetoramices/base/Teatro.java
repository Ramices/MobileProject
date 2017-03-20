package com.example.ramices.projetoramices.base;
import java.io.Serializable;

/**
 * Created by Ramices on 27/10/2016.
 */

public class Teatro  implements Serializable
{
    private String nome;
    private String descricao;
    private String bairro;
    private String logradouro;
    private String telefone;
    private double  latitude;
    private double  longitude;

    public Teatro()
    {
        nome = null;
        descricao = null;
        bairro = null;
        logradouro = null;
        telefone = null;
        latitude = 0;
        longitude= 0;
    }


    public Teatro(String nome, String descricao, String bairro, String logradouro, String telefone, double latitude, double longitude)
    {

        this.nome = nome;
        this.descricao = descricao;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longitude = longitude;

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
        return this.nome + "\n" + this.descricao + "\n" + this.bairro + "\n"+ this.logradouro + "\n" + this.telefone;
    }


    @Override
    public boolean equals(Object teatro)
    {

        if(teatro.getClass() == Teatro.class)
        {

            if(((Teatro)teatro).getNome().equals(nome) && ((Teatro)teatro).getDescricao().equals(descricao))
            {
                return true;
            }


        }
        return false;
    }


}
