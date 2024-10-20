package com.curso.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_editora")
    private Integer id;

    @NotNull @NotBlank
    private String cnpj;

    @NotNull @NotBlank
    private String razaoSocial;

    @ManyToOne
    @JoinColumn(name = "idlivro")
    private Livro livro;

    public Editora() {
    }

    public Editora(Integer id, String razaoSocial, String cnpj) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return Objects.equals(id, editora.id) && Objects.equals(cnpj, editora.cnpj) && Objects.equals(razaoSocial, editora.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, razaoSocial);
    }
}
