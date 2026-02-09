package at.tugraz.oop2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Amenity {
    private String name;
    private Integer id;
    private Geom geom;
    private Map<String, String> tags;
    private String type;
}
