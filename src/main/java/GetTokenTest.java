import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetTokenTest {
    @Test
    void testToken() {
        RestAssured.given()
                .param("corpid","ww73530bb447ccc302")
                .param("corpsecret","yQvRMp3M3aNHnWpGZ8tnNRLMBY84GefYNE__B74im74")
        .when().get("\n" +
                "https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then().log().all()
        .statusCode(200).body("errcode",equalTo(0));
    }

}
