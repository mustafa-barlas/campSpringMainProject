package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public void add(Language language) throws Exception {
        for (Language lng : languageRepository.getAll()){
            if (check(language.getName())&&languageIsEmpty(language)){
                this.languageRepository.add(language);

            }
        }

    }
    private  boolean check(String languageName)throws Exception{
        for (Language lng : this.languageRepository.getAll()){
            if (lng.getName().equalsIgnoreCase(languageName)){
                return true;

            }

        }
        return false;
    }
    private boolean languageIsEmpty(Language language){
        if (language.getName().isEmpty()|| language.getName().isBlank()){
            return false;
        }
        return true;
    }
    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(Language language) {
        languageRepository.update(language);
    }
}
