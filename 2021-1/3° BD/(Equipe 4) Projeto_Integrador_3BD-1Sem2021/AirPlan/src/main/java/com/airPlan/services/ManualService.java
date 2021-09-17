package com.airPlan.services;


import com.airPlan.entities.Manual;
import com.airPlan.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ManualService {

    @Autowired
    private ManualRepository repo;

    public List<Manual> listAll() {
        return repo.findAll();
    }

    public void save(Manual manual) {

        if(repo.checkCount(manual.getMnl_name()) == 0) {
            repo.save(manual);
        }
    }

    public Manual get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Integer findManualByName(String nomeManual){
        return repo.findManualByName(nomeManual);
    };
}
