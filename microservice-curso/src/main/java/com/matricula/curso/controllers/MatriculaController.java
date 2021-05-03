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
import com.matricula.curso.entities.Matricula;
import com.matricula.curso.services.IMatriculaService;

@RestController
@RequestMapping(value = "/matricula")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService service;
		
	@GetMapping(value = "/findAll")
    public ResponseEntity<List<Matricula>> findAll(){
        List<Matricula> matriculas=service.findAll();
        return ResponseEntity.ok(matriculas);
    }
	
	@GetMapping(value = "/findById/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable int id){
		Matricula matricula=service.findById(id);
        return ResponseEntity.ok(matricula);
    }
	
	@PostMapping(value = "/register")
    public ResponseEntity<Matricula> register(@Valid @RequestBody Matricula matricula, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Matricula matriculaCreate =  service.register(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaCreate);
    }
	
	@PutMapping(value = "/update")
    public ResponseEntity<Matricula> update(@RequestBody Matricula matricula){		
		Matricula matriculaDB =  service.update(matricula);
        if (matriculaDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(matriculaDB);
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
