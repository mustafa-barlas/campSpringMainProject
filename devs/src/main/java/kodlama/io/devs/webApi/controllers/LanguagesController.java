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
        this.languageService.add(language);
    }
    @PostMapping("/delete")
    public void delete(@RequestParam int id){
        this.languageService.delete(id);
    }
    @PostMapping("/update")
    public void update(Language language){
        this.languageService.update(language);
    }
    @GetMapping ("/getById")
    public Language getById(int id){
        return this.languageService.getById(id);
    }
}
