/*
package automation.restassured.htmlresponses;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public RequestSpecification REQUEST;
	public RequestSpecification FOLLOWREQUEST;

	public TestBase() {

		// Rest Assured config
		RestAssured.baseURI = "http://computer-database.herokuapp.com";
		// RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
		// basic request setting
		REQUEST = RestAssured.given().contentType(ContentType.ANY);
		FOLLOWREQUEST = RestAssured.given().contentType(ContentType.ANY);
	}
}
*/
