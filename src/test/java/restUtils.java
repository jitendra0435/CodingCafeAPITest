import org.apache.commons.lang3.RandomStringUtils;

public class restUtils {


    static  String tokenValue = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUUEiLCJlbWFpbElkIjoidGVzdGluZ3Rlc3RkYXRhYmx6QGdtYWlsLmNvbSI" +
            "sImlkIjoiNWRjZmRiYmRjNTgzNmIwMDA2OTc4YWFhIiwiZXhwIjoxNTgwOTc4ODEyfQ.f3XHf3N65NLzxVrRjeTKAKHMz9jqXTFtLesccjPAB8s";

  public static String getCollegeName(){
      String collegeName= RandomStringUtils.randomAlphabetic(10);
      return("ST."+collegeName);
  }

    public static String getAddress(){
        String address= RandomStringUtils.randomAlphabetic(6);
        return("Pune"+address);
    }

    public static String getBranchName() {
        String branchName = RandomStringUtils.randomAlphabetic(5);
        return ("Comp" + branchName);

    }
    public static String getCity() {
        String cityName = RandomStringUtils.randomAlphabetic(5);
        return ("Comp" + cityName);
    }
    public static String getShortName() {
        String shortName = RandomStringUtils.randomAlphabetic(1);
        return ("SAP" + shortName);
    }

    public static String getInstituteTypeName() {
        String instituteTypeName = RandomStringUtils.randomAlphabetic(0);
        return ("College" + instituteTypeName);
  }

}
