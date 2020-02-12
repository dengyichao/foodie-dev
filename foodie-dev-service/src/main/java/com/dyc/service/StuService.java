package com.dyc.service;

import com.dyc.pojo.Stu;


public interface StuService {
    public Stu getStuInfo(int id);
    public void save();
    public void updateStu(int id);
    public void deleteStu(int id);

    public void saveParent();
    public void saveChildren();
}
