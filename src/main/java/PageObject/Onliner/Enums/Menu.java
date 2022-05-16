package PageObject.Onliner.Enums;

public enum Menu {
    CATALOG("Каталог"),
    SERVICES("Услуги"),
    FORUM("Форум");
    String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
