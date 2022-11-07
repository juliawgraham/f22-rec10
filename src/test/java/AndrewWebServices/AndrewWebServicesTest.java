package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {

    Database fakeDatabase;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // create mock objects
        fakeDatabase = new InMemoryDatabase();
        fakeDatabase.addAccount("Scotty", 17214);

        recommender = mock(RecSys.class);
        promoService = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(fakeDatabase, recommender, promoService);
    }

    @Test
    public void testLogInSccuess() {
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testLogInFailed() {
        assertFalse(andrewWebService.logIn("Scotty", 17514));
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

        andrewWebService.logIn("Scotty", 17214);

        // verify the method is called
        verify(promoService, times(0)).mailTo(email);
    }
}
