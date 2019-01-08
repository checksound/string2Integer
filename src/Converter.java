

public class Converter {
    // Decimal declaration and possible chars are [0-9]
    private int decimal    =  495;        

    // HexaDecimal declaration starts with 0X or 0x and possible chars are [0-9A-Fa-f]
    private int hexa       =  0X1EF; 

    // Octal declaration starts with 0 and possible chars are [0-7] 
    private int octal      =  0757;  

    // Binary representation starts with 0B or 0b and possible chars are [0-1]  
    private int binary     =  0b111101111; 

    public int doConversion(String text) {
        
        int value = text.toLowerCase().startsWith("0b") ? Integer.parseInt(text.substring(2), 2)
                                  : Integer.decode(text);
        return value;
    }

    public static void main(String args[]) {
        Converter conv = new Converter();
        
        int result = conv.doConversion("0b111101111");
        
        assert 495 == result;

        result = conv.doConversion("0X1EF");

        assert 495 == result;

        try {
            result = conv.doConversion("1EF");

            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("****************");
            e.printStackTrace();
            System.out.println("****************");
        }
    }

}
