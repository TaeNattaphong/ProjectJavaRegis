package sample;

public class PassColorSub {
    private int id;
    private String colorSub;
    private String study;

    public PassColorSub(int id) {
        this.id = id;
        this.colorSub = "gray";
        this.study = "false";
    }

    public String isStudy() {
        return study;
    }

    public void setStudy(String study) {
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
