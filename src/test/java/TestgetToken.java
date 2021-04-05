import com.kl.wework.Wework;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class TestgetToken {
    @Test
    void testToken(){
        Wework wework=new Wework();
        String token=wework.getToken();
        assertThat(token, not(equalTo(null)));

    }
}
