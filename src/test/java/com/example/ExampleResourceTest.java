/*
 * Copyright 2024 by MediData AG
 * ALL RIGHTS RESERVED
 *
 * MediData AG - CommercialSoftwareLicense
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {
    @Test
    void testPreMatchingFilter_withoutAcceptHeader_returnTextPlain() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("plain text: test"));
    }

    @Test
    void testPreMatchingFilter_withAcceptHeaderTextHtml_returnTextPlain() {
        given()
                .when().header("Accept", "text/html")
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("plain text: test"));
    }

    @Test
    void testPreMatchingFilter_withAcceptHeaderApplicationJson_returnTextPlain() {
        given()
                .when().header("Accept", "application/json")
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("plain text: test"));
    }
}