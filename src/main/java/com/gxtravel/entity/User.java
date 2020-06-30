package com.gxtravel.entity;
import java.util.Date;

public class User {
	 /*`userid` varchar(32) NOT NULL,
	  `username` varchar(20) DEFAULT NULL,
	  `password` varchar(20) DEFAULT NULL,
	  `name` varchar(20) DEFAULT NULL,
	  `email` varchar(30) DEFAULT NULL,
	  `telephone` varchar(20) DEFAULT NULL,
	  `birthday` date DEFAULT NULL,
	  `sex` varchar(10) DEFAULT NULL,
	  `state` int(11) DEFAULT NULL,
	  `code` varchar(64) DEFAULT NULL,*/
        private Integer userid;
        private String username;
        private String password;
        private String name;
        private String email;
        private String telephone;
        private Date birthday;
        private String sex;
        private int state;//是否激活
        private String code;//激活码

        private double similarity;


    public User() {
    }

    public User(Integer userid, String username, String password, String name, String email, String telephone, Date birthday, String sex, int state, String code) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.birthday = birthday;
        this.sex = sex;
        this.state = state;
        this.code = code;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public double getSimilarity() {
        return similarity;
    }
}