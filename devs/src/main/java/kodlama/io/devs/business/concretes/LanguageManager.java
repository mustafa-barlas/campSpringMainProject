package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.Language.GetByIdLanguageResponse;

import kodlama.io.devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;


import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private TechnologyRepository technologyRepository;


    public LanguageManager(LanguageRepository languageRepository ,TechnologyRepository technologyRepository) {
        this.languageRepository = languageRepository;
        this.technologyRepository = technologyRepository;

    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {

        List<GetAllLanguagesResponse> languagesResponses = new ArrayList<>();
        List<Language> languages = languageRepository.findAll();

        for (Language language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();

            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            responseItem.setTechnologies(language.getTechnologies());

            languagesResponses.add(responseItem);

        }
        return languagesResponses;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = languageRepository.findById(id).get();
        GetByIdLanguageResponse responseItem = new GetByIdLanguageResponse();

        responseItem.setId(language.getId());
        responseItem.setName(language.getName());
        responseItem.setTechnologies(language.getTechnologies());
        return responseItem;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        this.languageRepository.save(language);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = new Language();
        language.setId(updateLanguageRequest.getId());
        language.setName(updateLanguageRequest.getName());

        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {

        this.languageRepository.deleteById(id);
    }
}
