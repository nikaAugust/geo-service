import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {


    @BeforeAll
    public static void started() {
        System.out.println("test started");
    }

    @AfterAll
    public static void finished() {
        System.out.println("test completed");
    }

    @Test
    public void localeRUSSIA() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void localeUSA() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Welcome";
        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals(result, expected);
    }
}
