package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language getById(int id);

    void add(Language language);

    void delete(int id);

    void update(Language language);

}
