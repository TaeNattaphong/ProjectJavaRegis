package sample;

public class PassColorSub {
    private int id;
    private String colorSub;
    private String study;

    public PassColorSub(int id) {
        this.id = id;
        this.colorSub = "gray";
        if(id == 0){
            this.study = "true";
        }else{
            this.study = "false";
        }
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

    @Override
    public String toString() {
        return "PassColorSub{" +
                "id=" + id +
                ", colorSub='" + colorSub + '\'' +
                ", study='" + study + '\'' +
                '}';
    }
}
