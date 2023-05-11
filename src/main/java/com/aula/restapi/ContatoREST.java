package com.aula.restapi;

import java.util.List;

import com.aula.restapi.database.RepositorioContato;
import com.aula.restapi.entidade.Contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContatoREST {
    @Autowired
    private RepositorioContato repositorio;

    @GetMapping
    public List<Contato> getAll() {
        return repositorio.findAll();
    }

    @PostMapping
    public void save(@RequestBody Contato contato) {
        repositorio.save(contato);
    }

    @PutMapping
    public void update(@RequestBody Contato contato) {
        if (contato.getId() > 0)
            repositorio.save(contato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}
