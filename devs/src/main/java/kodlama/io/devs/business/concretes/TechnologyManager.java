package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.Technology.GetByIdTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private LanguageRepository languageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {

        List<GetAllTechnologyResponse> technologyResponses = new ArrayList<>();
        List<Technology> technologies = technologyRepository.findAll();

        for (Technology technology : technologies) {

            GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();

            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            responseItem.setLanguage(technology.getLanguage());
            technologyResponses.add(responseItem);
        }
        return technologyResponses;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Technology technology = technologyRepository.findById(id).get();
        GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();

        responseItem.setId(technology.getId());
        responseItem.setName(technology.getName());
        responseItem.setLanguage(technology.getLanguage());

        return responseItem;

    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        Language language = languageRepository.findById(createTechnologyRequest.getLanguageId()).get();

        technology.setName(createTechnologyRequest.getName());
        technology.setLanguage(language);


        this.technologyRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = new Technology();
        Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
        technology.setId(updateTechnologyRequest.getId());
        technology.setName(updateTechnologyRequest.getName());
        technology.setLanguage(language);

        this.technologyRepository.save(technology);
    }

    @Override
    public void delete(int id) {
        this.technologyRepository.deleteById(id);
    }
}
