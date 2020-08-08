package com.eos.java8;

import java.util.Optional;

public class OptionalExample {

    public static void main(String args[]) {

        Domain domain1 = null;
        Domain domain2 = new Domain();
        Optional<Domain> domainOptional1 = Optional.empty();
        boolean check = chekIfPresent(domainOptional1);
        //Optional<Domain> domainOptional2 = Optional.of(domain1); it will throw nullPointerException because domain1 is null;
        Optional<Domain> domainOptional3 = Optional.ofNullable(domain1);
        //Domain d1 = domainOptional1.get(); it will throw throw NoSuchElementExist error because domainOptional1 is empty
        String name = Optional.ofNullable(domain1).flatMap(d -> Optional.of(d.getName())).orElse("abc");
        String name1 = Optional.ofNullable(domain1).map(d -> d.getName()).orElse("abc");

        //String state = Optional.ofNullable(domain1).map(d->d.getAddress()).map(a->Opta.getCountry()).map(s->s.getState()).orElse("UP");
        //String state1  = Optional.ofNullable(domain1).map(d->d.getAddress()).flatMap(a->a.get)
        System.out.println(name);
    }

    private static boolean chekIfPresent(Optional<Domain> domainOptional1) {
        return !domainOptional1.isPresent();
    }

}
