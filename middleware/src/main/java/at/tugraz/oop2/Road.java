package at.tugraz.oop2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.List;

@Getter
@AllArgsConstructor
public class Road {
    private String name;
    private Integer id;
    private Geom geom;
    private Map<String, String> tags;
    private String type;
    private List<Long> child_ids;
}
