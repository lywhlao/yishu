package com.yishu.server.model.po;

import lombok.Data;

@Data
public class BookPO {


    private Long id;

    private String desc;

    private String downloadLink;

    private String category;

    private String title;

    private String author;

    private String rate;


}