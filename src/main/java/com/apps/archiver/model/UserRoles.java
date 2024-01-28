package com.apps.archiver.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class UserRoles implements Serializable {
    @Serial
    private static final long serialVersionUID = -627389992L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private long roleId;

    public UserRoles() {
    }

    public UserRoles(User user, long roleId) {
        this.user = user;
        this.roleId = roleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoles userRoles = (UserRoles) o;
        return id == userRoles.id && roleId == userRoles.roleId && Objects.equals(user, userRoles.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, roleId);
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", user=" + user +
                ", roleId=" + roleId +
                '}';
    }
}
