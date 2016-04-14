package es.uniovi.asw.votingdb;


import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;
import es.uniovi.asw.votingdb.domain.Voter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptyTest {

    @Test
    /**
     * Primer test de prueba pa tener algo mas que nada
     */
    public void modelTests() {
        PollingStation p1 = new PollingStation("Asturias", "Jogin", "Cimavilla", "España");
        PollingStation p2 = new PollingStation("Asturias", "Oviedo", "El Cristo", "España");

        Voter vA = new Voter("A","00000000A","A@A.A",p1,"A");
        Voter vB = new Voter("B","00000001B","B@B.B",p1,"B");
        Voter vC = new Voter("C","00000002C","C@C.C",p1,"C");
        Voter vD = new Voter("D","00000003D","D@D.D",p2,"D");

        assertEquals(3,p1.getVoters().size());
        assertTrue(p1.getVoters().contains(vA));
        assertTrue(p1.getVoters().contains(vB));
        assertTrue(p1.getVoters().contains(vC));
        assertFalse(p1.getVoters().contains(vD));

        Option o1 = new Option("O1","option 1");
        Option o2 = new Option("O2","option 2");

        Vote v1 = vota(vA,o1);
        Vote v2 = vota(vB,o2);

        assertEquals(1,o1.getVotes().size());
        assertEquals(1,o2.getVotes().size());

        Vote v3 = vota(vC,o1);
        Vote v4 = vota(vD,o2);

        assertEquals(2,o2.getVotes().size());
        assertEquals(2,o2.getVotes().size());
        assertTrue(o1.getVotes().contains(v1));
        assertTrue(o2.getVotes().contains(v2));

        assertEquals(1,p2.getVotes().size());
        assertTrue(p1.getVotes().contains(v1));
        assertTrue(p1.getVotes().contains(v2));
        assertTrue(p1.getVotes().contains(v3));
        assertTrue(p2.getVotes().contains(v4));


    }

    private Vote vota(Voter v, Option o)
    {
        return new Vote(o,v.getPollingStation());
    }

}
