package kodlama.io.devs.business.requests.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {

    private int id;
    private String name;
    private int languageId;
}
