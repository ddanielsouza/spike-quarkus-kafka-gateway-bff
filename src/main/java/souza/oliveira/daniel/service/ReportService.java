package souza.oliveira.daniel.service;

import jakarta.enterprise.context.ApplicationScoped;
import souza.oliveira.daniel.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@ApplicationScoped
public interface ReportService {
    ByteArrayInputStream genenateCSVOpportunitiesReport();

    List<OpportunityDTO> getOpportunitiesData();
}
