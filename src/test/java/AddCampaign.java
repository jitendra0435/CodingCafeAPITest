import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;import org.testng.annotations.Test;

public class AddCampaign {

    String tokenValue="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUUEiLCJlbWFpbElkIjoidGVzdGluZ3Rlc3RkYXRhYmx6QGdtYWlsLmNvbSIsImlkIjoiNWRjZmRiYmRjNTgzNmIwM" +
            "DA2OTc4YWFhIiwiZXhwIjoxNTgwODc2ODA0fQ.xVJyvJo7l3UgwXKOaJ9aSDe5p6ALyoVNl5wpYADUnas";

    @Test
    public void givenMethodForNumberOfCampaignOnDashboard(){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",tokenValue)
                .when()
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data Retrieved Successfully."));
    }

    @Test
    public void givenMethodForGetCampaignDetailsByItsShortName() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",tokenValue)
                .when()
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashbaord/campaign/ASA");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Campaign retrieved successfully"));

    }

    @Test
    public void givenMethodForGetALLCampaignsShortName()  {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",tokenValue)
                .when()
                .get("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/campaign/shortname");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Campaign retrieved successfully"));
    }


    @Test
    public void givenMethodForGetExcelDataOnBasisOfShortName() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",tokenValue)
                .body("{\"campaignEndDate\":\"04 Feb 2020\",\"campaignShortName\":\"ABH\",\"campaignStartDate\":\"07 Feb 2020\"}")
                .when()
                .post("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/exceldata");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data retrieved successfully"));
    }


    @Test
    public void givenMethodForAddCollegeOrInstitute(){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token",tokenValue)
                .body("{\"address\":\"NaviMumbai\",\"branchName\":\"computer\",\"city\":\"Turbhe\",\" institutionName\":\"Sandip\",\" institutionType\":\"College\",\"shortName\":\"ABVP\",\"url\":\"http://codingcafetest-stg.bridgelabz.com/register/ABVP \"}")
                .when()
                .post("https://cccampdash.incubation.bridgelabz.com/campaign/dashboard/institutions");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("message", Matchers.equalTo("Data retrieved successfully"));

    }
}
