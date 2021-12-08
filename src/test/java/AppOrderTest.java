import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {


    @Test
    void shouldDebetCerdForm() {
        open("http://localhost:9999/");
        $("[name='name']").setValue("Лиукконен Максим");
        $("[name='phone']").setValue("+79819715780");
        $("[class='checkbox__box']").click();
        $("[role='button']").click();
        $(withText("Ваша заявка успешно отправлена!")).shouldBe(visible);
    }
}