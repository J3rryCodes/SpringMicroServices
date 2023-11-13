package de.ij3rry.MicroServiceOne.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookStoreDTO {
    @JsonProperty("bookstore")
    private Bookstore bookstore;

    @Data
    public static class Bookstore {
        @JsonProperty("book")
        private List<BookDTO> books;
    }
}
