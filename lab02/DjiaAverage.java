/*
 * DjiaAverage.java
 * Copyright (C) 2018 Jecsan Blanco <jblancolicano1@buffs.wtamu.edu>
 *
 *   @author Jecsan Blanco
 *   @version 1.0
 *   @since  02/17/2018
 *
 * This program computes the Down Jones Average from
 * the stocks that contribute as decided by the editorial board of
 * the Wall Street Journal.
 */


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class DjiaAverage {
    private char [] ascii;
    private String url;

    
    DjiaAverage(){
        genAsciiTable();
    }
    public void  genAsciiTable(){
    	ascii = new char[128];
    	ascii[33] = '!';
    	ascii[34] = '"';
    	ascii[35]= '#';
    	ascii[36] ='$';
    	ascii[37] = '%';
    	ascii[38] = '&';
    	ascii[39]= '\'';
    	ascii[40]='(';
    	ascii[41]=')';
    	ascii[42] = '*';
    	ascii[43] = '+';
    	ascii[44] = ',';
    	ascii[45] = '-';
    	ascii[46] = '.';
    	ascii[47] = '/';
    	ascii[48] = '0';
    	ascii[49] = '1';
    	ascii[50] = '2';
    	ascii[51] = '3';
    	ascii[52] = '4';
    	ascii[53] = '5';
    	ascii[54] = '6';
    	ascii[55] = '7';
    	ascii[56] = '8'; 
    	ascii[57] = '9';
    	ascii[58] = ':';
    	ascii[59] = ';';
    	ascii[60] = '<';
    	ascii[61] = '=';
    	ascii[62] = '>';
    	ascii[63] = '?';
    	ascii[64] = '@';
    	ascii[65] = 'A';	  	  	 
    	ascii[66] = 'B';  	  	 
    	ascii[67] = 'C';
    	ascii[68] = 'D'; 	  	  	 
    	ascii[69] = 'E';	  	  	 
    	ascii[70] = 'F'; 	  	  	 
    	ascii[71] = 'G'; 	  	  	 
    	ascii[72] = 'H'; 	  	  	 
    	ascii[73] = 'I'; 	  	  	 
    	ascii[74] = 'J'; 	  	  	 
    	ascii[75] = 'K';
    	ascii[76] = 'L';
    	ascii[77] = 'M';
    	ascii[78] = 'N';
    	ascii[79] = 'O';
    	ascii[80] = 'P';
    	ascii[81] = 'Q';
    	ascii[82] = 'R';  	  	 
    	ascii[83] = 'S';	  	  	 
    	ascii[84] = 'T';	  	  	 
    	ascii[85] = 'U'; 	  	  	 
    	ascii[86] = 'V';	  	  	 
    	ascii[87] = 'W';	  	  	 
    	ascii[88] = 'X';	  	  	 
    	ascii[89] = 'Y';	  	  	 
    	ascii[90] = 'Z';	  	  	 
    	ascii[91] = '[';
    	ascii[92] = '\\';
    	ascii[93] = ']';
    	ascii[94] = '^';
    	ascii[95] = ';';
    	ascii[96] = '`';
    	ascii[97] = 'a';
    	ascii[98] = 'b';
    	ascii[99] = 'c';	  	  	 
    	ascii[100] = 'd';  	  	 
    	ascii[101] = 'e';	  	  	 
    	ascii[102] = 'f';	  	  	 
    	ascii[103] = 'g';	  	  	 
    	ascii[104] = 'h';	  	  	 
    	ascii[105] = 'i';	  	  	 
    	ascii[106] = 'j'; 	  	  	 
    	ascii[107] = 'k';
    	ascii[108] = 'l';
    	ascii[109] = 'm';
    	ascii[110] = 'n';
    	ascii[111] = 'o';
    	ascii[112] = 'p';
    	ascii[113] = 'q';	  	  	 
    	ascii[114] = 'r';	  	  	 
    	ascii[115] = 's';	  	  	 
    	ascii[116] = 't';	  	  	 
    	ascii[117] = 'u';	  	  	 
    	ascii[118] = 'v'; 	  	  	 
    	ascii[119] = 'w';	  	  	 
    	ascii[120] = 'x';	  	  	 
    	ascii[121] = 'y';	  	  	 
    	ascii[122] = 'z';
    	ascii[123] = '{';
    	ascii[124] = '|';
    	ascii[125] = '}';
    	ascii[126] = '~';

    }
    public double getStockValue(String ticker){
        Double answer = 0.0;
        url = "https://query1.finance.yahoo.com/v8/finance/chart/" + ticker + "?interval=2m";
    	
        try {
            String [] ar;
            String [] s1;
            byte [] btArray;
            char [] temp;
            URL website = new URL(url);
            URLConnection urlConnection = website.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine(); // System.out.println(line);
             btArray = line.getBytes();
             temp = new char[btArray.length];
             int n = 0;
             for(int i = 0; i < btArray.length; i++)
                temp[n++] = ascii[btArray[i]];
             // saving the temp array as a String variable
             line = new String(temp);
             // parse the string to find the closing price
             ar = line.split("\"symbol\":");
             s1 = ar[1].split(",");
             ar = line.split("\"previousClose\":");
             s1 = ar[1].split(",");
             answer  = Double.parseDouble(s1[0]);
     
        }
        catch (MalformedURLException mle){
            mle.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }	

        return answer;
    }

    public  static void main(String [] args){
        double magicConst = 0.14602128057775;
        double total = 0.0;
        double tickerVal = 0.0;

        String[] tickers;
        DjiaAverage dji = new DjiaAverage();
        try {
            String content = new Scanner(new File("ticker.txt")).useDelimiter("\\Z").next();
            tickers = content.split(",");

            for(String ticker : tickers){
               total += dji.getStockValue(ticker.replaceAll("\\s+",""));
            }
            // System.out.printf("Total: %.2f\n",total);
            System.out.printf("Djia: %,.2f\n", (total/ magicConst));


        }
        catch (IOException ioe){  // need this for FileWriter and PrintWriter exception
            ioe.printStackTrace();
        }




    	
    }
}
