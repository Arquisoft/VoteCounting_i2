package es.uniovi.asw.votingdb.business.impl;

import es.uniovi.asw.votingdb.business.VoteService;
import es.uniovi.asw.votingdb.business.impl.vote.GetNumberVotesOptionPolling;
import es.uniovi.asw.votingdb.business.impl.vote.GetVotesPolling;
import es.uniovi.asw.votingdb.domain.Option;
import es.uniovi.asw.votingdb.domain.PollingStation;
import es.uniovi.asw.votingdb.domain.Vote;

import java.util.List;

/**
 * Created by Fabio on 12/04/2016.
 */
public class VoteServiceImpl implements VoteService {

    @Override
    public List<Vote> getVotesPolling(PollingStation pollingStation) {
        return CommandExecutor.execute(new GetVotesPolling(pollingStation));
    }

    @Override
    public int getNumberVotesOptionPolling(PollingStation pollingStation, Option option) {
        return CommandExecutor.execute(new GetNumberVotesOptionPolling(pollingStation,option));
    }
}