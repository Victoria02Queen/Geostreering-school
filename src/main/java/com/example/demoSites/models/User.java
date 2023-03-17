package com.example.demoSites.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String position;
    private String organization;
    private String login;
    private String password;
    private String phone;
    private String email;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Training> trainingList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "completed_training",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "training_id") }
    )
    private Set<Training> completedTrainings;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "active_training",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "training_id") }
    )
    private Set<Training> activeTraining;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Training> getCompletedTrainings() {
        return completedTrainings;
    }

    public void setCompletedTrainings(Set<Training> completedTrainings) {
        this.completedTrainings = completedTrainings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public Set<Training> getActiveTraining() {
        return activeTraining;
    }

    public void setActiveTraining(Set<Training> activeTraining) {
        this.activeTraining = activeTraining;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", organization='" + organization + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", completedTrainings=" + completedTrainings +
                ", activeTraining=" + activeTraining +
                '}';
    }
}
