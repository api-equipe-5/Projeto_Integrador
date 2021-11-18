package com.tecsus.ddc.app;

import com.tecsus.ddc.security.SecurityContext;
import javafx.stage.Stage;

public enum Screen {
    LOGIN {
        @Override
        public void set(Stage stage, Object userData) {
            stage.setScene(ApplicationMain.login);
            ApplicationMain.notifyAllListeners(Screen.LOGIN, "");
        }
    },
    DASHBOARD {
        @Override
        public void set(Stage stage, Object userData) {
            stage.setScene(ApplicationMain.dashboard);
            ApplicationMain.notifyAllListeners(Screen.DASHBOARD, "");
        }
    },
    ENERGY {
        @Override
        public void set(Stage stage, Object userData) {
            stage.setScene(ApplicationMain.energy);
            ApplicationMain.notifyAllListeners(Screen.ENERGY, SecurityContext.loggedUser);
        }
    },
    WATER {
        @Override
        public void set(Stage stage, Object userData) {
            stage.setScene(ApplicationMain.water);
            ApplicationMain.notifyAllListeners(Screen.WATER, SecurityContext.loggedUser);
        }
    },
    REPORT {
        @Override
        public void set(Stage stage, Object userData) {

        }
    };

    public abstract void set(Stage stage, Object userData);
}
