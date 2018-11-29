package sample;

public class PassColorSub {
    private int id;
    private String colorSub;
    private boolean study;

    public PassColorSub(int id) {
        this.id = id;
        this.colorSub = "gray";
        this.study = false;
    }

    public void setStudy(boolean study) {
        this.study = study;
    }

    public int getId() {
        return id;
    }

    public String getColorSub() {
        return colorSub;
    }

    public void setColorSub(String colorSub) {
        this.colorSub = colorSub;
    }
}
