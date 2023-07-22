package souza.oliveira.daniel.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import souza.oliveira.daniel.client.ReportRestClient;
import souza.oliveira.daniel.dto.OpportunityDTO;
import souza.oliveira.daniel.service.ReportService;
import souza.oliveira.daniel.utils.CSVHelper;

import java.io.ByteArrayInputStream;
import java.util.List;

@ApplicationScoped
public class ReportServiceImpl implements ReportService {

    private final ReportRestClient reportRestClient;

    @Inject
    public ReportServiceImpl(@RestClient ReportRestClient reportRestClient) {
        this.reportRestClient = reportRestClient;
    }

    @Override
    public ByteArrayInputStream genenateCSVOpportunitiesReport() {
        final var opportunities = this.reportRestClient.requestOpportunitiesData();
        return CSVHelper.opportunitiesToCSV(opportunities);
    }

    @Override
    public List<OpportunityDTO> getOpportunitiesData() {
        return this.reportRestClient.requestOpportunitiesData();
    }
}
