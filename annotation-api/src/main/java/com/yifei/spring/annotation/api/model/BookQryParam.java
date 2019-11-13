package com.yifei.spring.annotation.api.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author yifei
 * @date 2019/11/13
 */
@Data
@ToString
public class BookQryParam extends SerializableBase {
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
}
