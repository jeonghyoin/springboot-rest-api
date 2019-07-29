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

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(length=50, nullable= false)
    private String name;

    /* 한 명의 유저는 다수의 책을 가질 수 있다. */
    @OneToMany
    @JoinColumn(name="user_id")
    private Collection<Book> book;

    @Builder
    public User(String name) {
        this.name = name;
    }
}