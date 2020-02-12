package com.dyc.mapper;

import com.dyc.my.mapper.MyMapper;
import com.dyc.pojo.Items;
import com.dyc.pojo.vo.ItemCommentVO;
import com.dyc.pojo.vo.SearchItemsVO;
import com.dyc.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom{
    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String,Object> map);

    public List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String,Object> map);

    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String,Object> map);

    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List<String> specIdsList);
}