/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Victor
 */
public class Sobre {

    private String nome, endereco;
    private int contacto, nuit;

    public Sobre(String nome, String endereco, int contacto, int nuit) {
        this.nome = nome;
        this.endereco = endereco;
        this.contacto = contacto;
        this.nuit = nuit;
    }

    public Sobre() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    @Override
    public String toString() {
        return "Sobre{" + "nome=" + nome + ", endereco=" + endereco + ", contacto=" + contacto + ", nuit=" + nuit + '}';
    }

}
