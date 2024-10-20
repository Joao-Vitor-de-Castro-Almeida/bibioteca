package com.curso.resources;

import com.curso.domains.Editora;
import com.curso.domains.Livro;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.domains.dtos.LivroDTO;
import com.curso.services.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/editora")
public class EditoraResource {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<EditoraDTO>> findAll(){
        return ResponseEntity.ok().body(editoraService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EditoraDTO> findById(@PathVariable int id){
        Editora obj = this.editoraService.findById(id);
        return  ResponseEntity.ok().body(new EditoraDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<EditoraDTO> findByCnpj(@PathVariable String cnpj){
        Editora obj = this.editoraService.findByCnpj(cnpj);
        return  ResponseEntity.ok().body(new EditoraDTO(obj));
    }

}