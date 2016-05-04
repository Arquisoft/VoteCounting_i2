package es.uniovi.asw.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.counting.VoteCount;
import es.uniovi.asw.results.Application;
import es.uniovi.asw.votingdb.business.OptionService;
import es.uniovi.asw.votingdb.business.PollingStationService;
import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.infrastructure.ServicesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class ResultsSteps {
    @Autowired
    protected WebApplicationContext context;


    private Map<String, Integer> votes = new HashMap<String, Integer>();


    @Given("(\\d+) random votes of: (.*)")
    public void loadVotes(int total, List<String> plainOptions) {
        OptionService os = ServicesFactory.createOptionService();
        PollingStationService ps = ServicesFactory.createpollingStationService();
        PollingStation pollingStation =
                ps.updatePollingStation(new PollingStation("test", "test",
                        "test", "test"));

        List<Option> options = new ArrayList<Option>();
        for (String option : plainOptions) {
            options.add(os.updateOption(new Option(option, "")));
        }

        Random r = new Random();
        VoteService service = ServicesFactory.createVoteService();
        for (int i = 0; i < total; i++) {
            int value = 0;
            Option option = options.get(r.nextInt(options.size()));
            if (votes.containsKey(option.getName()))
                value = votes.get(option.getName());
            votes.put(option.getName(), value + 1);

            service.updateVote(new Vote(option, pollingStation));
        }
    }

    @When("I start the counting")
    public void triggerCount() throws Exception {
        VoteCount.run();
    }

    @Then("The votes are shown")
    public void checkResults() throws Exception {
        Assert.notNull(context);
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(context).build();
        MvcResult result = mvc.perform(get("/")).andReturn();
        for (String vote : votes.keySet()) {
            assertThat(result.getResponse().getContentAsString(),
                    containsString(vote));
        }

    }
}
