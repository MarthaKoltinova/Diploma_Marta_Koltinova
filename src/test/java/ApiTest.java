import RestAssured.RestHelp;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.baseURI;

public class ApiTest extends RestHelp {
    String pathToJson = "src/test/java/ApiRequests/addItem.json";

    @BeforeTest
    public void getStarted() {
        baseURI = "https://catalog.onliner.by/sdapi/";
    }

    @Test(priority = 1)
    public void getCountOfPages() {
        Response response = getMethod("catalog.api/search/mobile?group=1");
        Assert.assertEquals(extractJson(response, "page.limit"), "30");
       // Assert.assertEquals(extractJson(response, "page.last"), "94");
    }

    @Test(priority = 2)
    public void getFirstItem() {
        Response response = getMethod("catalog.api/facets/mobile");
        checkStatusCode(response, 200);
        String exampleRequest = "";
        try {
            exampleRequest = FileUtils.readFileToString(new File("src/test/java/ApiRequests/item.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals((extractJson(response, "segments[0]")), exampleRequest);

    }

    @Test(priority = 3)
    public void verifyFirstItem() {
        Response response = getMethod("catalog.api/products/honor508128gbeg");
        checkStatusCode(response, 200);
        Assert.assertEquals(extractJson(response, "name"), "50 8GB/128GB (изумрудно-зеленый)");
        Assert.assertEquals(extractJson(response, "status"), "active");
    }

    @Test(priority = 4)
    public void putPassword() {
        Response response = postMethod("user.api/reset-password", pathToJson);
        checkStatusCode(response, 428);
        Assert.assertEquals(extractJson(response, "title"), "Доступ запрещен");

    }


}
