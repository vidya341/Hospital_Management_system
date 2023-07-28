package com.example.vidyaapiwar;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service

public class service {
    @Autowired
    public repository res;

    public String book_appointment(Appointment appointment)
    {
        //repository rep = new repository();

        String ans = res.book_appointment(appointment);


        return ans;
    }
    public String add_doctors(doctor doc)
    {


        String ans = res.add_doctor(doc);
        return ans;
    }
    public String add_hos(Hospital hos)
    {
        String ans = res.add_hospital(hos);
        return ans;
    }
    public int get_female_doc()
    {
        int ans = res.get_female_doc();
        return ans;

    }
    public List<String > get_age_doc()
    {
        List<String> ans = res.get_age_doc();

        return ans;
    }
    public String ass_doc_to_hos(int id_doc,int id_hos)
    {
        String ans = res.associate_docandhos(id_doc,id_hos);
        return ans;
    }
    public String get_high()
    {
        String  name = res.get_highest_hos();
        return name;
    }
}
