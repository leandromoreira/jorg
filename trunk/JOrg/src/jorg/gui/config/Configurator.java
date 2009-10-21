package jorg.gui.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Configurator {
    //REMEMBER TO PUT SYSTEM.LINEDIVISOR TO PATHS...
    //config + Ssytem.filesperator ,,,,

    private final static String SETUP_PATH = "", LANG_PATH = "";
    private final static File setupFile = new File(SETUP_PATH + "setup.properties");
    private static Properties setup = new Properties(), internationalizator = new Properties();
    private static File iFile;

    static {
        try {
            FileInputStream in = new FileInputStream(setupFile);
            try {
                setup.load(in);
                iFile = new File(LANG_PATH + setup.getProperty("language.file"));
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
            throw new ConfiguratorException(getInternationlizedText("configuration.save.error") + ex, ex);
        }
    }

    public final static String getSetupProprerty(final String key) {
        return setup.getProperty(key);
    }

    public final static String getInternationlizedText(final String key) {
        return internationalizator.getProperty(key);
    }

    public final static String[] getPersonalTypes() {
        return getType("types.personal");
    }

    public final static String[] getCompressionTypes() {
        return getType("types.compression");
    }

    public final static String[] getImageTypes() {
        return getType("types.image");
    }

    public final static String[] getDocTypes() {
        return getType("types.docs");
    }

    public final static String[] getHtmlTypes() {
        return getType("types.html");
    }

    public final static String[] getPictureTypes() {
        return getType("types.picture");
    }

    public final static String[] getAudioTypes() {
        return getType("types.audio");
    }

    public final static String[] getVideoTypes() {
        return getType("types.video");
    }

    private final static String[] getType(String type) {
        String types = setup.getProperty(type);
        String[] arrayTypes = types.split(",");
        List<String> list = new ArrayList<String>();
        for (String element : arrayTypes) {
            if (!element.trim().equals("")) {
                list.add(element.toLowerCase().trim());
            }
        }
        return list.toArray(new String[0]);
    }
}
