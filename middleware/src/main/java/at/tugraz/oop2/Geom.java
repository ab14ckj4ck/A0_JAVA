package at.tugraz.oop2;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Geom {
    private String type;
    private Object coordinates;
    private Crs crs;
}
