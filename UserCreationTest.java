package com.company.tests.functional;

import com.company.tests.base.BaseTest;
import com.company.pages.UserTablePage;
import com.company.data.TestData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserCreationTest extends BaseTest {
    
    @Test
    public void testAddValidUser() {
        UserTablePage userTablePage = new UserTablePage(driver);
        var addUserModal = userTablePage.clickAddUser();
        
        addUserModal.fillUserData(
            TestData.VALID_FIRST_NAME,
            TestData.VALID_LAST_NAME,
            TestData.VALID_EMAIL
        );
        
        assertTrue(addUserModal.isAddButtonEnabled(), 
            "Кнопка 'Добавить' должна быть активна при валидных данных");
        
        addUserModal.clickAdd();
        
        assertEquals("Пользователь успешно добавлен.", 
            userTablePage.getSuccessNotificationText());
        assertTrue(userTablePage.isUserInTable(TestData.VALID_EMAIL));
    }
}
