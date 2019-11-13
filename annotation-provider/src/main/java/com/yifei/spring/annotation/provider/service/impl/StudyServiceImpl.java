package com.yifei.spring.annotation.provider.service.impl;

import com.yifei.spring.annotation.api.model.Book;
import com.yifei.spring.annotation.api.model.BookQryParam;
import com.yifei.spring.annotation.api.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yifei
 * @date 2019/11/13
 */
@Service("studyService")
public class StudyServiceImpl implements StudyService {
    /**
     * 查询书籍
     *
     * @param qryParam 查询参数
     * @return List<Book>
     */
    @Override
    public List<Book> getBookList(BookQryParam qryParam) {
        return null;
    }
}
