package com.dyc.service.center;

import com.dyc.pojo.Users;
import com.dyc.pojo.bo.center.CenterUserBO;

public interface CenterUserService {
    /***
     * 方法描述 根据用户id查询用户信息
     * @param userId
     * @return com.dyc.pojo.Users
     * @author dengyichao
     * @date 2020/2/16
     */
    public Users queryUserInfo(String userId);

    /***
     * 方法描述 修改用户信息
     * @param userId
     * @param centerUserBO
     * @return com.dyc.pojo.Users
     * @author dengyichao
     * @date 2020/2/16
     */
    public Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /***
     * 方法描述 用户头像更新
     * @param userId
     * @param faceUrl
     * @return com.dyc.pojo.Users
     * @author dengyichao
     * @date 2020/2/21
     */
    public Users updateUserFace(String userId, String faceUrl);
}
