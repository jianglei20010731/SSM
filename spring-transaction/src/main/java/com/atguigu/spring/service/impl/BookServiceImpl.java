package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    @Transactional(
//            readOnly = true
//            timeout = 3 //超时时间3秒，没有执行成功强制回滚
//            noRollbackFor = ArithmeticException.class
//            isolation = Isolation.DEFAULT
            propagation = Propagation.REQUIRES_NEW
    )
    public void buyBook(Integer userId, Integer bookId) {
//        try {
//            TimeUnit.SECONDS,sleep(timeout);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        //查询图书的价格
        Integer price=bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalabce(userId,price);
//        System.out.println(1/0);
    }
}
