package de.ij3rry.MicroServiceOne.routs;

import de.ij3rry.MicroServiceOne.models.BookStoreDTO;
import de.ij3rry.MicroServiceOne.service.BookStoreService;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

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
                .process(exchange -> {
                    BookStoreDTO bookStoreDTO = exchange.getIn().getBody(BookStoreDTO.class);
                    File file = bookStoreService.saveBookStore(bookStoreDTO);
                    exchange.getIn().setBody(file);
                }).log(LoggingLevel.INFO,"${body}");
    }
}
