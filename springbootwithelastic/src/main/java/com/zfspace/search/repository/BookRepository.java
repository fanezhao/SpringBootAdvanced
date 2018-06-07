package com.zfspace.search.repository;

import com.zfspace.search.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ZF
 * @description
 * @date 2018-06-07 17:32
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findBooksByNameLike(String bookName);
}
