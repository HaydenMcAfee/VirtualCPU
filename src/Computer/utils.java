package Computer;

public class utils {
    static public String binaryToHex (String binaryString) {
        String hexString = "";
        for (int i = 0; i < binaryString.length(); i+=4) {
            String fourLength = "";
            for (int j = i; j < i+4; j++) {
                fourLength = fourLength + binaryString.charAt(j);
            }
            switch(fourLength){
                case"0000":hexString+='0';
                    break;
                case"0001":hexString+='1';
                    break;
                case"0010":hexString+='2';
                    break;
                case"0011":hexString+='3';
                    break;
                case"0100":hexString+='4';
                    break;
                case"0101":hexString+='5';
                    break;
                case"0110":hexString+='6';
                    break;
                case"0111":hexString+='7';
                    break;
                case"1000":hexString+='8';
                    break;
                case"1001":hexString+='9';
                    break;
                case"1010":hexString+='A';
                    break;
                case"1011":hexString+='B';
                    break;
                case"1100":hexString+='C';
                    break;
                case"1101":hexString+='D';
                    break;
                case"1110":hexString+='E';
                    break;
                case"1111":hexString+='F';
                    break;
            }
        }
        return hexString;
    }

    static public String getOpCode (String binaryString){
        String binaryOpCode = "";
        for (int i = 2; i < 8; i++) {
            binaryOpCode += binaryString.charAt(i);
        }
        return binaryOpCode;
    }

    static public String hexToBinary (char [] hexcode) {
        String binaryString = "";
        for (int i = 0; i < hexcode.length; i++){
            switch(hexcode[i]){
                case'0':binaryString+="0000";
                    break;
                case'1':binaryString+="0001";
                    break;
                case'2':binaryString+="0010";
                    break;
                case'3':binaryString+="0011";
                    break;
                case'4':binaryString+="0100";
                    break;
                case'5':binaryString+="0101";
                    break;
                case'6':binaryString+="0110";
                    break;
                case'7':binaryString+="0111";
                    break;
                case'8':binaryString+="1000";
                    break;
                case'9':binaryString+="1001";
                    break;
                case'A':binaryString+="1010";
                    break;
                case'B':binaryString+="1011";
                    break;
                case'C':binaryString+="1100";
                    break;
                case'D':binaryString+="1101";
                    break;
                case'E':binaryString+="1110";
                    break;
                case'F':binaryString+="1111";
                    break;
            }
        }
        return binaryString;
    }

    static public int toDecimal (String myString)		// Convert binary to decimal, to call with myMemory.registers[x]
    { // begins toDecimal

        int myReturn = 0;
        int counter = myString.length()-1;
        int exponent = 0;

        while (counter != -1)
        { // begins while

            if (myString.charAt(counter) == '1')
                myReturn += Math.pow(2, exponent);
            exponent++;
            counter--;

        } // ends while

        return myReturn;
    } // ends toDecimal
}
