package com.hendisantika.springbootrestfulwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-14
 * Time: 08:30
 */
@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
}
