package com.tads.ecommerce.service;

import com.tads.ecommerce.dto.CategoryDTO;
import com.tads.ecommerce.entity.Category;
import com.tads.ecommerce.repository.CategoryRepository;
import com.tads.ecommerce.service.exception.ResourceNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();

        // com expressão lambda - (map reduce filter)
        List<CategoryDTO> listDTO = list.stream() .map(x -> new CategoryDTO(x)) .collect(Collectors.toList());
        return listDTO;
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not Found!"));

        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());

        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);

        }catch (EntityActionVetoException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }


    }

}
