package com.myblog.myblog1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClass2 {
    public static void main(String[] args) {
        List<Employee> employees= Arrays.asList(
                new Employee("raj","mdu",25),
                new Employee("ash","mdu",24),
                new Employee("sri","kgiri",23),
                new Employee("suji","chn",30));


                   //age filter
//        List<Employee> result = employees.stream().filter(emp -> emp.getAge() >= 25).collect(Collectors.toList());
//        for(Employee res:result){
//            System.out.println(res.getName() +" from city "+res.getCity());


                  //filter starts with s
//            List<Employee> val= employees.stream().filter(emp->emp.getName().startsWith("s")).collect(Collectors.toList());
//            for(Employee r:val){
//                System.out.println(r.getName() +" of age "+r.getAge());}}

                 //even num squaring
//        List<Integer> num= Arrays.asList(1,2,3,4,5,6,7,8);
//        num.stream().filter(i->i%2==0).map(i->i*i).forEach(System.out::println);

                 //simple grouping concept
        Map<String, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        for(Map.Entry<String, List<Employee>> entries : result.entrySet()){
            String city = entries.getKey();
            List<Employee> values = entries.getValue();
            System.out.println(city +"-------->");
            for(Employee val:values){
                System.out.println(val.getName() +" of age "+val.getAge());
            }
        }




    }
    }

