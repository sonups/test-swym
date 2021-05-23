//package automation.restassured.htmlresponses;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//
//import org.junit.Test;
//
//import io.restassured.http.Cookies;
//import io.restassured.response.Response;
//
//public class RestAssuredTestCases extends TestBase {
//
//	@Test
//	public void verifyComputerDataBaseDefaultURL() {
//
//		Response response = REQUEST.given().get("/computers");
//		String responseString = response.asString();
//		response.then().statusCode(200);
//		assertThat(responseString, containsString("Play sample application &mdash; Computer database"));
//
//	}
//
//	@Test
//	public void verifySearchComputerByName() {
//
//		Response response = REQUEST.given().queryParam("f", "Z").get("/computers");
//		String responseString = response.asString();
//		response.then().statusCode(200);
//		assertThat(responseString, containsString("<td><a href=\"/computers/171\">Sinclair ZX80</a></td>"));
//
//	}
//
//	@Test
//	public void verifyReadComputerDetails() {
//
//		Response response = REQUEST.given().get("/computers/171");
//		String responseString = response.asString();
//		response.then().statusCode(200);
//		assertThat(responseString,
//				containsString("<input type=\"text\" id=\"name\" name=\"name\" value=\"Sinclair ZX80\" >"));
//		assertThat(responseString,
//				containsString("<input type=\"text\" id=\"introduced\" name=\"introduced\" value=\"\" >"));
//		assertThat(responseString,
//				containsString("<input type=\"text\" id=\"discontinued\" name=\"discontinued\" value=\"\" >"));
//		assertThat(responseString, containsString("<option value=\"25\" selected>Sinclair Research Ltd</option>"));
//
//	}
//
//	@Test
//	public void verifyCreateComputer() {
//
//		Response response = REQUEST.given().headers("Pragma", "no-cache", "Cache-Control", "no-cache",
//				"Upgrade-Insecure-Requests", "1", "Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept",
//				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
//				"Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.param("name", "AAAA", "introduced", "2019-01-01", "discontinued", "2019-01-01", "company", "21")
//				.redirects().follow(false).post("/computers");
//		response.then().statusCode(303);
//
//		String location = response.getHeader("Location");
//
//		Cookies cookie = response.then().extract().response().getDetailedCookies();
//
//		Response response2 = FOLLOWREQUEST.given().headers("Cache-Control", "no-cache", "Upgrade-Insecure-Requests",
//				"1", "Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept", "*/*", "Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.cookies(cookie).get(location);
//
//		response2.then().statusCode(200);
//
//		assertThat(response2.asString(), containsString("<strong>Done!</strong> Computer AAAA has been created"));
//	}
//
//	@Test
//	public void verifyDeleteComputer() {
//
//		Response response = REQUEST.given().headers("Cache-Control", "no-cache", "Upgrade-Insecure-Requests", "1",
//				"Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept", "*/*", "Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.pathParam("computerid", 388).redirects().follow(false).post("/computers/{computerid}/delete");
//		response.then().statusCode(303);
//
//		String location = response.getHeader("Location");
//
//		Cookies cookie = response.then().extract().response().getDetailedCookies();
//
//		Response response2 = FOLLOWREQUEST.given().headers("Cache-Control", "no-cache", "Upgrade-Insecure-Requests",
//				"1", "Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept", "*/*", "Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.cookies(cookie).get(location);
//
//		response2.then().statusCode(200);
//
//		assertThat(response2.asString(), containsString("<strong>Done!</strong> Computer has been deleted"));
//	}
//
//	@Test
//	public void verifyUpdateComputer() {
//
//		Response response = REQUEST.given().headers("Pragma", "no-cache", "Cache-Control", "no-cache",
//				"Upgrade-Insecure-Requests", "1", "Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept",
//				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
//				"Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.param("name", "AAAAB", "introduced", "2019-01-01", "discontinued", "2019-01-01", "company", "21")
//				.redirects().follow(false).post("/computers/170");
//		response.then().statusCode(303);
//
//		String location = response.getHeader("Location");
//
//		Cookies cookie = response.then().extract().response().getDetailedCookies();
//
//		Response response2 = FOLLOWREQUEST.given().headers("Cache-Control", "no-cache", "Upgrade-Insecure-Requests",
//				"1", "Content-Type", "application/x-www-form-urlencoded", "User-Agent",
//				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36",
//				"Accept", "*/*", "Accept-Encoding", "gzip, deflate", "Accept-Language", "en-US,en;q=0.9")
//				.cookies(cookie).get(location);
//
//		response2.then().statusCode(200);
//
//		assertThat(response2.asString(), containsString("<strong>Done!</strong> Computer AAAAB has been updated"));
//	}
//
//}
