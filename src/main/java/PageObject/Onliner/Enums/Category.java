package PageObject.Onliner.Enums;

public enum Category {
    ELECTRONICS("//*[@class='catalog-navigation-classifier__item-title']//*[text()='Электроника']");
    String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
