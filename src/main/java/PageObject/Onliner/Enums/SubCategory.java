package PageObject.Onliner.Enums;

public enum SubCategory {
    MOBILE_PHONES("//*[@class='catalog-navigation-list__category'][@style='display: block;']//*[contains(@class, 'catalog-navigation-list__aside-item')]//*[@class='catalog-navigation-list__aside-title'][(contains(., 'Мобильные телефоны'))]"),
    VIDEO_GAMES("//*[@class='catalog-navigation-list__aside-item']//*[text()=' Видеоигры ']");
    String subCategory;

    SubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
