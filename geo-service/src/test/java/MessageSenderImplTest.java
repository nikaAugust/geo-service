import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @BeforeAll
    public static void started() {
        System.out.println("test started");
    }


    @Test
    public void sendRUSSIA() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);

        Mockito.when(geoService.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        String current = messageSender.send(headers);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void sendUSA() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);

        Mockito.when(geoService.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("NEW_YORK", Country.USA, null, 0));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String current = messageSender.send(headers);
        String expected = "Welcome";

        Assertions.assertEquals(expected, current);
    }
}
