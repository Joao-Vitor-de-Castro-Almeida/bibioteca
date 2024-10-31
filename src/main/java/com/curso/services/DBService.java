package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.Livro;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.EditoraRepository;
import com.curso.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private EditoraRepository editoraRepo;

    @Autowired
    private LivroRepository livroRepo;

    public void initDB() {

            Autor autor01 = new Autor(null, "Jonas da Silva", "23.453.535-20");
            Autor autor02 = new Autor(null, "Lucios Mandela", "84.586.965-10");
            Autor autor03 = new Autor(null, "Mateus Olivera", "54.179.854-15");

           autorRepo.save(autor01);
           autorRepo.save(autor02);
           autorRepo.save(autor03);

            Editora editora01 = new Editora(null, "Porto Malacau", "12.345.678-0001-00");
            Editora editora02 = new Editora(null, "Instituto Marcelo Dias", "71.382.968-8456-45");

           editoraRepo.save(editora01);
           editoraRepo.save(editora02);

            Livro livro01 = new Livro(null, "Contos de um Larapio", "54.341.884-9545-88", 45,
                    LocalDate.now(), new BigDecimal("48"), autor01, editora01, Status.LENDO, Conservacao.BOM);
            Livro livro02 = new Livro(null, "Leis do Universo", "12.345.678-0001-00", 185,
                    LocalDate.now(), new BigDecimal("150"), autor03, editora02, Status.LENDO, Conservacao.BOM);
            Livro livro03 = new Livro(null, "Lendas do Norte", "18.468.695-4885-78", 95,
                    LocalDate.now(), new BigDecimal("95"), autor02, editora01, Status.LENDO, Conservacao.BOM);

            livroRepo.save(livro01);
            livroRepo.save(livro02);
            livroRepo.save(livro03);

    }
}
