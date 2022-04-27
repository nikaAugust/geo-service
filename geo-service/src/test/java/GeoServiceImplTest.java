import org.junit.jupiter.api.*;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @BeforeAll
    public static void started() {
        System.out.println("test started");
    }

    @AfterAll
    public static void finished() {
        System.out.println("test completed");
    }

    @Test
    public void LocationByIpMoscowTest() {
        GeoService geoService = new GeoServiceImpl();
        String expected = "Moscow";
        String result = geoService.byIp("172.").getCity();
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void LocationByIpNewYorkTest() {
        GeoService geoService = new GeoServiceImpl();
        String expected = "New York";
        String result = geoService.byIp("96.").getCity();
        Assertions.assertEquals(result, expected);
    }
}
