package org.spring.springboot.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by xli on 2017/5/19.
 */
@Component
public class User implements Serializable{
    private static final long serialVersionUID = -1L;

    private Long id;
    private String userName;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
