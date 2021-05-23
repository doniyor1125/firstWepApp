package com.example.demo.Service;

import com.example.demo.Entity.entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.repository;

import java.util.List;

@Service
public class service {

    @Autowired
    private repository repository;

    public List<entity> getAll(){
        return repository.findAll(Sort.by(Sort.Order.asc("brithday"),Sort.Order.desc("name")));
    }

    public entity save(entity entity){
        return repository.save(entity);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}