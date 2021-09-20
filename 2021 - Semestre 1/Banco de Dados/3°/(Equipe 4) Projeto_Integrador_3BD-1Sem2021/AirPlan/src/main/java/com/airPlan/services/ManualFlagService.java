package com.airPlan.services;

import com.airPlan.entities.ManualFlag;
import com.airPlan.repository.ManualFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManualFlagService {

    @Autowired
    private ManualFlagRepository repo;

    public void save(ManualFlag manualFlag) {repo.save(manualFlag);}
}
