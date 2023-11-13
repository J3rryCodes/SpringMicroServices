package de.ij3rry.MicroServiceOne.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("price")
    private double price;
}
