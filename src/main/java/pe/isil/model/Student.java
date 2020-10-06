package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private Integer id;
    private String nombre;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;

}
