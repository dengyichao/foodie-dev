package com.dyc.service;

import com.dyc.pojo.Carousel;
import com.dyc.pojo.UserAddress;
import com.dyc.pojo.bo.AddressBO;

import java.util.List;

/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/12
 * @version: 1.0
 */
public interface AddressService {

   /***
    * 方法描述 根据用户ID查询用户的收货地址列表
    * @param userId
    * @return java.util.List<com.dyc.pojo.UserAddress>
    * @author dengyichao
    * @date 2020/2/12
    */
    public List<UserAddress> queryAll(String userId);

    /***
     * 方法描述 用户新增地址
     * @param addressBO
     * @return void
     * @author dengyichao
     * @date 2020/2/12
     */
    public void addNewUserAddress(AddressBO addressBO);

    /***
     * 方法描述 用户修改地址
     * @param addressBO
     * @return void
     * @author dengyichao
     * @date 2020/2/12
     */
    public void updateUserAddress(AddressBO addressBO);

    /***
     * 方法描述 根据用户ID和地址ID，删除对应的用户地址信息
     * @param userId
     * @param addressId
     * @return void
     * @author dengyichao
     * @date 2020/2/12
     */
    public void deleteUserAddress(String userId, String addressId);

    /***
     * 方法描述 修改默认地址
     * @param userId
     * @param addressId
     * @return void
     * @author dengyichao
     * @date 2020/2/12
     */
    public void updateUserAddressToBeDefault(String userId, String addressId);
}
