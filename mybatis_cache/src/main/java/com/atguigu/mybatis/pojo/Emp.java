package com.atguigu.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emp  implements Serializable {
    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    public Emp(){}

    public Emp(Integer empId, String empName, Integer age, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }
}
