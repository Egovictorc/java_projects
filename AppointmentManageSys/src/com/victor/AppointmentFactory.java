package com.victor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppointmentFactory {
    List<Appointment> appointmentList = new ArrayList<>();

    public AppointmentFactory(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Appointment> sortByDate() {
        List<Appointment> appointments = appointmentList;
        Collections.sort(appointments, Comparator.comparing(Appointment::getAppointmentDate));
        return appointments;
    }

    public List<Appointment> sortBySalary() {
        List<Appointment> appointments = appointmentList;
        Collections.sort(appointments, Comparator.comparing(Appointment::getSalary));
        return appointments;
    }

    public List<Appointment> sortByPosition() {
        List<Appointment> appointments = appointmentList;
        Collections.sort(appointments, Comparator.comparing(Appointment::getPosition));
        return appointments;
    }

    public List<Appointment> filterBySalary(double salary) {
        List<Appointment> appointments = appointmentList;
        return appointments.stream().filter(appointment -> appointment.getSalary() > salary).toList();
    }

    public List<Appointment> filterByDate(LocalDate date) {
        List<Appointment> appointments = appointmentList;
        return appointments.stream().filter(appointment -> appointment.getAppointmentDate().isAfter(date)).toList();
    }

    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {

        this.appointmentList.remove(appointment);
    }


}
