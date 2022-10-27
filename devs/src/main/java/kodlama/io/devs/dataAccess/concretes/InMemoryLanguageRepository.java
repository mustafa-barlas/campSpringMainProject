package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {


    List<Language> languages;

    public InMemoryLanguageRepository() {

        languages = new ArrayList<Language>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "C++"));
        languages.add(new Language(4, "Kotlin"));
        languages.add(new Language(5, "Dart"));
        languages.add(new Language(6, "Python"));
        languages.add(new Language(7, "R"));
        languages.add(new Language(8, "Javascript"));
    }


    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        for (Language lng : languages) {
            if (lng.getId() == id) {
                return lng;
            }
        }
        return null;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void delete(int id) {
        for (Language lng : languages) {
            if (lng.getId() == id) {
                languages.remove(lng);
            }
        }
    }

    @Override
    public void update(Language language) {
        for (Language lng : languages) {
            if (lng.getId() == language.getId()) {
                lng.setName(language.getName());
            }
        }
    }
}
