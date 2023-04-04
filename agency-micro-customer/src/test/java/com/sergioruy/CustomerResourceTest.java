package com.sergioruy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

@QuarkusTest
public class CustomerResourceTest {


    @DisplayName(value = "Get a list of customer in a positive scenario.")
    @Test
    public void testGetCustomers_notEmpty() {
        given()
                .when().get("/customers")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("$.size()", not(empty()));
    }

}
