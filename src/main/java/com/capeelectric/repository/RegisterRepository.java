package com.capeelectric.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.RegisterDetails;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterDetails,Integer> {

  public Optional<RegisterDetails> findByEmpid(String empid);

}
