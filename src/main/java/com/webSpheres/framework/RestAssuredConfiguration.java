package com.webSpheres.framework;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class RestAssuredConfiguration {

    @BeforeSuite(alwaysRun = true)
    public void Configure() {
        RestAssured.baseURI = "https://www.googleapis.com";
        RestAssured.basePath = "/civicinfo?key=s-zL_F8jaequiXxkAW4Cxk0n1VA/sCnzrQew7mEClLvJojZkESj1XqM";

    }

}
