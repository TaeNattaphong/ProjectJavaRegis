package sample;

import javafx.scene.paint.Color;

public class PassColorSub {
    private int id;
    private Color colorSub;

    public PassColorSub(int id) {
        this.id = id;
        this.colorSub = Color.DARKGREY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColorSub() {
        return colorSub;
    }

    public void setColorSub(Color colorSub) {
        this.colorSub = colorSub;
    }
}
