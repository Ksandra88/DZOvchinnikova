package ColorData;

public enum ColorData {
    BLACK("чёрный");

    private String name;
    ColorData(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
