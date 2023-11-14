package de.ij3rry.MicroServiceOne.routs;

import de.ij3rry.MicroServiceOne.models.BookStoreDTO;
import de.ij3rry.MicroServiceOne.service.BookStoreService;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

@Component
public class StoreBookStoreRoute extends RouteBuilder {

    @Autowired
    private BookStoreService bookStoreService;

    @Override
    public void configure() throws Exception {
        rest("/bookStore").post("/save").routeId("save_book_store")
                .consumes("application/json").type(BookStoreDTO.class)
                .produces("application/json").to("direct:saveDTOasXML");

        from("direct:saveDTOasXML").routeId("saveDTOasXML").log(LoggingLevel.DEBUG,"received message : ${body}")
                .unmarshal(new JacksonDataFormat(BookStoreDTO.class))
                .marshal().json()
                .setHeader("CamelFileName", constant("bookStore.json"))
                .to("file:outbond/")
                .log(LoggingLevel.INFO,"${body}");
    }
}
