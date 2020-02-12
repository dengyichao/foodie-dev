package com.dyc.service;

import com.dyc.pojo.Stu;
import com.dyc.pojo.Users;
import com.dyc.pojo.bo.UserBO;


public interface UserService {
    /**
     * 返回用户名是否存在
     */
    public boolean queryUsernameIsExist(String username);
    public Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登陆
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username,String password);
}
