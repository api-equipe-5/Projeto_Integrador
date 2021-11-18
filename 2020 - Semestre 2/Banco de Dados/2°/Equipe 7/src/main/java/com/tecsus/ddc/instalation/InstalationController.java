package com.tecsus.ddc.instalation;

import java.sql.Connection;

public class InstalationController {

    private InstalationRepository instalationRepository;

    public InstalationController(Connection connection) {
        instalationRepository = new InstalationRepository(connection);
    }

    public Instalation find(String instalationNumber) {
        final Instalation instalation = Instalation.builder().instalationNumber(instalationNumber).build();
        return instalationRepository.find(instalation).orElse(instalation);
    }
}
