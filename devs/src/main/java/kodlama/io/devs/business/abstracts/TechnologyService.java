package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.Technology.GetByIdTechnologyResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();

    GetByIdTechnologyResponse getById(int id);

    void add(CreateTechnologyRequest createTechnologyRequest);

    void update(UpdateTechnologyRequest updateTechnologyRequest);

    void delete(int id);

}
