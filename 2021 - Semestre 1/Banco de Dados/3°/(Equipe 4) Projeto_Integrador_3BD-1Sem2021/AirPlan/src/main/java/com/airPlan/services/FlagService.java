package com.airPlan.services;

import com.airPlan.entities.Flag;
import com.airPlan.entities.ManualFlag;
import com.airPlan.entities.ManualFlagId;
import com.airPlan.repository.FlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FlagService {

    @Autowired
    private FlagRepository repo;

    @Autowired
    private ManualFlagService manualFlagService;

    public void save(Flag flag, Integer mnl_id) {

        String[] flagParts = flag.getFlg_secundary_id().split(",");
        String[] tagParts = flag.getFlg_tag().split(",");

        for (int i = 0; i < flagParts.length; i++) {
            Flag newFlag = new Flag(flagParts[i], tagParts[i]);


            repo.save(newFlag);

            ManualFlag manualFlag = new ManualFlag(new ManualFlagId(mnl_id, newFlag.getFlg_secundary_id()));
            manualFlagService.save(manualFlag);
        }

    }
}
