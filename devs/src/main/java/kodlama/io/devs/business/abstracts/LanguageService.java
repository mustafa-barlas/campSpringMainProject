package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.Language.GetByIdLanguageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();

    GetByIdLanguageResponse getById(int id);

    void add(CreateLanguageRequest createLanguageRequest);

    void update(UpdateLanguageRequest updateLanguageRequest);

    void delete(int id);

}
