package at.tugraz.oop2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Paging {
    @JsonProperty("take")
    private int take;
    @JsonProperty("total")
    private int total;
    @JsonProperty("skip")
    private int skip;
}
