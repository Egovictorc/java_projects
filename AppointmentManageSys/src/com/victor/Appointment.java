package com.victor;

import java.time.LocalDate;

public class Appointment {
    String position;
    LocalDate appointmentDate;
    double salary;

    public Appointment(String position, LocalDate appointmentDate, double salary) {
        this.position = position;
        this.appointmentDate = appointmentDate;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "position= '" + position + '\'' +
                ", appointmentDate= " + appointmentDate +
                ", salary= $" + salary +
                '}';
    }
}
