package sample;

public class PassColorSub {
    private int id;
    private String colorSub;

    public PassColorSub(int id) {
        this.id = id;
        this.colorSub = "gray";
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
