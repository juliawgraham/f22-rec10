package AndrewWebServices;

public class AndrewWebServices {
    Database database;
    RecSys recommender;
    PromoService promoService;

    public AndrewWebServices(Database database, RecSys recommender, PromoService promoService) {
        this.database = database;
        this.recommender = recommender;
        this.promoService = promoService;
    }

    /*
     * logIn method call takes accound name and password as input,
     * accesses the database to verify the information.
     * 
     * Note that the database has a large latency.
     * 
     * TODO: use fake to test database.getPassword().
     */
    public boolean logIn(String accountName, int password) {
        long startTime = System.currentTimeMillis();
        if (this.database.getPassword(accountName) == password) {
            long endTime = System.currentTimeMillis();
            System.out.println("Login success! Took " + (endTime - startTime) / 1000 + " seconds");
            return true;
        }
        System.out.println("Login failed. ");
        return false;
    }

    /*
     * getRecommendation takes the account name as input and returns
     * a movie name as recommendation to the user.
     * 
     * Note that the recommender uses fancy machine learning algorithm
     * and may take very long to return results.
     * 
     * TODO: use stubs to test recommender.getRecommendation().
     */
    public String getRecommendation(String accountName) {
        long startTime = System.currentTimeMillis();
        String movie = recommender.getRecommendation(accountName);
        long endTime = System.currentTimeMillis();
        System.out.println("Recommend " + movie + ". Took " + (endTime - startTime) / 1000 + " seconds");
        return movie;
    }

    /*
     * sendPromoEmail sends an promotional email to given email address
     * using the promoServices.
     * 
     * Note that the function has no return value and we want to avoid
     * actually sending emails during testing.
     * 
     * TODO: use mocks to test promoSetvice.sendPromoEmail(email)
     */
    public void sendPromoEmail(String email) {
        promoService.mailTo(email);
    }
}
