package com.lits.project.repository;

import com.lits.project.models.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
}
