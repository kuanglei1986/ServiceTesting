import com.kl.wework.WeworkConfig;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class GetTokenTest {
    @Test
    void testToken() {
        RestAssured.given()
                .param("corpid", WeworkConfig.getInstance().corId)
                .param("corpsecret",WeworkConfig.getInstance().secret)
        .when().get("\n" +
                "https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then().log().all()
        .statusCode(200).body("errcode",equalTo(0));
    }

}
