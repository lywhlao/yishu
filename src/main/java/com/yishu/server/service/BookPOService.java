package com.yishu.server.service;

import com.yishu.server.model.po.BookPO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.yishu.server.dao.BookPODao;

@Service
public class BookPOService{

    @Resource
    private BookPODao bookPODao;

    public int insert(BookPO pojo){
        return bookPODao.insert(pojo);
    }

    public int insertSelective(BookPO pojo){
        return bookPODao.insertSelective(pojo);
    }

    public int insertList(List<BookPO> pojos){
        return bookPODao.insertList(pojos);
    }

    public int update(BookPO pojo){
        return bookPODao.update(pojo);
    }
}
