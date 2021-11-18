package com.tecsus.ddc.instalation;

import com.tecsus.ddc.connection.Connector;
import org.junit.Test;

public class InstalationTest {

    private InstalationRepository instalationRepository;
    private InstalationController instalationController;

    public InstalationTest() {
        Connector connector = new Connector();
        instalationRepository = new InstalationRepository(connector.getConnection());
        instalationController = new InstalationController(connector.getConnection());
    }

    @Test
    public void findTest() {
        final Instalation instalation = Instalation.builder().instalationNumber("2599675-4").build();

        final Instalation response = instalationRepository.find(instalation).orElse(instalation);
        System.out.println(response.toJson());
    }

    @Test
    public void controllerFindTest() {
        final Instalation instalation = instalationController.find("2599675-4");
        System.out.println(instalation.toJson());
    }
}
