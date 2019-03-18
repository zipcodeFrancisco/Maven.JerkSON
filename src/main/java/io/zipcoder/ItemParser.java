package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser<SomeType> {
    public List<Item> parseItemList(String valueToParse) {

        System.out.println(valueToParse);
        System.out.println("----");
        System.out.println(spliterObjects(valueToParse));

        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String cleanLine = changeOneWord("(##)", "", singleItem);
        String splitLine = changeOneWord("(;)", " ", cleanLine);
        String[] arrayLine = splitLine.split(" ");
        arrayLine = keyValueColon(arrayLine);

        Pair[] pairs = arrayToPairs(arrayLine);

        Item item = new Item(pairs[0].getSecond().toString().toLowerCase(),
                Double.parseDouble((String) pairs[1].getSecond()),
                pairs[2].getSecond().toString().toLowerCase(),
                (String) pairs[3].getSecond());

        return item;
    }
    public Pair[] arrayToPairs(String[] arrayToTrans){
        Pair[] pairs = new Pair[arrayToTrans.length];
        for (int i = 0; i < arrayToTrans.length; i++) {
            pairs[i] = keyValueToPair(arrayToTrans[i]);
        }
        return pairs;
    }

    public <E> Pair keyValueToPair(String stringKV){
        E[] e = (E[]) stringKV.split(":");
        Pair<Object> pair = new Pair<Object>(e[0].toString(),e[1]);
        return pair;
    }

    public String spliterObjects(String source){
        return changeOneWord("(##)","\n", source);
    }

    public String[] keyValueColon(String[] oneItem){
        String[] result = new String[oneItem.length];
        int count = 0;
        for (String s : oneItem) {
            result[count] = changeOneWord("(:|@|\\^|\\*|%)",":",s);
            count++;
        }
        return result;
    }

    public String changeOneWord(String wordSource, String wordDestiny, String textSource){

        String patternString = wordSource;

        Pattern pattern = Pattern
                .compile(patternString);
        Matcher matcher = pattern
                .matcher(textSource);

        return matcher
                .replaceAll(wordDestiny);
    }



}
