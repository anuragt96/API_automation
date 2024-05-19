package org.example.CRUD.PUT;

import java.util.HashMap;
import java.util.Map;

public class HashmapDemoExample1 {

    public static void main(String[] args) {


        //    {
//        "bookingid": 1301,
//            "booking": {
//        "firstname": "Aman chaman",
//                "lastname": "Raja",
//                "totalprice": 4000,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2025-11-05",
//                    "checkout": "2026-12-01"
//        },
//        "additionalneeds": "Afternoon Meal"
//    }
//    }


        Map<String,Object> parent = new HashMap<>();
        parent.put("bookingid",1301);

        Map<String,Object> child1 = new HashMap<>();
        child1.put("firstname", "James");
        child1.put("lastname", "Brown");
        child1.put("totalprice", 111);
        child1.put("depositpaid", true);

        Map<String,Object> child2 = new HashMap<>();
        child2.put("checkin", "2018-01-01");
        child2.put("checkout", "2019-01-01");

        child1.put("bookingdates",child2);
        child1.put("additionalneeds","Breakfast");

        parent.put("booking", child1);
        System.out.println(parent);


    }
}
