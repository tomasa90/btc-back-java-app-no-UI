import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String firstCurrency = null;
        String amount = null;
        String secondCurrency = null;
        double selectedRate = 0;
        double outputRate = 0;
        String currency = null;
        String selectedCurrency = null;
        String currencyToConvertTo = null;



        Scanner key =new Scanner(System.in);

        do{
            System.out.println("enter the amount you want to convert");
            amount = key.next();
        } while (!amount.matches("\\d+(\\.\\d+)?") );
        double number = Double.parseDouble(amount);
        System.out.println(number);


        do {
            System.out.println("enter the currency for the amount you have just chosen - EUR , USD, GBP, BTC, ETH, FKE ");
            firstCurrency = key.next().toUpperCase();
        } while (!firstCurrency.equals("EUR") && !firstCurrency.equals("USD") && !firstCurrency.equals("GBP") &&
                !firstCurrency.equals("BTC") && !firstCurrency.equals("ETH") && !firstCurrency.equals("FKE"));


        do {
            System.out.println("enter the currency you want to convert to - EUR , USD, GBP, BTC, ETH, FKE ");
            do {
                System.out.println("Please select a different currency");
                secondCurrency = key.next().toUpperCase();
            }while (firstCurrency.equals(secondCurrency));
            } while (!secondCurrency.equals("EUR") && !secondCurrency.equals("USD") && !secondCurrency.equals("GBP") &&
                !secondCurrency.equals("BTC") && !secondCurrency.equals("ETH") && !secondCurrency.equals("FKE"));




        String currencyFile = "31708.csv";
        File file = new File(currencyFile);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String data = scanner.next();
                String[] array = data.split(",");
                double price = Double.parseDouble(array[1]);

//                //"All of the data in the csv: "
//                System.out.println(data);

                if(array[0].equals(firstCurrency)) {
                    currency = array[0];
                    selectedRate=Double.parseDouble(array[1]);
                }
                if(array[0].equals(secondCurrency)) {
                    currencyToConvertTo=array[0];
                outputRate=Double.parseDouble(array[1]);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("the selected currency was " + currency + " and its rate is  " + selectedRate);
        System.out.println("the output currency is "+ currencyToConvertTo+" it's value is " +outputRate);
        System.out.println(number +" "+ currency +" -> "+currencyToConvertTo+" = "+ (selectedRate/outputRate)*2 +" "+currencyToConvertTo);





    }
}
