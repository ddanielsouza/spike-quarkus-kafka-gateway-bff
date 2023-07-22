package souza.oliveira.daniel.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import souza.oliveira.daniel.client.ProposalRestClient;
import souza.oliveira.daniel.dto.ProposalDetailsDTO;
import souza.oliveira.daniel.service.ProposalService;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRestClient proposalRestClient;

    @Inject
    public ProposalServiceImpl(@RestClient ProposalRestClient proposalRestClient) {
        this.proposalRestClient = proposalRestClient;
    }

    @Override
    public ProposalDetailsDTO getProposalDetailsById(long proposalId) {
        return this.proposalRestClient.getProposalDetailsById(proposalId);
    }

    @Override
    public Response createProposal(ProposalDetailsDTO proposal) {
        return this.proposalRestClient.createProposal(proposal);
    }

    @Override
    public Response removeProposal(long id) {
        return this.proposalRestClient.removeProposal(id);
    }
}
