package com.matricula.curso.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matricula.curso.entities.Curso;
import com.matricula.curso.services.ICursoService;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
	
	@Autowired
	private ICursoService service;
		
	@GetMapping(value = "/findAll")
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos=service.findAll();
        return ResponseEntity.ok(cursos);
    }
	
	@GetMapping(value = "/findById/{id}")
    public ResponseEntity<Curso> findById(@PathVariable int id){
		Curso curso=service.findById(id);
        return ResponseEntity.ok(curso);
    }
	
	@PostMapping(value = "/register")
    public ResponseEntity<Curso> register(@Valid @RequestBody Curso curso, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Curso cursoCreate =  service.register(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreate);
    }
	
	@PutMapping(value = "/update")
    public ResponseEntity<Curso> update(@RequestBody Curso curso){		
		Curso productDB =  service.update(curso);
        if (productDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDB);
    }
	
	
	/**
	 * Formatea mensaje de error
	 * @param result
	 * @return
	 */
	private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
