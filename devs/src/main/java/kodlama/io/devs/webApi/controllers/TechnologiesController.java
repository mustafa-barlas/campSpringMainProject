package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.Technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.Technology.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.Technology.GetAllTechnologyResponse;
import kodlama.io.devs.business.responses.Technology.GetByIdTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private TechnologyService technologyService;

    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
    @GetMapping("/getAll")
    public List<GetAllTechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    @GetMapping("/getById")
    public GetByIdTechnologyResponse getById(int id){
        return technologyService.getById(id);
    }
    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest){
        technologyService.add(createTechnologyRequest);
    }
    @PutMapping("/update")
    public  void update (UpdateTechnologyRequest updateTechnologyRequest){
        this.technologyService.update(updateTechnologyRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        this.technologyService.delete(id);
    }
}
