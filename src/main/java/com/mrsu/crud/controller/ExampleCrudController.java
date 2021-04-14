package com.mrsu.crud.controller;

import com.mrsu.crud.model.ExampleModel;
import com.mrsu.crud.service.ExampleCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/example-crud")
public class ExampleCrudController {

    private final ExampleCrudService exampleCrudService;

    public ExampleCrudController(ExampleCrudService exampleCrudService){
        this.exampleCrudService = exampleCrudService;
    }

    @PostMapping
    public ResponseEntity<ExampleModel> post (@RequestBody ExampleModel exampleModel){
        return new ResponseEntity<>(exampleCrudService.save(exampleModel), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ExampleModel get (@PathVariable("id") Long id){
        return exampleCrudService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long deleteGrasslandById(@PathVariable("id") long id){
        return exampleCrudService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ExampleModel updateGrassland(@RequestBody ExampleModel exampleModel,
                                             @PathVariable("id") Long id){
        return exampleCrudService.update(exampleModel, id);
    }
}
