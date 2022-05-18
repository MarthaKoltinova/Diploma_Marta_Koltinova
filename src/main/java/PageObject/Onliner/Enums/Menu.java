package PageObject.Onliner.Enums;

public enum Menu {
    CATALOG("Каталог");
    String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
