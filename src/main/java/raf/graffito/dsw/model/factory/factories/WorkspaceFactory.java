package raf.graffito.dsw.model.factory.factories;

import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.factory.GraffNodeFactory;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.gui.swing.tree.view.PresentationOrSlidePopUp;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.util.Random;

public class WorkspaceFactory implements GraffNodeFactory {
    @Override
    public GraffNode createNode(GraffNode parent) {
        PresentationOrSlidePopUp dialog = new PresentationOrSlidePopUp(MainFrame.getInstance());
        dialog.setVisible(true);
        Project project = new Project("Project" + new Random().nextInt(100), parent);
        GraffNode child = null;

        if (dialog.isPresentation()) {
            child = new Presentation("Presentation" + new Random().nextInt(100), project);
            project.addChild(child);
        } else if (dialog.isSlide()) {
            child = new Slide("Slide" + new Random().nextInt(100), project);
            project.addChild(child);
        }
      //  project.addChild(child);

        if (child == null) return null;

        return project;
    }
}
