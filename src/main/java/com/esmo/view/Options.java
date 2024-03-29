package com.esmo.view;

import com.esmo.model.Particle.ParticleType;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Options extends ScrollPane {

    private Slider windDirection;
    private Slider windStrength;
    private ColorPicker sandColor;
    private Button reset;
    private CheckBox auto;
    private ComboBox<ParticleType> particleType;
    private CheckBox onTop;
    private Button clear;
    private Button physicsToggle;

    public Options() {
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        windDirection = new Slider(0, 1, .5);
        windDirection.setBlockIncrement(.10);
        windDirection.setShowTickMarks(true);
        windDirection.setMajorTickUnit(.50);

        windStrength = new Slider(0, 1, .1);
        windStrength.setBlockIncrement(.10);
        windStrength.setShowTickMarks(true);

        particleType = new ComboBox<>();
        particleType.getItems().addAll(ParticleType.values());
        particleType.getSelectionModel().selectFirst();

        windStrength.setMajorTickUnit(.50);

        sandColor = new ColorPicker(Color.CYAN);

        reset = new Button("Reset");
        clear = new Button("Clear");

        auto = new CheckBox("Auto");

        onTop = new CheckBox("Always On Top");

        physicsToggle = new Button("Pause");
        
        vBox.getChildren().addAll(new Label("Direction"), windDirection, new Label("Strength"), windStrength,
                new Label("Type"), particleType,
                new Label("Sand Color"), sandColor, auto, new HBox(reset, clear), new Separator(), onTop,new Separator(),physicsToggle);
        setContent(vBox);
    }

    public Button getPhysicsToggle() {
        return physicsToggle;
    }

    public Button getClear() {
        return clear;
    }

    public CheckBox getOnTop() {
        return onTop;
    }

    public Slider getWindDirection() {
        return windDirection;
    }

    public Slider getWindStrength() {
        return windStrength;
    }

    public Color getSandColor() {
        return sandColor.getValue();
    }

    public Button getReset() {
        return reset;
    }

    public CheckBox getAuto() {
        return auto;
    }

    public ParticleType getParticleType() {
        return particleType.getSelectionModel().getSelectedItem();
    }

    public void setParticleType(ParticleType type) {
        particleType.getSelectionModel().select(type);
    }
}
