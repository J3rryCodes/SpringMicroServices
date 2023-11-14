package de.ij3rry.MicroServiceOne.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("price")
    private double price;
}
