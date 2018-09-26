package com.yishu.server.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookPO {


    private Long id;

    private String description;

    private String downloadLink;

    private String category;

    private String title;

    private String author;

    private String rate;


}