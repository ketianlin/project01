package top.ke1205.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Date;

public class User {
    private String userName;
    @JsonIgnore // 对象序列化为json时，忽略该字段
    private String password;
    private Integer age;
    private Double salary;
    private Boolean isMarry;
    private String[] interests;
    private String name;
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd") // 格式化输出的json字段
    private Date birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarry() {
        return isMarry;
    }

    public void setMarry(Boolean marry) {
        isMarry = marry;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", isMarry=" + isMarry +
                ", interests=" + Arrays.toString(interests) +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }

    public User() {
    }

    public User(String userName, String password, Integer age, Double salary, Boolean isMarry, String[] interests, String name, Long id, Date birthday) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.isMarry = isMarry;
        this.interests = interests;
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }
}
