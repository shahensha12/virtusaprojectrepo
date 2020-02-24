package org.virtusa.numbertowords.service;


import org.springframework.stereotype.Service;


@Service
public class NumberToWordServiceImpl implements NumberToWordService {

    @Override
    public String getNumberToWord(String numbs) {

        Integer number = Integer.parseInt(numbs);
            if (number == 0) {
                return "Number in words: Zero";
            } else if(number<0) {
            	return "Enter positive number";
            }else {
            	return "Number in words: " + numberToWord(number);
            }
            
     }

    private static String numberToWord(int number) {
        
        String words = "";
        String unitsArray[] = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String tensArray[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};

        if (number == 0) {
            return "zero";
        }
        
//        if (number < 0) { 
//            String numberStr = "" + number;
//           
//            numberStr = numberStr.substring(1);
//            
//            return "minus " + numberToWord(Integer.parseInt(numberStr));
//        }
        
        if ((number / 1000000) > 0) {
            words += numberToWord(number / 1000000) + " million ";
            number %= 1000000;
        }
        
        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }
        
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            
            if (number < 20) {
                
                words += unitsArray[number];
            } else {
                
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    words += "-" + unitsArray[number % 10];
                }
            }
        }

        return words;
    }
}

