package de.ij3rry.MicroServiceOne.service;

import de.ij3rry.MicroServiceOne.models.BookStoreDTO;

import java.io.File;

public interface BookStoreService {
    File saveBookStore(BookStoreDTO bookStoreDTO) throws Exception;
}
