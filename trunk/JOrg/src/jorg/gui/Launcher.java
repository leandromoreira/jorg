package jorg.gui;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.config.Configurator;
import jorgcore.database.DataBase;

public class Launcher {

    public static void main(String[] args) {
        SwingUtil.initLookAndFeel(Configurator.getSetupProprerty("lookandfeel"));
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                creatingDataBase();
                preloadingDataBase();
                Main main = new Main();
                main.internationalize();
                SwingUtil.center(main);
                main.setVisible(true);
            }

            private final void preloadingDataBase() {
                DataBase.getConnection();
            }

            private void creatingDataBase() {
                try {
                    File file = new File(DataBase.BD_PATH);
                    if (!file.exists()) {
                        DataBase.createDataBase();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
