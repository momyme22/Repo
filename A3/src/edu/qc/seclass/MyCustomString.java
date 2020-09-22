package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{

    private String str;
    
    public MyCustomString() {
        str = null;
    }
    
    public MyCustomString(String s) {
        str = s;
    }
    
    @Override
    public String getString() {
        return str;
    }

    @Override
    public void setString(String string) {
        this.str = string;
    }

    @Override
    public int countNumbers() {
        int countNum = 0;
        int numLenght = 0; 
        int i = 0;
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            if (str.length() == 0) {
                return 0;
            }
            else {
                while (i < this.str.length()) {
                    while (i < this.str.length() && Character.isDigit(this.str.charAt(i))) {
                        numLenght++;
                        i++;
                    }
                    if (numLenght > 0) {
                        countNum++;
                        numLenght = 0;
                    }
                    i++;
                }
                return countNum;
            }
        }
        catch (NullPointerException e){
            System.out.println("The string is null");
            throw e;
        }
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        String s = "";
        
        try {
            if (n <= 0) {
                throw new IllegalArgumentException();
            }
            if (str == null && n > 0) {
                throw new NullPointerException();
            }
            if (!startFromEnd){
                for (int i = n-1; i < str.length(); i+=n) {
                    s = s+str.charAt(i);
                }
            }
            else {
                for (int i = str.length()-n; i >= 0; i-=n) {
                        s = str.charAt(i) + s;
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("n less than or equal to zero");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("the string is null and n is greater than zero");
            throw e;
        }
        return s;
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        String[] array = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String s = "";
        
        try {
            if (startPosition > endPosition) {
                throw new IllegalArgumentException();
            }
            if (startPosition <= endPosition) {
                if (startPosition < 1 || endPosition > str.length()) {
                    throw new MyIndexOutOfBoundsException();
                }
            }
            if (startPosition <= endPosition && startPosition > 0 && endPosition > 0 && str == null) {
                throw new NullPointerException();
            }
            
            int sPosition = startPosition - 1;
            int ePosition = endPosition - 1;
            int i = 0;
            int a; 
            while (i < str.length()) {
                if (i >= sPosition && i <= ePosition) {
                    if (Character.isDigit(this.str.charAt(i))) {
                        a = Integer.parseInt(String.valueOf(str.charAt(i)));
                        for (int j = 0; j < array.length; j++) {
                            if (a == j) {
                                s = s + array[j];
                            }
                        }
                    }
                    else {
                        s = s + str.charAt(i);
                    }
                }
                else {
                    s = s + str.charAt(i);
                }
                i++;
            }
            this.setString(s);;
        }
        catch (IllegalArgumentException e) {
            System.out.println("startPosition > endPosition");
            throw e;
        }
        catch (MyIndexOutOfBoundsException e) {
            System.out.println("startPosition <= endPosition, but either startPosition or endPosition are out of bounds");
            throw e;
        }
        catch (NullPointerException e) {
            System.out.println("startPosition <= endPosition, startPosition and endPosition are greater than 0, and the string is null");
            throw e;
        }
    }

    

}
