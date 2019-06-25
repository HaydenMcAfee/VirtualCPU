package Computer;

public class CPU {
    private char [] instructions;
    private char [] accumulator;
    private char [] R0;
    private char [] R1;
    private char [] R2;
    private char [] R3;
    private char [] R4;
    private char [] R5;
    private char [] R6;
    private char [] R7;
    private char [] R8;
    private char [] R9;
    private char [] R10;
    private char [] R11;
    private char [] R12;
    private char [] R13;
    private char [] R14;
    private char [] R15;
    private int pCounter = 0;

    //each one of these could be its own separate class
    //before fetch you will preload R0 with 0 to create the start to the program
    //Loop {

    public char [] fetch (MMU mmu, int address){
        char[] word = mmu.read(address);
        pCounter = pCounter + 8;
        return word;
    }

    //Translate that we wrote from earlier
    public String decode (char [] hexcode){
            return hexToBinary(hexcode);
        }

    public void execute (MMU mmu, String binaryInstruction){
        String opCode = getOpCode(binaryInstruction);
        switch (opCode) {
            case "000000": execRD(mmu, binaryInstruction);
            break;
            case "001011": execMOVI(binaryInstruction);
            break;
        }
    }

    public void execMOVI (String binaryInstruction) {
        String dReg = binaryInstruction.substring(13,16);
        int dRegInt = toDecimal(dReg);
        String address = binaryInstruction.substring(16,32);
        int addressInt = toDecimal(address);
        String addressHex = binaryToHex(address);
        char[] data = new char[8];
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                data[i] = '0';
            }
            else {
                data[i] = addressHex.charAt(counter);
                counter++;
            }
        }
        switch (dRegInt) {
            case 0: setR0(data);
                break;
            case 1:  setR1(data);
                break;
            case 2:  setR2(data);
                break;
            case 3:  setR3(data);
                break;
            case 4:  setR4(data);
                break;
            case 5:  setR5(data);
                break;
            case 6: setR6(data);
                break;
            case 7:  setR7(data);
                break;
            case 8:  setR8(data);
                break;
            case 9:  setR9(data);
                break;
            case 10:  setR10(data);
                break;
            case 11:  setR11(data);
                break;
            case 12:  setR12(data);
                break;
            case 13:  setR13(data);
                break;
            case 14:  setR14(data);
                break;
            case 15:  setR15(data);
                break;
        }
    }

    public execLDI (String binaryString) {

    }

    public String binaryToHex (String binaryString) {
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

    public void execRD (MMU mmu, String binaryInstruction) {
        String dReg = binaryInstruction.substring(9,12);
        String address = binaryInstruction.substring(17,32);
        int addressInt = toDecimal(address);
        int dRegInt = toDecimal(dReg);
        setR0(mmu.read((addressInt*2)));
        switch (dRegInt) {
            case 1:  setR1(getR0());
            break;
            case 2:  setR2(getR0());
                break;
            case 3:  setR3(getR0());
                break;
            case 4:  setR4(getR0());
                break;
            case 5:  setR5(getR0());
                break;
            case 6:  setR6(getR0());
                break;
            case 7:  setR7(getR0());
                break;
            case 8:  setR8(getR0());
                break;
            case 9:  setR9(getR0());
                break;
            case 10:  setR10(getR0());
                break;
            case 11:  setR11(getR0());
                break;
            case 12:  setR12(getR0());
                break;
            case 13:  setR13(getR0());
                break;
            case 14:  setR14(getR0());
                break;
            case 15:  setR15(getR0());
                break;
        }
    }



    public String getOpCode (String binaryString){
        String binaryOpCode = "";
        for (int i = 2; i < 8; i++) {
            binaryOpCode += binaryString.charAt(i);
        }
        return binaryOpCode;
    }

    public String hexToBinary (char [] hexcode) {
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

    public int toDecimal (String myString)		// Convert binary to decimal, to call with myMemory.registers[x]
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

    public char[] getInstructions() {
        return instructions;
    }

    public void setInstructions(char[] instructions) {
        this.instructions = instructions;
    }

    public char[] getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(char[] accumulator) {
        this.accumulator = accumulator;
    }

    public char[] getR0() {
        return R0;
    }

    public void setR0(char[] r0) {
        R0 = r0;
    }

    public char[] getR1() {
        return R1;
    }

    public void setR1(char[] r1) {
        R1 = r1;
    }

    public char[] getR2() {
        return R2;
    }

    public void setR2(char[] r2) {
        R2 = r2;
    }

    public char[] getR3() {
        return R3;
    }

    public void setR3(char[] r3) {
        R3 = r3;
    }

    public char[] getR4() {
        return R4;
    }

    public void setR4(char[] r4) {
        R4 = r4;
    }

    public char[] getR5() {
        return R5;
    }

    public void setR5(char[] r5) {
        R5 = r5;
    }

    public char[] getR6() {
        return R6;
    }

    public void setR6(char[] r6) {
        R6 = r6;
    }

    public char[] getR7() {
        return R7;
    }

    public void setR7(char[] r7) {
        R7 = r7;
    }

    public char[] getR8() {
        return R8;
    }

    public void setR8(char[] r8) {
        R8 = r8;
    }

    public char[] getR9() {
        return R9;
    }

    public void setR9(char[] r9) {
        R9 = r9;
    }

    public char[] getR10() {
        return R10;
    }

    public void setR10(char[] r10) {
        R10 = r10;
    }

    public char[] getR11() {
        return R11;
    }

    public void setR11(char[] r11) {
        R11 = r11;
    }

    public char[] getR12() {
        return R12;
    }

    public void setR12(char[] r12) {
        R12 = r12;
    }

    public char[] getR13() {
        return R13;
    }

    public void setR13(char[] r13) {
        R13 = r13;
    }

    public char[] getR14() {
        return R14;
    }

    public void setR14(char[] r14) {
        R14 = r14;
    }

    public char[] getR15() {
        return R15;
    }

    public void setR15(char[] r15) {
        R15 = r15;
    }

    public int getpCounter() {
        return pCounter;
    }

    public void setpCounter(int pCounter) {
        this.pCounter = pCounter;
    }

    // } end loop when getting to the end of the instruction set
}

