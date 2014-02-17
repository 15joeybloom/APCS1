/**
 * @author Joey Bloom
 * Assignment #23
 * User enters exchange rates for Euro, Yen,
 * Peso, Pound, and Rupee, and then can convert
 * any dollar amount to any one of those currencies.
 * Conversion is displayed rounded to two decimal places.
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CurrencyConverter
{
    public static void main(String[] args)
    {
        Object[] currencies = {"Euro", "Yen", "Peso", "Pound", "Rupee", "Convert!"};
        ArrayList<Double> xchRates = new ArrayList<Double>(5);
        String input = "";
        for(int i = 0; i<5; i++) xchRates.add(0.0);
        while(true)
        {
            try
            {
                int selection = JOptionPane.showOptionDialog(null,
                    "Exchange Rates: " +
                    "\nEuro: " + xchRates.get(0) +
                    "\nYen: " + xchRates.get(1) +
                    "\nPeso: " + xchRates.get(2) +
                    "\nPound: " + xchRates.get(3) +
                    "\nRupee: " + xchRates.get(4) +
                    "\nSelect a currency to enter the exchange " + 
                    "rate \nfor " + 
                    "or select Convert! to move on.",
                    "Exchange rate",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    currencies,
                    null);
                    if(selection == 5) break;
                double xchRate = Double.parseDouble(
                    JOptionPane.showInputDialog(
                    null,
                    "How many " + currencies[selection] + 
                    " are equal to 1 dollar?"));
                xchRates.set(selection, xchRate);
            }
            catch(ArrayIndexOutOfBoundsException e){input = null; break;}
            catch(NullPointerException e){input = null; break;}
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, 
                    "Bad Input!", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
        String result = "";
        while(input != null)
        {
            try
            {
                input = JOptionPane.showInputDialog(
                        null, result +
                        "\nHow many dollars would you like to convert?");
                double value = Double.parseDouble(input);
                Object[] cheese =
                    {currencies[0],
                     currencies[1],
                     currencies[2],
                     currencies[3],
                     currencies[4]};
                int selection = JOptionPane.showOptionDialog(null, 
                    "Convert $" + Math.round(value * 100) / 100.0 + " to:",
                    "Convert:",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    cheese,
                    null);
                double convertedValue = 
                    Math.round( value * xchRates.get(selection) * 100 ) / 100.0;
                result = "$" + value + " = " + 
                         convertedValue + " " + currencies[selection];
            }
            catch(ArrayIndexOutOfBoundsException e){break;}
            catch(NullPointerException e){break;}
            catch(NumberFormatException e)
            {
                if(e.getLocalizedMessage().equals("empty String")){break;}
                else
                {
                    JOptionPane.showMessageDialog(null, 
                        "Bad Input!", "Error", JOptionPane.ERROR_MESSAGE);
                    result = "";
                    input = "0";
                    continue;                
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Have a nice day!");
    }
}