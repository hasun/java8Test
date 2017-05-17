/**
 * Created by hasun on 17. 5. 14.
 */

import javax.sql.rowset.spi.TransactionalWriter;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    public static void main (String args[]) {
       List <Transaction> transactions = new ArrayList<>();
       Transaction test = new Transaction();
       Currency won = new Currency("won");
       Currency doller = new Currency("doller");

       test.setPrice(500);
       test.setCurrency(won);
       transactions.add(test);

       test = new Transaction();
       test.setPrice(100);
       test.setCurrency(doller);
       transactions.add(test);
       test = new Transaction();
       test.setPrice(100);
       test.setCurrency(won);
       transactions.add(test);

       test = new Transaction();
       test.setPrice(500);
       test.setCurrency(doller);
       transactions.add(test);

       Map<Currency, List<Transaction>> transactionByCurrencies
               = transactions.stream()
               .filter((Transaction t) -> t.getPrice() > 100)
               .collect(groupingBy(Transaction::getCurrency));
       for (Map.Entry<Currency, List<Transaction>> one : transactionByCurrencies.entrySet()) {
           System.out.println ("=======================");
           System.out.println ("key ::"+one.getKey());
           System.out.println ("=======================");
           System.out.println ("value ::"+one.getValue());
           System.out.println ("=======================");

       }


    }

    static class Transaction {

        public Transaction() {

        };

        int price;
        Currency currency ;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "price ::" + price + "  Currency" + currency;
        }
    }

    static class Currency {
        public Currency(String unit) {
            this.unit = unit;
        };

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }


        String unit;

        @Override
        public String toString() {
            return "unit ::" + unit;
        }
    }
}
