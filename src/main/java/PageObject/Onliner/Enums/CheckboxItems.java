package PageObject.Onliner.Enums;

public enum CheckboxItems {
    HONOR("//*[@class='schema-filter__label']//span[text() ='Производитель']//ancestor::div[@class ='schema-filter__fieldset']//li//label[@class='schema-filter__checkbox-item']//*[text()='HONOR']"),
    UNFULFILLED("//*[@class='service-form__label-flex']//div[text() ='Статус']//ancestor::div[@class ='service-form__group']//li//label[@class='service-form__checkbox-label']//*[text()='Невыполненные']");
    String checkboxItems;

    CheckboxItems(String checkboxItems) {
        this.checkboxItems = checkboxItems;
    }

    public String getCheckboxItems() {
        return checkboxItems;
    }
}


