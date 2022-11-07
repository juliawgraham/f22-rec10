package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {

    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        database = new Database();
        recommender = new RecSys();
        promoService = new PromoService();

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // this is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // this is taking way too long to test
        assertEquals("The Dropout", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // how to test sendEmail() without any return values?
    }

    @Test
    public void testNotSendEmail() {
        // how to test if any email is sent?
    }
}
