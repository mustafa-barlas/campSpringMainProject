package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LanguageService {
    List<Language> getAll();

    Language getById(int id);

    void add(Language language) throws Exception;

    void delete(int id);

    void update(Language language);
}
