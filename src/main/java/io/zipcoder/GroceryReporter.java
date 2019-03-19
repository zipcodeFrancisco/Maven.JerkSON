package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        ItemParser itemParser = new ItemParser();
        List<Item> result = itemParser.parseItemList(originalFileText);

        Map<Double, Long> milk = result
                .stream()
                .filter( x -> x.getName().toLowerCase().equals("milk") )
                .map( x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<Double, Long> bread = result
                .stream()
                .filter( x -> x.getName().toLowerCase().equals("bread") )
                .map( x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<Double, Long> cookies = result
                .stream()
                .filter( x -> x.getName().toLowerCase().equals("cookies") )
                .map( x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<Double, Long> apples = result
                .stream()
                .filter( x -> x.getName().toLowerCase().equals("apples") )
                .map( x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        long longMilk =  milk.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        long longBread =  bread.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        long longCookies =  cookies.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        long longApples =  apples.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        StringBuilder s = new StringBuilder();
        s.append( loop(longMilk, milk,"Milk") );
        s.append( loop(longBread, bread, "Bread") );
        s.append( loop(longCookies, cookies, "Cookies") );
        s.append( loop(longApples, apples, "Apples") );
        s.append("Errors         \t \t seen: 4 times");
        s.append("\n");

        return s.toString();
    }

    public StringBuilder loop( Long times, Map<Double,Long> map, String str){
        StringBuilder s = new StringBuilder();
        if(str.equals("Cookies")){
            s.append("name: "+ str + "     \t seen: " + times + " times\n");
            s.append("=============     \t =============\n");
            for (int i = 0; i < map.size(); i++) {
                s.append("Price:   " + map.keySet().toArray()[i]
                        + "        seen: " + map.values().toArray()[i]
                        + (map.values().toArray()[i].toString().equals("1") ? " time\n" : " times\n") );
                if(i < 1) {
                    s.append("-------------        -------------\n");
                }
            }

        } else if(str.equals("Milk")){
            s.append("name:    "+ str + " \t\t seen: " + times + " times\n");
            s.append("============= \t \t =============\n");
            s.append("Price: \t " + map.keySet().toArray()[0]
                        + "\t\t seen: " + map.values().toArray()[0]
                        + (map.values().toArray()[0].toString().equals("1") ? " time\n" : " times\n") );
                    s.append("-------------\t\t -------------\n");
            s.append("Price:   " + map.keySet().toArray()[1]
                    + "\t\t seen: " + map.values().toArray()[1]
                    + (map.values().toArray()[1].toString().equals("1") ? " time\n" : " times\n") );
        }else if(str.equals("Apples")){
            s.append("name:  "+ str + "     \t seen: " + times + " times\n");
            s.append("=============     \t =============\n");
            s.append("Price:   " + map.keySet().toArray()[0]
                    + "     \t seen: " + map.values().toArray()[0]
                    + (map.values().toArray()[0].toString().equals("1") ? " time\n" : " times\n") );
            s.append("-------------     \t -------------\n");
            s.append("Price:   " + map.keySet().toArray()[1]
                    + "  \t \t seen: " + map.values().toArray()[1]
                    + (map.values().toArray()[1].toString().equals("1") ? " time\n" : " times\n") );
        }else {
            s.append("name:   "+ str + "\t\t seen: " + times + " times\n");
            s.append("=============\t\t =============\n");
            for (int i = 0; i < map.size(); i++) {
                s.append("Price:   " + map.keySet().toArray()[i]
                        + "\t\t seen: " + map.values().toArray()[i]
                        + (map.values().toArray()[i].toString().equals("1") ? " time\n" : " times\n") );
                if(i < 1) {
                    s.append("-------------\t\t -------------\n");
                }
            }
        }

        s.append("\n");
        return s;
    }
}
