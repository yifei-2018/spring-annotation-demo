package com.yifei.spring.annotation.api.service;

import com.yifei.spring.annotation.api.model.Book;
import com.yifei.spring.annotation.api.model.BookQryParam;

import java.util.List;

/**
 * @author yifei
 * @date 2019/11/13
 */
public interface StudyService {
    /**
     * 查询书籍
     *
     * @param qryParam 查询参数
     * @return List<Book>
     */
    List<Book> getBookList(BookQryParam qryParam);
}
