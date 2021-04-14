package com.mrsu.crud.service;

import com.mrsu.crud.model.ExampleModel;
import org.springframework.stereotype.Service;

@Service
public interface ExampleCrudService {

    ExampleModel findById(Long id);

    ExampleModel save(ExampleModel exampleModel);

    Long deleteById(Long id);

    ExampleModel update(ExampleModel exampleModel, long id);
}
