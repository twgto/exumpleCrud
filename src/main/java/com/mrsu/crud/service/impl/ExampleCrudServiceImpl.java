package com.mrsu.crud.service.impl;

import com.mrsu.crud.model.ExampleModel;
import com.mrsu.crud.repository.ExampleRepository;
import com.mrsu.crud.service.ExampleCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ExampleCrudServiceImpl implements ExampleCrudService {

    private final ExampleRepository exampleRepository;

    public ExampleCrudServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public ExampleModel findById(Long id) {
        return exampleRepository.findById(id).get();
    }

    @Override
    public ExampleModel save(ExampleModel exampleModel) {
        String string = exampleModel.getColumn();
        exampleModel.setColumn(string+string);
        return exampleRepository.save(exampleModel);
    }

    @Override
    public Long deleteById(Long id) {
        exampleRepository.deleteById(id);
        return id;
    }

    @Override
    public ExampleModel update(ExampleModel exampleModel, long id) {
        Optional<ExampleModel> exampleModelById = exampleRepository.findById(id);
        exampleModelById.get().setColumn(exampleModel.getColumn());
        return exampleRepository.save(exampleModelById.get());
    }
}
