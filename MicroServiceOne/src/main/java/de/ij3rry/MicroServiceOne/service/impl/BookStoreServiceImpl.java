package de.ij3rry.MicroServiceOne.service.impl;

import de.ij3rry.MicroServiceOne.models.BookStoreDTO;
import de.ij3rry.MicroServiceOne.service.BookStoreService;
import de.ij3rry.MicroServiceOne.util.ConfigProvider;
import de.ij3rry.MicroServiceOne.util.Utils;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    @Override
    public File saveBookStore(BookStoreDTO bookStoreDTO) throws Exception {
        File file;
        switch(ConfigProvider.getBookStoreFileType().toLowerCase()){
            case "xml" : file = saveBookStoreAsXML(bookStoreDTO); break;
            default: throw new RuntimeException("File format type not found in cofig");
        }
        return file;
    }


    private File saveBookStoreAsXML(BookStoreDTO bookStoreDTO) throws JAXBException {
        StringBuffer fileName = new StringBuffer(ConfigProvider.getBookStoreFileNamePrefix()).append(Utils.getRandomSixDigitNumber()).append(".xml");
        File file = new File(fileName.toString());
        JAXBContext context = JAXBContext.newInstance(BookStoreDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bookStoreDTO, file);
        return file;
    }
}
