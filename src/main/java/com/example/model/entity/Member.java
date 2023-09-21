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
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    protected int id;

    @Column(name = "firstName")
    protected String firstName;

    @Column(name = "lastName")
    protected String lastName;

    @NotNull
    @Column(name = "userName", unique = true)
    protected String userName;

    @NotNull
    @Column(name = "password")
    protected String password;

    @Column(name = "phone", unique = true)
    protected String phone;

    @Column(name = "email")
    protected String email;

    @Column(name = "description")
    protected String description;

    @CreationTimestamp
    @Column
    protected Date createDate;

    @UpdateTimestamp
    @Column
    protected Date updateDate;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Content> contentList;

}
