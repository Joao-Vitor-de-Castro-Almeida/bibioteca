package com.curso.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
    private Integer id;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String documentoPessoal;

    @ManyToOne
    @JoinColumn(name = "idlivro")
    private Livro livro;

    public Autor() {
    }

    public Autor(Integer id, String nome, String documentoPessoal) {
        this.id = id;
        this.nome = nome;
        this.documentoPessoal = documentoPessoal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
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
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(documentoPessoal, autor.documentoPessoal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, documentoPessoal);
    }
}
