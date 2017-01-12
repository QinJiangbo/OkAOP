package com.qinjiangbo.test;

import org.springframework.stereotype.Component;

/**
 * @date: 12/01/2017 1:39 PM
 * @author: qinjiangbo@github.io
 */
@Component
public class BookService {

    public void searchBook(long bookId) {
        System.out.println("searching book " + bookId);
    }
}
