package com.example.vidyaapiwar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    public service ser;



    @PostMapping("/bookanappointment")
    public ResponseEntity<String> book_appointment(@RequestBody Appointment appointment)
    {
        //service ser = new service();
        String ans = ser.book_appointment(appointment);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
    @PostMapping("/adddoctors")
    public ResponseEntity<String> adddoctors(@RequestBody doctor doc)
    {
        String ans = ser.add_doctors(doc);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @PostMapping("/addhospital")
    public String add_hos(@RequestBody Hospital hos)
    {
        String ans= ser.add_hos(hos);
        return ans;
    }
    @GetMapping("/get_female_doc")
    public int get_female_doc()
    {
        int ans = ser.get_female_doc();
        return ans;
    }
    @GetMapping("/Getage")
    public List<String> get_age_doc()
    {
        List<String> ans = ser.get_age_doc();
        return ans;
    }
    @PostMapping("/associatedoc_with_hos")
    public ResponseEntity<String> ass_doc_to_hos(@RequestParam("id1") int id1,@RequestParam("id2") int id2)
    {
        String ans = ser.ass_doc_to_hos(id1,id2);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @GetMapping("/gethighest")
    public ResponseEntity<String> get_highest()
    {
        String ans = ser.get_high();
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }


}
