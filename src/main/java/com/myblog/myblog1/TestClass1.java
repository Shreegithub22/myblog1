package com.myblog.myblog1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;




public class TestClass1 {

    public static void main(String[] args) {

      //PREDICATE FUNCTIONAL INTERFACE
//        Predicate<Integer> val= x->x%2==0;
//        boolean result = val.test(10);
//        System.out.println(result);

//        Predicate val=str->str.equals("mike");
//        boolean result = val.test("sri");
//        System.out.println(result);

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<Integer> evennums = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//        System.out.println(evennums);

//        List<String> list = Arrays.asList("ma","aa","ka");
//        List<String> res = list.stream().filter(x -> x.startsWith("m")).collect(Collectors.toList());
//        System.out.println(res);



        //FUNCTION FUNCTIONAL INTERFACE
//        Function<String,Integer> val= str->str.length();
//        Integer result = val.apply("mike");
//        System.out.println(result);

//        Function<Integer,Integer> val= i->i+20;
//        Integer result = val.apply(1);
//        System.out.println(result);

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<Integer> newNumbers = list.stream().map(i -> i + 20).collect(Collectors.toList());
//        System.out.println(newNumbers);

//        List<String> list = Arrays.asList("ma","aa","ka");
//        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        //SORTING
//        List<String> list = Arrays.asList("ma","aa","ka");
//        list.stream().sorted().forEach(System.out::println);
//
//        List<Integer> list1 = Arrays.asList(2,5,1,3,8,4,9);
//        list1.stream().sorted().forEach(System.out::println);

        //NON-DUPLICATE NUMBERS
//        List<Integer> list2 = Arrays.asList(2,5,1,3,8,4,9,9,1,2,3);
//        list2.stream().distinct().forEach(System.out::println);

        //CONSUMER FUNCTIONAL INTERFACE
//         Consumer<Integer> val= num->System.out.println(num);
//         val.accept(100);

//        List<String> list = Arrays.asList("ma","aa","ka");
//        list.forEach(name->System.out.print(name+" "));
                //OR
//        Consumer<String> val= name->System.out.println(name+"");
//        list.forEach(val);


        //SUPPLIER FUNCTIONAL INTERFACE
//        Supplier<Integer> val= ()->new Random().nextInt(50);
//        Integer result = val.get();
//        System.out.println(result);


    }
}
