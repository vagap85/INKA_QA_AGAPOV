package com.company.pages.components;

import com.company.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserModal extends BasePage {
    
    @FindBy(css = "input[placeholder*='Имя']")
    private WebElement firstNameInput;
    
    @FindBy(css = "input[placeholder*='Фамилия']")
    private WebElement lastNameInput;
    
    @FindBy(css = "input[placeholder*='Email']")
    private WebElement emailInput;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement addButton;
    
    @FindBy(css = ".error-message")
    private List<WebElement> errorMessages;
    
    public AddUserModal(WebDriver driver) {
        super(driver);
    }
    
    public void fillUserData(String firstName, String lastName, String email) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    
    public void clickAdd() {
        addButton.click();
    }
    
    public boolean isAddButtonEnabled() {
        return addButton.isEnabled();
    }
    
    public String getErrorMessageForField(String fieldName) {
        // Логика для получения сообщения об ошибке для конкретного поля
        return errorMessages.stream()
                .filter(msg -> msg.getAttribute("data-field").equals(fieldName))
                .findFirst()
                .map(WebElement::getText)
                .orElse("");
    }
}
