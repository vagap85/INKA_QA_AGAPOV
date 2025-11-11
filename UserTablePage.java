package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class UserTablePage extends BasePage {
    
    // Основные элементы
    @FindBy(xpath = "//button[contains(text(),'Добавить пользователя')]")
    private WebElement addUserButton;
    
    @FindBy(css = ".user-table table")
    private WebElement userTable;
    
    @FindBy(css = ".user-table tbody tr")
    private List<WebElement> userRows;
    
    @FindBy(css = "input[placeholder*='Логин']")
    private WebElement loginFilter;
    
    @FindBy(xpath = "//th[contains(text(),'Логин')]")
    private WebElement loginHeader;
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить изменения')]")
    private WebElement saveChangesButton;
    
    // Уведомления
    @FindBy(css = ".notification.success")
    private WebElement successNotification;
    
    public UserTablePage(WebDriver driver) {
        super(driver);
    }
    
    public AddUserModal clickAddUser() {
        addUserButton.click();
        return new AddUserModal(driver);
    }
    
    public void filterByLogin(String login) {
        loginFilter.clear();
        loginFilter.sendKeys(login);
    }
    
    public void sortByLogin() {
        loginHeader.click();
    }
    
    public EditUserModal doubleClickUserRow(int rowIndex) {
        Actions actions = new Actions(driver);
        WebElement row = userRows.get(rowIndex);
        actions.doubleClick(row).perform();
        return new EditUserModal(driver);
    }
    
    public SaveChangesModal clickSaveChanges() {
        saveChangesButton.click();
        return new SaveChangesModal(driver);
    }
    
    public boolean isUserInTable(String login) {
        return userRows.stream()
                .anyMatch(row -> row.getText().contains(login));
    }
    
    public int getUserCount() {
        return userRows.size();
    }
    
    public String getSuccessNotificationText() {
        return successNotification.getText();
    }
}
