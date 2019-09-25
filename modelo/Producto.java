/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author Victor
 */
public class Producto {

    private int quantidade;
    private String codigo, nome;
    private double preco;
    private byte desconto;
    private DecimalFormat mt = new DecimalFormat("#,###,##0.00 Mt");

    public Producto(String codigo, int quantidade, String nome, double preco, byte desconto) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public Producto() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public byte getDesconto() {
        return desconto;
    }

    public void setDesconto(byte desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return String.format("%-3s%-10s%-2s%-3s%-2s%12s", "   ", codigo, "  ", quantidade, "  ", mt.format(preco));

    }

}
