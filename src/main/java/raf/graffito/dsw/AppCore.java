package raf.graffito.dsw;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.GraffRepository;

import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;


public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
       GraffRepository gr = new GraffRepositoryImplementation();
        appCore.initialize(gr);
    }
}