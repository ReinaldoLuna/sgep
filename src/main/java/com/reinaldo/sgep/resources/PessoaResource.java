package com.reinaldo.sgep.resources;

import com.reinaldo.sgep.domain.Pessoa;
import com.reinaldo.sgep.dto.PessoaDTO;
import com.reinaldo.sgep.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@PathVariable Integer id) {
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDTO objDto) {
        Pessoa obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody PessoaDTO objDto, @PathVariable Integer id){
        Pessoa obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<Pessoa> list = service.findAll();
        List<PessoaDTO> listDto = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<PessoaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") String page,
                                                    @RequestParam(value = "linesPerPage", defaultValue = "4") Integer linesPerPage,
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
        Integer pageInteger = Integer.valueOf(page);

        Page<Pessoa> list = service.findPage(pageInteger,linesPerPage, orderBy, direction);
        Page<PessoaDTO> listDto = list.map(obj -> new PessoaDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}
