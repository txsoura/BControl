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
public class Funcionario {
    private int contacto;
    private String nome, endereco;
    
    public Funcionario(int contacto, String nome, String endereco) {
        this.contacto = contacto;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public Funcionario(){
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
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

    @Override
    public String toString() {
        return "Funcionario{" + "contacto=" + contacto + ", nome=" + nome + ", endereco=" + endereco + '}';
    }

       
}
