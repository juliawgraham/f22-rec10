package AndrewWebServices;

import java.util.concurrent.TimeUnit;

/*
 * RecSys is an implementation of AndrewWS recommendation system. 
 * 
 * DO NOT MODIFY this class. 
 */
public class RecSys {
    public String getRecommendation(String accountName) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "The Dropout";
    }
}
