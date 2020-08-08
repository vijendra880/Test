package com.eos.sorting;

import static jdk.nashorn.internal.objects.Global.print;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * https://www.baeldung.com/java-sorting-arrays
 */
public class javaSorting {

    public static void main(String args[]) {
        Data[] datas = new Data[4];

        Data d1 = new Data(1, "rakesh");
        Data d2 = new Data(6, "vijendra");
        Data d3 = new Data(4, "zack");
        Data d4 = new Data(7, "abhishek");
        datas[0] = d1;
        datas[1] = d2;
        datas[2] = d3;
        datas[3] = d4;
        //sort1(datas);
        //sort2(datas);
        sort3(datas);
        print(datas);


    }

    private static void sort3(Data[] datas) {
        Arrays.sort(datas, (d1, d2) -> {
            return d1.id - d2.id;
        });
    }

    private static void sort2(Data[] datas) {
        Arrays.sort(datas, new CustomCompartator());
    }

    private static void sort1(Data[] datas) {
        Arrays.sort(datas, new Comparator<Data>() {
            public int compare(Data d1, Data d2) {
                return d1.id - d2.id;
            }
        });

        Arrays.sort(datas, Comparator.comparing(Data::getId));
    }

    private static void print(Data[] datas) {
        for (Data data : datas) {
            System.out.println(data.id);
        }
    }


}

class Data {

    int id;
    String name;

    public Data(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class CustomCompartator implements Comparator<Data> {

    public int compare(Data d1, Data d2) {
        return d1.id - d2.id;
    }

}
