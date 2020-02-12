package com.dyc.service;

import com.dyc.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    /**
     * 获取轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
