import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CodingCafeAPI {

    public static JSONObject map =new JSONObject();

    @BeforeClass
    public void setData() {
        map.put("address", restUtils.getAddress());
        map.put("branchName", restUtils.getBranchName());
        map.put("city", restUtils.getCity());
        map.put("institutionName", restUtils.getCollegeName());
        map.put(" institutionType", restUtils.getInstituteTypeName());
        map.put("shortName", restUtils.getShortName());

    }

    @Test
    public void givenMethodForNumberOfCampaignOnDashboard(){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",restUtils.tokenValue)
                .when()
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data Retrieved Successfully."));
    }

    @Test
    public void givenMethodForGetCampaignDetailsByItsShortName() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",restUtils.tokenValue)
                .when()
                .pathParam("campaignShortName","ASA")
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashbaord/campaign/{campaignShortName}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Campaign retrieved successfully"));

    }

    @Test
    public void givenMethodForGetALLCampaignsShortName()  {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",restUtils.tokenValue)
                .when()
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/campaign/shortname");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Campaign retrieved successfully"));
    }


    @Test
    public void givenMethodForGetExcelDataOnBasisOfShortName() {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",restUtils.tokenValue)
                .body("{\"campaignEndDate\":\"04 Feb 2020\",\"campaignShortName\":\"ABH\",\"campaignStartDate\":\"07 Feb 2020\"}")
                .when()
                .post("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/exceldata");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data retrieved successfully"));
    }


    @Test
    public void givenMethodForAddCollegeOrInstitute(){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",restUtils.tokenValue)
                .body(map.toJSONString())
                .when()
                .post("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/institutions");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data retrieved successfully"));

    }
}
