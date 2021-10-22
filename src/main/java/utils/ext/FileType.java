package utils.ext;

public enum FileType {

    SQL(".sql"),
    XML(".xml"),
    PROPERTIES(".properties");

    String type;

    FileType(String type) {
        this.type =type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
