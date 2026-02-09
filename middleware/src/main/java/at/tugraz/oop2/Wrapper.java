package at.tugraz.oop2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Wrapper {
    @JsonProperty("entries")
    private Object objects;
    @JsonProperty("paging")
    private Paging paging;
 }
