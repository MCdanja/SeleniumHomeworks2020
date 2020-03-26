package Homework3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class NasaApiTest {

    private final static String API_KEY_PARAM = "api_key";
    private final static String API_KEY_VALUE = "hblqsKYWM4mtJql3S4DvgKtjvOHt1nf2GdjIUfQC";

    private final static int SUCCESS = 200;

    private final static String BASE_URI = "https://api.nasa.gov/";

    private RequestSpecification baseRequest;

    @BeforeClass
    public void setUp() {
        baseRequest = RestAssured.given();
        baseRequest.param(API_KEY_PARAM, API_KEY_VALUE);
    }

    @Test
    public void getAstronomyPictureOfTheDay() {
        String[] expectedFields = {"copyright", "date", "explanation", "hdurl", "media_type", "service_version", "title", "url"};
        String endpoint = BASE_URI + "planetary/apod";
        Response response = baseRequest.get(endpoint);
        response.then().statusCode(SUCCESS);
        JSONObject jsonResponse = new JSONObject(response.asString());
        Set<String> actualFields = jsonResponse.keySet();

        Assert.assertTrue(responseContainsAllExpectedFields(expectedFields, actualFields), "Some fields missing");
    }

    @Test
    public void getAsteroidsByDate() {
        String[] expectedFields = {"links", "element_count", "near_earth_objects"};
        String endpoint = BASE_URI + "neo/rest/v1/feed";
        String datePattern = "yyyy-MM-dd";
        String startDate = new SimpleDateFormat(datePattern).format(getYesterdayDate());
        String endDate = new SimpleDateFormat(datePattern).format(new Date());
        RequestSpecification request = RestAssured.given(baseRequest);
        request.param("start_date", startDate).param("end_date", endDate);
        Response response = request.get(endpoint);
        response.then().statusCode(SUCCESS);
        JSONObject jsonResponse = new JSONObject(response.asString());
        Set<String> actualFields = jsonResponse.keySet();

        Assert.assertTrue(responseContainsAllExpectedFields(expectedFields, actualFields), "Some fields missing");
    }

    private Date getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    private boolean responseContainsAllExpectedFields(String[] expectedFields, Set<String> actualFields) {
        for (String field: expectedFields) {
            if (!actualFields.contains(field)) {
                return false;
            }
        }
        return true;
    }
}
