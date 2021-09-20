package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Log;

public interface LogRepository extends CrudRepository<Log, String>{}