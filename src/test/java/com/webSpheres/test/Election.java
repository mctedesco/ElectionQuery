package com.webSpheres.test;

import com.webSpheres.test.common.Endpoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class Election {

    @Test
    public void validateElectionQuerywithAPIKey(){
        given().get("https://www.googleapis.com/civicinfo/v2/elections?key=AIzaSyCTMXDhAkBJBNEcAINED-LFYuTECeEw4GI").then()
.statusCode(200).log().all();
    }

    @Test
    public void validateElectionQuerywithoutAPIKey(){
        given().get("https://www.googleapis.com/civicinfo/v2/elections").then()
                .statusCode(403).log().all();
    }

//    @Test(groups = "demo")
//    public void validateElection2(){
//        given().get(Endpoint.GET_ELECTION).then()
//                .statusCode(400).log().all();
//    }
}
