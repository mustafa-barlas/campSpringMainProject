package kodlama.io.devs.business.responses.Language;

import kodlama.io.devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdLanguageResponse {

    private int id;
    private String name;
    private List<Technology> technologies;
}
