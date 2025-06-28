package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Tag("bfs")
@Feature("Главная страница сайта https://bfs.su")
@Story("Проверка главной страницы сайта")
@Severity(SeverityLevel.MINOR)
@Owner("Прохорова Юлия")
public class BfsTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка CookiePopup")
    void cookiePopupTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Проверить отображение CookiesPopup и возможность их принятия", () -> {
            mainPage.acceptCookie();
        });
    }

    @Test
    @DisplayName("Проверка отображения табов")
    void tabsShouldBeVisibleTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Проверить отображение таба BFS devices", () -> {
            mainPage.checkTabDevicesIsVisible();
        });
        step("Проверить отображение таба GRG devices", () -> {
            mainPage.checkTabSoftwareIsVisible();
        });
        step("Проверить отображение таба BFS IT", () -> {
            mainPage.checkTabCustomizationIsVisible();
        });
        step("Проверить отображение таба Contact us", () -> {
            mainPage.checkTabContactUsIsVisible();
        });
    }

    @Test
    @DisplayName("Проверка отображения формы ContactUs")
    void checkContactUsFormIsVisibleTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Вызвать и проверить отображение формы Contact us", () -> {
            mainPage.checkContactFormIsVisible();
        });
    }

    @Test
    @DisplayName("Проверка валидации формы ContactUs")
    void checkValidationFormTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Вызвать форму Contact us", () -> {
            mainPage.checkContactFormIsVisible();
        });
        step("Нажать чекбокс согласия с политикой", () -> {
            mainPage.checkboxIsChecked();
        });
        step("Нажать кнопку Submit для отправки формы", () -> {
            mainPage.submitButtonClick();
        });
        step("Проверить наличие валидации", () -> {
            mainPage.checkValidationSubmitForm();
        });
    }

    @Test
    @DisplayName("Проверка перевода на русскую версию")
    void checkRussianVersionTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Проверить изменение языка", () -> {
            mainPage.checkEnglishVersion();
        });
    }
}
