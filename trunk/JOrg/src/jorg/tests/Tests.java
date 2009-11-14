package jorg.tests;

import java.util.Arrays;
import java.util.Set;
import jorg.gui.config.Configurator;
import jorgcore.entity.FileManager;

public class Tests {
    public static void main(String[] args) {
            System.out.println(Arrays.toString(Configurator.getAudioTypes()));
            System.out.println(Arrays.toString(Configurator.getCompressionTypes()));
            System.out.println(Arrays.toString(Configurator.getDocTypes()));
            System.out.println(Arrays.toString(Configurator.getHtmlTypes()));
            System.out.println(Arrays.toString(Configurator.getImageTypes()));
            System.out.println(Arrays.toString(Configurator.getPersonalTypes()));
            System.out.println(Arrays.toString(Configurator.getPictureTypes()));
            System.out.println(Arrays.toString(Configurator.getVideoTypes()));
    }
}
