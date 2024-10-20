package com.curso.services;


import com.curso.domains.Editora;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.repositories.EditoraRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {
    @Autowired
    private EditoraRepository editoraRepo;

    public List<EditoraDTO> findAll(){

        return editoraRepo.findAll().stream()
                .map(obj -> new EditoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Editora findById(int id){
        Optional<Editora> obj = editoraRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("editora não encontrada! Id:" + id));
    }

    public Editora findByCnpj(String cnpj) {
        Optional<Editora> obj = editoraRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("editora não encontrada! cnpj:" + cnpj));
    }
}