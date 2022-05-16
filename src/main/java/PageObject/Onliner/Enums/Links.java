package PageObject.Onliner.Enums;

public enum Links {
    NEW("Новое за 24 часа");
    String links;

    Links(String links) {
        this.links = links;
    }

    public String getLinks() {
        return links;
    }
}
