package com.reinaldo.sgep.resources;

import com.reinaldo.sgep.domain.ExperienciaProfissional;
import com.reinaldo.sgep.dto.ExperienciaProfissionalDTO;
import com.reinaldo.sgep.services.ExperienciaProfissionalService;
import com.reinaldo.sgep.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/experiancias_profissionais")
@CrossOrigin(origins = "*")
public class ExperienciaProfissionalResource {

    @Autowired
    private ExperienciaProfissionalService service;

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ExperienciaProfissional> find(@PathVariable Integer id) {
        ExperienciaProfissional obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ExperienciaProfissionalDTO objDto) {
        ExperienciaProfissional obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody ExperienciaProfissionalDTO objDto, @PathVariable Integer id){
        ExperienciaProfissional obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();  
    }

}
