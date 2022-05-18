package PageObject.Onliner.Enums;

public enum Group {
    GAMING_CONSOLES("//*[@class='catalog-navigation-list__dropdown-data']//*[text()=' Игровые приставки ']");
    String group;

    Group(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}

