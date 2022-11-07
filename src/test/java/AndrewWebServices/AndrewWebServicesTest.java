package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {

    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // create mock objects
        database = mock(Database.class);
        recommender = mock(RecSys.class);
        promoService = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testGetPassword() {
        InMemoryDatabase fakeDatabase = new InMemoryDatabase();
        fakeDatabase.addAccount("Scotty", 17214);
        assertEquals(17214, fakeDatabase.getPassword("Scotty"));
    }

    @Test
    public void testGetRecommendation() {
        // define stubbing return value before actual execution
        when(recommender.getRecommendation("Scotty")).thenReturn("The Dropout");

        String result = andrewWebService.getRecommendation("Scotty");
        System.out.println(result);
        assertEquals("The Dropout", result);
    }

    @Test
    public void testSendEmail() {
        String email = "scotty@andrew.cmu.edu";

        andrewWebService.sendPromoEmail(email);

        // verify the method is called
        verify(promoService).mailTo(email);
    }

    @Test
    public void testNotSendEmail() {
        String email = "scotty@andrew.cmu.edu";

        andrewWebService.logIn("Tartan", 17514);

        // verify the method is called
        verify(promoService, times(0)).mailTo(email);
    }
}
