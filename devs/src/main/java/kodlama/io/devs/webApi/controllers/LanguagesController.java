package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.Language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.Language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.Language.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.Language.GetByIdLanguageResponse;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController  {


    private LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getAll")
    public List<GetAllLanguagesResponse> getAll(){
        return languageService.getAll();
    }
    @PostMapping("/add")
    public  void add(CreateLanguageRequest createLanguageRequest)  {
        languageService.add(createLanguageRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        languageService.delete(id);
    }
    @PutMapping("/update")
    public void update(UpdateLanguageRequest updateLanguageRequest){
        languageService.update(updateLanguageRequest);
    }
    @GetMapping ("/getById")
    public GetByIdLanguageResponse getById(int id){
        return languageService.getById(id);
    }
}
