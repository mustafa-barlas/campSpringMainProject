package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.LanguageService;
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
    public List<Language> getAll(){
        return languageService.getAll();
    }
    @PostMapping("/add")
    public  void add(Language language) throws Exception {
        languageService.add(language);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        languageService.delete(id);
    }
    @PutMapping("/update")
    public void update(Language language){
        languageService.update(language);
    }
    @GetMapping ("/getById")
    public Language getById(int id){
        return languageService.getById(id);
    }
}
