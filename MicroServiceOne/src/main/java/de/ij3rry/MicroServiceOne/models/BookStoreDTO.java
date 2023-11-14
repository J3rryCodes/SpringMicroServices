package de.ij3rry.MicroServiceOne.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
public class BookStoreDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("books")
    private List<Book> books;
}
