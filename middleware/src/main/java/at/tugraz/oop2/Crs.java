package at.tugraz.oop2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Crs {
    private String type;
    private Map<String, String> properties;
}
