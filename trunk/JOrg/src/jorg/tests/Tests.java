package jorg.tests;

import jorg.gui.config.Configurator;

public class Tests {
    public static void main(String[] args) {
        System.out.println(Configurator.getSetupProprerty("language.file"));
        System.out.println(Configurator.getInternationlizedText("main.version"));
    }
}
