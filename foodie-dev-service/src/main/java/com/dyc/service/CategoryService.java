package com.dyc.service;

import com.dyc.pojo.Category;
import com.dyc.pojo.vo.CategoryVO;
import com.dyc.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {
    /**
     * 查询一级分类
     * @return
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类ID查询子分类信息
     * @param rootCatId
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootId
     * @return
     */
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootId);
}
