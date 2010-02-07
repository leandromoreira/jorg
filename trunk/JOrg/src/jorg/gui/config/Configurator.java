package jorg.gui.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Configurator {
    private final static String VERSION = "0.85B";
    private final static String MAIN_TITLE = "JOrg";
    private final static String DEV_BLOG = "http://archsofty.blogspot.com";
    private final static String SETUP_PATH = "config/", LANG_PATH = "config/";
    private final static File setupFile = new File(SETUP_PATH + "setup.properties");
    private static Properties setup = new Properties(), internationalizator = new Properties();
    private static File iFile;
    private static String[] stopWords;

    static {
        try {
            FileInputStream in = new FileInputStream(setupFile);
            try {
                setup.load(in);
                iFile = new File(LANG_PATH + setup.getProperty("language.file"));
                filesToDontIndex = setup.get("files.not.indexable").toString().split(",");
                stopWords = setup.get("stop.words").toString().split(",");
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
            out.close();
        } catch (Exception ex) {
            throw new ConfiguratorException(getInternationlizedText("configuration.save.error") + ex, ex);
        }
    }

    public final static String getSetupProprerty(final String key) {
        return setup.getProperty(key);
    }

    public final static String getInternationlizedText(final String key) {
        if ("main.version".equals(key)){
            return VERSION;
        }
        if ("main.title".equals(key)){
            return MAIN_TITLE;
        }
        if ("main.developer.blog".equals(key)){
            return DEV_BLOG;
        }
        return internationalizator.getProperty(key);
    }
    private static final String iconPath = "icons/";

    public final static String getPathFor(String ext) {
        if (ext == null) {
            return iconPath + "exe_sem_nada.png";
        } else {
            if (isInside(getPersonalTypes(), ext)) {
                return iconPath + "exe_sem_nada.png";
            }

            if (isInside(getCompressionTypes(), ext)) {
                return iconPath + "rar_zip_tar.png";
            }

            if (isInside(getImageTypes(), ext)) {
                return iconPath + "iso_nrg_mdf_.png";
            }

            if (isInside(getPersonalTypes(), ext)) {
                return iconPath + "picture.png";
            }

            if (isInside(getDocTypes(), ext)) {
                return iconPath + "doc_ex_.png";
            }

            if (isInside(getHtmlTypes(), ext)) {
                return iconPath + "html_.png";
            }

            if (isInside(getVideoTypes(), ext)) {
                return iconPath + "avi_mkv_video_.png";
            }

            if (isInside(getAudioTypes(), ext)) {
                return iconPath + "mp3_wma_au.png";
            }
        }
        return iconPath + "exe_sem_nada.png";
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
    private static String[] filesToDontIndex;

    public final static boolean isIndexable(final String filename) {
        for (String file : filesToDontIndex) {
            file = file.trim();
            if (!file.contains("*")) {
                if (filename.toLowerCase().equals(file.toLowerCase().trim())) {
                    return false;
                }
            } else {
                if (file.endsWith("*")) {
                    if (filename.toLowerCase().startsWith(file.substring(0, file.length() - 1).toLowerCase().trim())) {
                        return false;
                    }
                }else{
                    if (filename.toLowerCase().endsWith(file.substring(1, file.length()).toLowerCase().trim())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final static String[] getStopWords() {
        String[] value = new String[stopWords.length];
        int index = 0;
        for (String word : stopWords) {
            value[index++] = word.trim();
        }
        return value;
    }

    private final static boolean isInside(final String[] types, String ext) {
        ext = ext.trim().toLowerCase();
        for (String type : types) {
            if (type.trim().toLowerCase().equals(ext)) {
                return true;
            }
        }
        return false;
    }
}
