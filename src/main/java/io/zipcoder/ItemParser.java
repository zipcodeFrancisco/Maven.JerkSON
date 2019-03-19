package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ItemParser {

    public int masterCounter = 1;

    public List<Item> parseItemList(String valueToParse) {
            List<Item> arrayList = new ArrayList<>();
            String[] splitText = valueToParse.split("##");
            for (int i = 0; i < splitText.length; i++) {
                try {
                    arrayList.add(parseSingleItem(splitText[i]));
                }
                catch (ItemParseException e)
                {
                    e.printStackTrace();
                }
            }
            return arrayList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
    try {
        String cleanLine = changeOneWord("(##)", "", singleItem);
        String splitLine = changeOneWord("(;|\\^|\\%|\\*|!|@)", " ", cleanLine);
        String[] arrayLine = splitLine.split(" ");
        arrayLine = keyValueColon(arrayLine);
        List<String[]> xx = Arrays.stream(arrayLine)
                .map(x -> {
                    String[] oo = x.split(":");
                    return new String[]{oo[0],oo[1]};
                } )
                .collect(Collectors.toList());

        Item item = new Item( xx.get(0)[1].replaceAll("0","o"), Double.parseDouble(xx.get(1)[1]),
                xx.get(2)[1], xx.get(3)[1] );
        masterCounter++;
        return item;
        }
        catch (Exception e){
        masterCounter++;
            throw new ItemParseException();
        }
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
        Pair<Object> pair = new Pair<>(e[0].toString(),e[1]);
        return pair;
    }


    public String[] keyValueColon(String[] oneItem){
        String[] result = new String[oneItem.length];
        int count = 0;
        for (String s : oneItem) {
            result[count] = changeOneWord("(:|@|\\^|\\*|\\%|!|;)",":",s);
//            result[count] = changeOneWord("[:|@|^|*|%]",":",s);
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

//        try {
//            List<Item> arrayList = new ArrayList<>();
//            String[] splitText = valueToParse.split("##");
//            for (int i = 0; i < splitText.length; i++) {
//
//                System.out.println( parseSingleItem(splitText[i]) instanceof Item );
////                if( parseSingleItem(splitText[i]) instanceof Item ){
//                    arrayList.add( parseSingleItem(splitText[i]) );
////                }
//            }
//            return arrayList;
//
//        } catch (ItemParseException e) {
//            e.printStackTrace();
//        }

}
