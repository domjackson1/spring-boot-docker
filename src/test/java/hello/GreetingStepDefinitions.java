package hello;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(
        classes = Application.class,
        loader = SpringBootContextLoader.class)
@WebMvcTest(GreetingController.class)
public class GreetingStepDefinitions {

    @Autowired
    private MockMvc mockMvc;

    private ResultActions greetingResult;

    @When("^I ask for a greeting$")
    public void i_ask_for_a_greeting() throws Exception {
        this.greetingResult = this.mockMvc.perform(get("/greeting"));
    }

    @When("^I ask for a greeting giving \"([^\"]*)\"$")
    public void i_ask_for_a_greeting_giving_name(String name) throws Exception {
        this.greetingResult = this.mockMvc.perform(get("/greeting").param("name", name));
    }

    @Then("^I get a status of OK$")
    public void i_should_get_status_200() throws Exception {
        greetingResult.andDo(print()).andExpect(status().isOk());

    }

    @And("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String helloWorld) throws Exception {
        greetingResult.andDo(print()).andExpect(jsonPath("$.content").value(helloWorld));
    }
}
