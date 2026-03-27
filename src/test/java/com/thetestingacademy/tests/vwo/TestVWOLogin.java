package com.thetestingacademy.tests.vwo;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.vwo.response.LoginResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {

    @Test
    public void test_VWO_Login(){

        requestSpecification.baseUri(APIConstants.VWO_BASE_URL);
        requestSpecification.basePath(APIConstants.VWO_LOGIN_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(vwoPayloadManger.setLoginData()).log().all()
                .post();

        //Extraction Part - 2
        LoginResponse loginResponse = vwoPayloadManger.getLoginData(response.asString());

        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response,200);
//        String pwd = System.getenv("PASSWORD_HIDDEN");


    }
}
