package es.uniovi.asw.webapp;

import es.uniovi.asw.Application;
import es.uniovi.asw.webapp.model.VoterDTO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//@IntegrationTest("server.port:0")
public class ControllerTest {

    @Value("${voters.api}")
    private String API;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private VoterDTO voter;


    /*@Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        setUpDB();
    }

    @After
    public void tearDown() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = API + "/deleteVoter";
        restTemplate.postForObject(uri, voter, VoterDTO.class);
    }

    private void setUpDB() {
        voter = new VoterDTO("test@test.es", "Test", "test", "71866423B",
                "31313");

        RestTemplate restTemplate = new RestTemplate();
        String uri = API + "/createVoter";
        voter = restTemplate.postForObject(uri, voter, VoterDTO.class);
    }

    @Test
    public void getHome() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void getChangePassword() throws Exception{
        mvc.perform(get("/changePassword"))
                .andExpect(status().isOk());
    }

    @Test
    public void getVoter() throws Exception {
        mvc.perform(post("/user")
                .param("login", voter.getEmail())
                .param("password", voter.getPassword()))
                .andExpect(status().isOk())
                .andExpect(content().node(hasXPath("//h3/text()",
                        equalTo("Number: " + voter.getPollingStationCode()))));
    }

    @Test
    public void getWrongVoter() throws Exception {
        mvc.perform(post("/user")
                .param("login", voter.getEmail())
                .param("password", "wrongPass"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    public void getWrongPassword() throws Exception {
        mvc.perform(post("/changePassword")
                .param("login", voter.getEmail())
                .param("oldPassword", "wrongPass")
                .param("newPassword", "newPass"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    public void getWrongUser() throws Exception {
        mvc.perform(post("/changePassword")
                .param("login", "testinmalo@test.es")
                .param("password", voter.getPassword())
                .param("newPassword", "newPass"))
                .andExpect(model().attributeExists("error"));
    }

    @Test
    public void getCorrectPassword() throws Exception {
        String newPassword = "newPass";
        mvc.perform(post("/changePassword")
                .param("login", voter.getEmail())
                .param("password", voter.getPassword())
                .param("newPassword", newPassword))
                .andExpect(model().attributeExists("success"));
        voter.setPassword(newPassword);
    }

    @Test
    public void getWrongUserAndPassword() throws Exception{
        mvc.perform(post("/changePassword")
                .param("login", "testinmalo@test.es")
                .param("password", "malpass")
                .param("newPassword", "newPass"))
                .andExpect(model().attributeExists("error"));
    }*/

}