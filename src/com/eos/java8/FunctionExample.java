package com.eos.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Function<T,R> is an functional interface which is used to convert input type T to result R
 */
public class FunctionExample {

    public static void main(String args[]) {
        List<Employee> employees = getEmployees();
        //It will convert employee type to String name
        Function<Employee, String> employeeToNameFunction = employee -> employee.name;

        //It will will convert String name to first character
        Function<String, Character> nameToFirstCharFunction = name -> name.charAt(0);

        //It will convert first char to capital
        Function<Character, Character> convertToCapitalFunction = firstLetter -> (char) (firstLetter - 32);

        //It will use above converters to get final Result using andThen method and convert Employee type to Capital char for name' first character.
        Function<Employee,Character> finalConverter = employeeToNameFunction.andThen(nameToFirstCharFunction).andThen(convertToCapitalFunction);
        List<Character> result = convertEmployeeData(employees, finalConverter);
        print(result);
    }

    private static void print(List<Character> result) {
        result.forEach(System.out::print);
    }

    private static List<Character> convertEmployeeData(List<Employee> employees, Function<Employee, Character> converter) {
        List<Character> result = new ArrayList<>();
        employees.forEach(employee -> result.add(converter.apply(employee)));
        return result;
    }

    private static List<Employee> getEmployees() {
        return Arrays.asList(new Employee("john"), new Employee("tom"));
    }

}

class Employee {

    public String name;

    public Employee(String name) {
        this.name = name;
    }
}
