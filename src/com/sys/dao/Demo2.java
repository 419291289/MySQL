package com.sys.dao;


import com.sys.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Demo2 {
    private static JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public static void main(String[] args) {
//
        //增
//        User u1 = new User();
//        u1.setName("小王");
//        u1.setAge(22);
//        u1.setSex("男");
//        u1.setCreateTime(null);
//        addUser(u1);

//        //查
//        new Demo2().ListUser(4).stream().forEach(n->{
//            System.out.println(n);
//        });

//        //删
//        idDelete(Long.valueOf(6));
//
//        //改
//        update(Long.valueOf(5),"age","55");

    }

    //查
    public List<User> ListUser(Integer a){
        String sql="select * from jdbc where id limit "+a+",2 ";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    //增
    public static void addUser(User user){
        String sql = "insert into jdbc(name,age,sex,create_time) values( ?,?,?,?)";
        template.update(sql,user.getName(),user.getAge(),user.getSex(),user.getCreateTime());
    }

    //删
    public static void idDelete(Long id){
        String sql = "delete from jdbc where id=?";
        template.update(sql,id);
    }

    //改
    public static void update(Long id,String a,String b){
        String sql = "UPDATE jdbc SET "+a+" = "+b+" WHERE id = ?";
        template.update(sql,id);
    }

}
