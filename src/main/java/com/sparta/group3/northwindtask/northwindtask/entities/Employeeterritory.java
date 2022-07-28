package com.sparta.group3.northwindtask.northwindtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "employeeterritories")
public class Employeeterritory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private EmployeeterritoryId id;

    @MapsId("employeeID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employeeID;

    public EmployeeterritoryId getId() {
        return id;
    }

    public void setId(EmployeeterritoryId id) {
        this.id = id;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

}