package com.example.vidyaapiwar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class repository {
    HashMap<Integer,Appointment> db = new HashMap<>();
    HashMap<Integer,doctor> doc_db = new HashMap<>();
    HashMap<Integer,List<doctor>> doctohosdb = new HashMap<>();

    HashMap<Integer,Hospital> hos_db = new HashMap<>();


    public String book_appointment(Appointment appointment)
    {
        int app_id = appointment.getAppointment_id();
        db.put(app_id,appointment);

        return "doc with "+appointment.getDocid()+"added to database";
    }
    public String add_doctor(doctor doc)
    {
        doc_db.put(doc.getDocid(),doc);
        return "doc with "+doc.getDocid()+" is added";
    }
    public String add_hospital(Hospital hos)
    {
        int hos_id = hos.getHos_id();
        hos_db.put(hos_id,hos);
        return "hos details added";
    }
    public int get_female_doc()
    {
        int count=0;
        for(doctor doc:doc_db.values())
        {
            String gender = doc.getGender();
            if(gender.equals("female"))
            {
                count++;
            }
        }
        return count;
    }
    public List<String > get_age_doc()
    {
        List<String> names = new ArrayList<>();
        for(doctor doc:doc_db.values())
        {
            if(doc.getGender().equals("male") && doc.getDoc_age()>40)
            {
                names.add(doc.getDoc_name());
            }
        }
        return names;
    }
    public String associate_docandhos(int doc,int hos)
    {

        doctor doctor_ = doc_db.get(doc);
        List<doctor> temp =   doctohosdb.getOrDefault(hos,new ArrayList<>());
        temp.add(doctor_);
        doctohosdb.put(hos,temp);
        return "associated";
    }
    public String  get_highest_hos()
    {

        int count=0;
        int max=0;
        int hos_id=0;
        for(int key:doctohosdb.keySet())
        {
            List<doctor> temp = doctohosdb.get(key);
            count = temp.size();
            if(max<count)
            {
                max = count;
                hos_id = key;
            }
        }
        Hospital hos_= hos_db.get(hos_id);
        return hos_.getHos_name();
    }
}
