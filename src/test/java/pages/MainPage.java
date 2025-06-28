package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            cookieElement = $(".CookiesPopup_root__Kv5rq"),
            cookieButton = $(byText("Accept")),
            tabDevices = $(byText("BFS devices")),
            tabSoftware = $(byText("GRG devices")),
            tabCustomization = $(byText("BFS IT")),
            tabServices = $(byText("Contact us")),
            contactForm = $(byText("Contact us")),
            privacyCheckbox = $(".CheckBox_checkBox__6eORr"),
            submitButton = $(byText("Submit")),
            validationError = $(byText("Введите имя")),
            langButtonEn = $(byText("EN")),
            langButtonRu = $(byText("RU"));

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Проверяем Cookie элемент")
    public MainPage acceptCookie() {
        if (cookieElement.exists()) {
            // cookieLink.shouldBe(Condition.visible);
            cookieButton.shouldBe(visible).click();
        }
        return this;
    }

    @Step ("Проверяем наличие таба BFS devices")
    public MainPage checkTabDevicesIsVisible() {
        tabDevices.shouldBe(visible);
        return this;
    }

    @Step("Проверяем наличие таба BFS devices")
    public MainPage checkTabSoftwareIsVisible() {
        tabSoftware.shouldBe(visible);
        return this;
    }

    @Step("Проверяем наличие таба BFS IT")
    public MainPage checkTabCustomizationIsVisible() {
        tabCustomization.shouldBe(visible);
        return this;
    }

    @Step("Проверяем наличие таба Contact us")
    public MainPage checkTabContactUsIsVisible() {
        tabServices.shouldBe(visible);
        return this;
    }

    @Step("Проверяем отображение формы обратной связи")
    public MainPage checkContactFormIsVisible() {
        tabServices.shouldBe(visible).click();
        contactForm.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем чекбокс принятия политики в форме обратной связи")
    public MainPage checkboxIsChecked() {
        privacyCheckbox.click();
        return this;
    }

    @Step("Нажать кнопку для отправки формы")
    public MainPage submitButtonClick() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить наличие валидации на форме обратной связи")
    public MainPage checkValidationSubmitForm() {
        validationError.shouldBe(visible);
        return this;
    }

    @Step("Проверить переход на английскую версию")
    public MainPage checkEnglishVersion() {
        langButtonEn.shouldBe(visible).click();
        langButtonRu.shouldBe(visible).click();
        langButtonEn.shouldBe(visible);
        return this;
    }
}
