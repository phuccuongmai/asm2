package com.example.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contents")
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @NotNull
    @Column(name = "title")
    protected String title;

    @NotNull
    @Column(name = "brief")
    protected String brief;

    @NotNull
    @Column(name = "content")
    protected String content;

    @Column(name = "sort")
    protected String sort;

    @Column(name = "authorId")
    protected int authorId;

    @CreationTimestamp
    @Column(name = "createDate")
    protected Date createDate;

    @UpdateTimestamp
    @Column(name = "updateDate")
    protected Date updateDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    protected Member member;
}
