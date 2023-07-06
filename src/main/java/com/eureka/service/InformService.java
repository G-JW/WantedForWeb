package com.eureka.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eureka.domain.Book;
import com.eureka.domain.Inform;
import com.eureka.domain.User;

import java.util.List;

public interface InformService extends IService<Inform> {
    IPage<Inform> getPage(Integer page, Integer size);

    IPage<Inform> getPage(Integer page, Integer size, Inform inform);

    List<Inform> getByType(String type);

}
