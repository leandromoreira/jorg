package jorg.gui;

import java.sql.SQLException;
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
                fakingAConnection();
                Main main = new Main();
                main.internationalize();
                SwingUtil.center(main);
                main.setVisible(true);
            }

            private final void fakingAConnection() {
                try {
                    new DataBase();
                } catch (SQLException ex) {
                    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
