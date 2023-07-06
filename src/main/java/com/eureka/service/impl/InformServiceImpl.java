package com.eureka.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eureka.dao.InformDao;
import com.eureka.domain.Book;
import com.eureka.domain.Inform;
import com.eureka.service.InformService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformServiceImpl extends ServiceImpl<InformDao, Inform> implements InformService {
    @Override
    public IPage<Inform> getPage(Integer page, Integer size) {
        return baseMapper.selectPage(new Page(page, size), null);
    }

    @Override
    public IPage<Inform> getPage(Integer page, Integer size, Inform inform) {
        LambdaQueryWrapper<Inform> queryWrapper = new LambdaQueryWrapper<>();
        if(inform.getId()!=null){
            queryWrapper.eq(Inform::getId,inform.getId());
        }
        queryWrapper.like(Strings.isNotEmpty(inform.getLeader()),Inform::getLeader,inform.getLeader());
        queryWrapper.like(Strings.isNotEmpty(inform.getWantedHead()),Inform::getWantedHead,inform.getWantedHead());
        return baseMapper.selectPage(new Page(page, size),queryWrapper);
    }

    @Override
    public List<Inform> getByType(String type) {
        LambdaQueryWrapper<Inform> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Inform::getType,type);
        return baseMapper.selectList(queryWrapper);
    }
}
