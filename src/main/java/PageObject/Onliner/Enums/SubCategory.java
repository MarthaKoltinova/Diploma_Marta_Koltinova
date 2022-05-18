package PageObject.Onliner.Enums;

public enum SubCategory {
    VIDEO_GAMES("//*[@class='catalog-navigation-list__aside-item']//*[text()=' Видеоигры ']");
    String subCategory;

    SubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
