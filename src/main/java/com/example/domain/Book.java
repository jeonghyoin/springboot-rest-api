package com.example.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name="book")
@Getter
@Entity
public class Book{
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name="user_id")
    private Integer userId;
    
    @Column
    private String title;

    @Column
    private LocalDateTime publisedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt){
        this.title = title;
        this.publisedAt = publishedAt;
    }
}