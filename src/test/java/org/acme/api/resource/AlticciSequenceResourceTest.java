package org.acme.api.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class AlticciSequenceResourceTest {

    @Test
    void calculateAlticciSequence() {
        given()
          .when().get("/alticci/0")
          .then()
             .statusCode(200)
             .body(is("0"));
    }

    @Test
    void calculateAlticciSequence10() {
        given()
                .when().get("/alticci/10")
                .then()
                .statusCode(200)
                .body(is("9"));
    }

    @Test
    void calculateAlticciSequenceWithNegativeValue() {
        given()
                .when().get("/alticci/-1")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(400)
                .body("message",is("deve ser um valor maior ou igual a zero"));
    }
}