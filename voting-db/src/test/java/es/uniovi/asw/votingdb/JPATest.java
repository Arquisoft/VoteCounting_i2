package es.uniovi.asw.votingdb;


import es.uniovi.asw.votingdb.business.VoterService;
import es.uniovi.asw.votingdb.business.exception.VoterNotFoundException;
import es.uniovi.asw.votingdb.domain.*;
import es.uniovi.asw.votingdb.infrastructure.ServicesFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class JPATest {
    @Test
    public void testRetrieve() {
        String email = "test@test.es";
        String password = "test";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        vs.deleteVoter(voter);
    }

    @Test
    public void testUpdatePassword() {
        String email = "test@test.es";
        String password = "old";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        String newPassword = "new";
        vs.updatePassword(voter, newPassword);

        assertEquals(voter, vs.getVoter(email, newPassword));

        vs.deleteVoter(voter);
    }

    @Test(expected = VoterNotFoundException.class)
    public void testNotFound() throws Exception {
        VoterService vs = ServicesFactory.createVoterService();
        vs.getVoter("thisemaildoesnotexist@never.org", "thispassneither");
    }

}
