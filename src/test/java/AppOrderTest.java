import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {

    @BeforeEach
    public void openBrauser() {
        open("http://localhost:9999/");
    }


    @Test
    void shouldDebetCardForm() { // валидные данные
        $("[name='name']").setValue("Лиукконен Максим");
        $("[name='phone']").setValue("+79819715780");
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(withText("Ваша заявка успешно отправлена!")).shouldBe(visible);
    }

    @Test
    void shouldDebetCardFormWithInvalidNameForm() { // не валидное ФИО
        $("[name='name']").setValue("Liukkonen Maksim");
        $("[name='phone']").setValue("+79819715780");
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(".input_invalid[data-test-id='name']").shouldBe(visible);
    }

//    input_invalid.input__sub

    @Test
    void shouldDebetCardFormWithInvalidPhoneForm() { // не валидный номер телефона
        $("[name='name']").setValue("Лиукконен Максим");
        $("[name='phone']").setValue("8(981)971-57-80");
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(".input_invalid[data-test-id='phone']").shouldBe(visible);
    }


    @Test
    void shouldDebetCardFormWithEmptyForm() { // форма ФИО и номера телефона
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(".input_invalid[data-test-id='name']").shouldBe(visible);
    }

    @Test
    void shouldDebetCardFormWithNameFormEmpty() { //  форма номера телефона пустая
        $("[name='name']").setValue("Лиукконен Максим");
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(".input_invalid[data-test-id='phone']").shouldBe(visible);
    }

    @Test
    void shouldDebetCardFormWithCheckBoxEmpty() { // чек бокс пустой
        $("[name='name']").setValue("Лиукконен Максим");
        $("[name='phone']").setValue("+79819715780");
        $("[role='button']").click();
        $(".input_invalid[data-test-id='agreement']").shouldBe(visible);
    }


}