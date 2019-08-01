package com.example.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
@Getter
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(length=50, nullable= false)
    private String name;

    /* 한 명의 유저는 다수의 책을 가질 수 있다. */
    /* name 속성에는 매핑 할 외래 키 이름 지정 */
    @OneToMany
    @JoinColumn(name="user_id")
    private Collection<Book> book;

    @Builder
    public User(String name) {
        this.name = name;
    }
}