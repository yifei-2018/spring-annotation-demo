package com.yifei.spring.annotation.web.controller;

import com.yifei.spring.annotation.api.model.Book;
import com.yifei.spring.annotation.api.model.BookQryParam;
import com.yifei.spring.annotation.api.service.StudyService;
import com.yifei.spring.annotation.web.model.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yifei
 * @date 2019/9/19
 */
@RequestMapping("/study")
@RestController
public class StudyController {
    private static final Logger logger = LoggerFactory.getLogger(StudyController.class);

    @Resource
    private StudyService studyService;

    /***
     * PathVariable注解测试
     *
     * @param data 占位符
     * @return JsonResult
     */
    @RequestMapping(value = "/show/{data}", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult show(@PathVariable String data) {
        return new JsonResult<>(data);
    }

    /**
     * 检索书籍
     *
     * @param request 请求
     * @return JsonResult
     */
    @RequestMapping(value = "/searchBook", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult searchBook(HttpServletRequest request) {
        BookQryParam qryParam = new BookQryParam();
        qryParam.setAuthor(StringUtils.defaultString(request.getParameter("author")));
        qryParam.setName(StringUtils.defaultString(request.getParameter("bookName")));
        logger.info("检索书籍的参数值：【{}】", qryParam);
        List<Book> bookList = studyService.getBookList(qryParam);
        logger.info("检索书籍的返回值：【{}】", bookList);
        return new JsonResult<>(bookList);
    }
}
