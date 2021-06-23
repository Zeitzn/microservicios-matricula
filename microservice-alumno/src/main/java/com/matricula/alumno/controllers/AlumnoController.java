package com.matricula.alumno.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
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
import com.matricula.alumno.config.DefaultRibbonConfig;
import com.matricula.alumno.entities.Alumno;
import com.matricula.alumno.services.IAlumnoService;

@RestController
@RequestMapping(value = "/alumno")
//@RibbonClients (defaultConfiguration = DefaultRibbonConfig.class)
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;
		
	@GetMapping(value = "/findAll")
    public ResponseEntity<List<Alumno>> findAll(){
        List<Alumno> users=service.findAll();
        return ResponseEntity.ok(users);
    }
	
	@GetMapping(value = "/findById/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable int id){
		Alumno curso=service.findById(id);
        return ResponseEntity.ok(curso);
    }
	
	@PostMapping(value = "/register")
    public ResponseEntity<Alumno> register(@Valid @RequestBody Alumno curso, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Alumno userCreate =  service.register(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
    }
	
	@PutMapping(value = "/update")
    public ResponseEntity<Alumno> update(@RequestBody Alumno curso){		
		Alumno productDB =  service.update(curso);
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
