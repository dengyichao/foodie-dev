package com.dyc.mapper;

import com.dyc.my.mapper.MyMapper;
import com.dyc.pojo.Category;
import com.dyc.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {
    public List<CategoryVO> getSubCatList(Integer rootCatId);
    public List getSixNewItemsLazy(@Param("paramsMap") Map<String,Object> map);
}