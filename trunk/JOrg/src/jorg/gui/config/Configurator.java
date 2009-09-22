package jorg.gui.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Configurator {
    //REMEMBER TO PUT SYSTEM.LINEDIVISOR TO PATHS...
    //config + Ssytem.filesperator ,,,,
    private final static String SETUP_PATH = "",LANG_PATH="";
    private final static File setupFile = new File(SETUP_PATH+"setup.properties");
    private static Properties setup = new Properties(), internationalizator = new Properties();
    private static File iFile;

    static {
        try {
            FileInputStream in = new FileInputStream(setupFile);
            try {
                setup.load(in);
                iFile = new File(LANG_PATH+setup.getProperty("language.file"));
                FileInputStream in1 = new FileInputStream(iFile);
                internationalizator.load(in1);
            } catch (IOException ex) {
                Logger.getLogger(Configurator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configurator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final static void saveSetup(final String key, final String value) throws ConfiguratorException {
        setup.put(key, value);
        try {
            FileOutputStream out = new FileOutputStream(setupFile);
            setup.store(out, "Setup general configurations.");
        } catch (Exception ex) {
            throw new ConfiguratorException(getInternationlizedText("configuration.save.error")+ex,ex);
        }
    }

    public final static String getSetupProprerty(final String key) {
        return setup.getProperty(key);
    }

    public final static String getInternationlizedText(final String key) {
        return internationalizator.getProperty(key);
    }
}
