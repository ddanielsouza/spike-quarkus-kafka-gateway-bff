package souza.oliveira.daniel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import souza.oliveira.daniel.dto.ProposalDetailsDTO;

@ApplicationScoped
public interface ProposalService {
    ProposalDetailsDTO getProposalDetailsById(@PathParam("id") long proposalId);

    Response createProposal(ProposalDetailsDTO proposal);

    Response removeProposal(long id);
}
