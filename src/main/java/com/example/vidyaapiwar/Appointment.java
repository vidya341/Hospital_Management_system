package com.example.vidyaapiwar;

import java.time.LocalDateTime;

public class Appointment {


    private int appointment_id;
    private int docid;
    private int user_id;
    private String appointment_time;

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String  getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String  appointment_time) {
        this.appointment_time = appointment_time;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

}
