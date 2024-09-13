package com.api.crud.crud.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.crud.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona,Integer> {
    
}
