package com.sys.dao;


import com.sys.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Demo1 {

    private static String driver="com.mysql.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/test";
    private static String userName="root";
    private static String password="root";
    public static void main(String[] args) {
        List<User> list = list();
        for (User u : list) {
            System.out.println(u);
        }
    }

    public static List<User> list(){
        List<User> result = new ArrayList<>();
        String sql = "select * from jdbc";
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接 java连接mysql
            Connection conn = DriverManager.getConnection(url,userName,password);
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            User user = null;
            while (rs.next()){
                user = new User();
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String sex = rs.getString("sex");
                String createTime = rs.getString("create_time");
                String delFlag = rs.getString("del_flag");
                user.setId(Long.valueOf(id));
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setCreateTime(createTime);
                user.setDelFlag(delFlag);
                result.add(user);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
