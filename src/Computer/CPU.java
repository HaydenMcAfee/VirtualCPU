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
    //inpt buffer is actually at 00DC
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
            case "000001": execWR(mmu, binaryInstruction);
            break;
            case "000010": execST(mmu, binaryInstruction);
                break;
            case "000011": execLW(mmu, binaryInstruction);
                break;
            case "000101": execADD(mmu, binaryInstruction);
                break;
            case "001011": execMOVI(binaryInstruction);
                break;
            case "001100": execADDI(binaryInstruction);
                break;
            case "001111": execLDI(mmu, binaryInstruction);
                break;
            case "010000": execSLT(binaryInstruction);
                break;
            case "010010": execHLT(binaryInstruction);
                break;
            case "010110": execBNE(binaryInstruction);
                break;
        }
    }


    public void execRD (MMU mmu, String binaryInstruction) {
        String bReg = binaryInstruction.substring(8,12);
        String dReg = binaryInstruction.substring(12,16);
        String address = binaryInstruction.substring(16,32);
        int addressInt = toDecimal(address);
        int dRegInt = toDecimal(dReg);
        if (dRegInt != 0) {
            switch (dRegInt) {
                case 1:  addressInt = toDecimal(hexToBinary(getR1()));
                    break;
                case 2:  addressInt = toDecimal(hexToBinary(getR2()));
                    break;
                case 3:  addressInt = toDecimal(hexToBinary(getR3()));
                    break;
                case 4:  addressInt = toDecimal(hexToBinary(getR4()));
                    break;
                case 5:  addressInt = toDecimal(hexToBinary(getR5()));
                    break;
                case 6:  addressInt = toDecimal(hexToBinary(getR6()));
                    break;
                case 7:  addressInt = toDecimal(hexToBinary(getR7()));
                    break;
                case 8:  addressInt = toDecimal(hexToBinary(getR8()));
                    break;
                case 9:  addressInt = toDecimal(hexToBinary(getR9()));
                    break;
                case 10:  addressInt = toDecimal(hexToBinary(getR10()));
                    break;
                case 11:  addressInt = toDecimal(hexToBinary(getR11()));
                    break;
                case 12:  addressInt = toDecimal(hexToBinary(getR12()));
                    break;
                case 13:  addressInt = toDecimal(hexToBinary(getR13()));
                    break;
                case 14:  addressInt = toDecimal(hexToBinary(getR14()));
                    break;
                case 15:  addressInt = toDecimal(hexToBinary(getR15()));
                    break;
            }
        }
        int bRegInt = toDecimal(bReg);
        setR0(mmu.read((addressInt*2)));
        switch (bRegInt) {
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


    public void execWR(MMU mmu, String binaryInstructions) {
        String address = binaryInstructions.substring(16,32);//retrieves location of output
        int addressInt = toDecimal(address);//Stores address as an int
        mmu.store(getR0(),addressInt*2); //stores contents of accumulator
    }

    public void execST(MMU mmu, String binaryInstruction) {

        String bReg = binaryInstruction.substring(8, 12); //Stores the number of the base register
        int bRegInt = toDecimal(bReg); //Stores int value of destination register
        String dReg = binaryInstruction.substring(12,16); //Stores register number of destination register
        int dRegInt = toDecimal(dReg); //Stores int value of destination
        char[] data = new char[8]; //creation of store for the data inside the base register
        char[] address = new char[8];
        switch(bRegInt)
        {
            case 0: data = getR0();
                break;
            case 1:  data = getR1();
                break;
            case 2:  data = getR2();
                break;
            case 3:  data = getR3();
                break;
            case 4:  data = getR4();
                break;
            case 5:  data = getR5();
                break;
            case 6: data = getR6();
                break;
            case 7:  data = getR7();
                break;
            case 8:  data = getR8();
                break;
            case 9:  data = getR9();
                break;
            case 10:  data = getR10();
                break;
            case 11: data = getR11();
                break;
            case 12: data = getR12();
                break;
            case 13:  data = getR13();
                break;
            case 14: data = getR14();
                break;
            case 15: data = getR15();
                break;
        }
        switch (dRegInt) {
            case 0: address = getR0();
                break;
            case 1:  address = getR1();
                break;
            case 2:  address = getR2();
                break;
            case 3:  address = getR3();
                break;
            case 4:  address = getR4();
                break;
            case 5:  address = getR5();
                break;
            case 6: address = getR6();
                break;
            case 7:  address = getR7();
                break;
            case 8:  address = getR8();
                break;
            case 9:  address = getR9();
                break;
            case 10: address = getR10();
                break;
            case 11:  address = getR11();
                break;
            case 12:  address = getR12();
                break;
            case 13:  address = getR13();
                break;
            case 14:  address = getR14();
                break;
            case 15:  address = getR15();
                break;
        }
        mmu.store(data, toDecimal(hexToBinary(address))*2);
    }

    public void execLW(MMU mmu, String binaryInstruction) {
        String bReg = binaryInstruction.substring(8, 12); //Stores the number of the base register
        int bRegInt = toDecimal(bReg); //Stores int value of destination register
        String dReg = binaryInstruction.substring(12,16); //Stores register number of destination register
        int dRegInt = toDecimal(dReg); //Stores int value of destination
        String offset = binaryInstruction.substring(16,32);
        binaryToHex(offset);
        char[] data; //creation of store for the data inside the base register
        char[] address = new char[8];
        switch (bRegInt) {
            case 0: address = getR0();
                break;
            case 1:  address = getR1();
                break;
            case 2:  address = getR2();
                break;
            case 3:  address = getR3();
                break;
            case 4:  address = getR4();
                break;
            case 5:  address = getR5();
                break;
            case 6: address = getR6();
                break;
            case 7:  address = getR7();
                break;
            case 8:  address = getR8();
                break;
            case 9:  address = getR9();
                break;
            case 10: address = getR10();
                break;
            case 11:  address = getR11();
                break;
            case 12:  address = getR12();
                break;
            case 13:  address = getR13();
                break;
            case 14:  address = getR14();
                break;
            case 15:  address = getR15();
                break;
        }
        int addressInt = toDecimal(hexToBinary(address));
        data = mmu.read(addressInt*2);
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

    public void execADD(MMU mmu, String binaryInstruction) {
        String sReg1 = binaryInstruction.substring(8, 12);
        int sReg1Int = toDecimal(sReg1);
        String sReg2 = binaryInstruction.substring(12, 16);
        int sReg2Int = toDecimal(sReg2);
        String dReg = binaryInstruction.substring(16, 20);
        int dRegInt = toDecimal(dReg);
        char [] data = new char[8];
        switch(dRegInt)
        {
            case 0: data = getR0();
                break;
            case 1:  data = getR1();
                break;
            case 2:  data = getR2();
                break;
            case 3:  data = getR3();
                break;
            case 4:  data = getR4();
                break;
            case 5:  data = getR5();
                break;
            case 6: data = getR6();
                break;
            case 7:  data = getR7();
                break;
            case 8:  data = getR8();
                break;
            case 9:  data = getR9();
                break;
            case 10:  data = getR10();
                break;
            case 11: data = getR11();
                break;
            case 12: data = getR12();
                break;
            case 13:  data = getR13();
                break;
            case 14: data = getR14();
                break;
            case 15: data = getR15();
                break;
        }
        dRegInt = toDecimal(hexToBinary(data));
        int repData = dRegInt + toDecimal(hexToBinary(getR0()));
        String newHexString=Integer.toHexString(repData); //new data in a hex String to be put into reg10
        newHexString = newHexString.toUpperCase(); //changes to upper case for consistency
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            if (i < (8-newHexString.length())) {
                data[i] = '0';
            } else {
                data[i] = newHexString.charAt(counter);
                counter++;
            }
        }
        setR0(data);
    }

    public void execMOVI (String binaryInstruction) {
        String dReg = binaryInstruction.substring(12,16);
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

    public void execADDI (String binaryInstruction) {
        String reg2Binary = binaryInstruction.substring(12, 16);
        String address = binaryInstruction.substring(16, 32);

        int reg2Decimal= toDecimal(reg2Binary);
        int addressDecimal=toDecimal(address);

        // String addressHex = binaryToHex(address);

        int regData=0;

        switch(reg2Decimal){
            case 0: regData= toDecimal(hexToBinary(getR0()));
                break;
            case 1: regData=toDecimal(hexToBinary(getR1()));
                break;
            case 2: regData=toDecimal(hexToBinary(getR2()));
                break;
            case 3:  regData= toDecimal(hexToBinary(getR3()));
                break;
            case 4: regData=toDecimal(hexToBinary(getR4()));
                break;
            case 5:  regData=toDecimal(hexToBinary(getR5()));
                break;
            case 6: regData= toDecimal(hexToBinary(getR6()));
                break;
            case 7: regData= toDecimal(hexToBinary(getR7()));
                break;
            case 8: regData=toDecimal(hexToBinary(getR8()));
                break;
            case 9: regData=toDecimal(hexToBinary(getR9()));
                break;
            case 10:  regData=toDecimal(hexToBinary(getR10()));
                break;
            case 11: regData=toDecimal(hexToBinary(getR11()));
                break;
            case 12:  regData=toDecimal(hexToBinary(getR12()));
                break;
            case 13: regData=toDecimal(hexToBinary(getR13()));
                break;
            case 14: regData=toDecimal(hexToBinary(getR14()));
                break;
            case 15:  regData=toDecimal(hexToBinary(getR15()));
                break; }


        int repData=regData+addressDecimal;
        String newHexString=Integer.toHexString(repData); //new data in a hex String to be put into reg10
        newHexString = newHexString.toUpperCase(); //changes to upper case for consistency
        char[] data = new char[8];
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            if (i < (8-newHexString.length())) {
                data[i] = '0';
            } else {
                data[i] = newHexString.charAt(counter);
                counter++;
            }

        }
        switch (reg2Decimal) {
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

    public void execLDI (MMU mmu, String binaryInstruction) {
        String dReg = binaryInstruction.substring(12,16);
        int dRegInt = toDecimal(dReg);
        String address = binaryInstruction.substring(16,32);
        int addressInt = toDecimal(address);
        String addressHex = binaryToHex(address);
        char[] data = new char[8]; //Creation of store for length 8 address
        int counter = 0;
        for (int i = 0; i < 8; i++) { //Turns length 4 address into length 8 word
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

    public void execSLT (String binaryInstruction) {
        String sReg1 = binaryInstruction.substring(8,12); //First register
        int sReg1Int = toDecimal(sReg1); //First register turned into int
        char[] sReg1data = new char[8]; //Initialization of store for data for s register 1
        switch (sReg1Int) {
            case 0: sReg1data = getR0();
                break;
            case 1:  sReg1data = getR1();
                break;
            case 2:  sReg1data = getR2();
                break;
            case 3:  sReg1data = getR3();
                break;
            case 4:  sReg1data = getR4();
                break;
            case 5:  sReg1data = getR5();
                break;
            case 6: sReg1data = getR6();
                break;
            case 7:  sReg1data = getR7();
                break;
            case 8:  sReg1data = getR8();
                break;
            case 9:  sReg1data = getR9();
                break;
            case 10:  sReg1data = getR10();
                break;
            case 11:  sReg1data = getR11();
                break;
            case 12:  sReg1data = getR12();
                break;
            case 13:  sReg1data = getR13();
                break;
            case 14:  sReg1data = getR14();
                break;
            case 15:  sReg1data = getR15();
                break;
        }
        String sReg2 = binaryInstruction.substring(12,16); //Second register
        int sReg2Int = toDecimal(sReg2); //Second register turned into int
        char[] sReg2data = new char[8]; //Initialization of store for data for s register 1
        switch (sReg2Int) {
            case 0: sReg2data = getR0();
                break;
            case 1:  sReg2data = getR1();
                break;
            case 2:  sReg2data = getR2();
                break;
            case 3:  sReg2data = getR3();
                break;
            case 4:  sReg2data = getR4();
                break;
            case 5:  sReg2data = getR5();
                break;
            case 6: sReg2data = getR6();
                break;
            case 7:  sReg2data = getR7();
                break;
            case 8:  sReg2data = getR8();
                break;
            case 9:  sReg2data = getR9();
                break;
            case 10:  sReg2data = getR10();
                break;
            case 11:  sReg2data = getR11();
                break;
            case 12:  sReg2data = getR12();
                break;
            case 13:  sReg2data = getR13();
                break;
            case 14:  sReg2data = getR14();
                break;
            case 15:  sReg2data = getR15();
                break;
        }
        String dReg = binaryInstruction.substring(16,20); //Destination register for truth value
        int dRegInt = toDecimal(dReg); //Destination register turned into int for later switch statement
        char [] truthValue = new char[8];
        sReg1Int = toDecimal(hexToBinary(sReg1data));
        sReg2Int = toDecimal(hexToBinary(sReg2data));
        if (sReg1Int > sReg2Int) {
            for (int i = 0; i < truthValue.length; i++) {
                truthValue[i]='0';
            }
            switch (dRegInt) {
                case 0: setR0(truthValue);
                    break;
                case 1:  setR1(truthValue);
                    break;
                case 2:  setR2(truthValue);
                    break;
                case 3:  setR3(truthValue);
                    break;
                case 4:  setR4(truthValue);
                    break;
                case 5:  setR5(truthValue);
                    break;
                case 6: setR6(truthValue);
                    break;
                case 7:  setR7(truthValue);
                    break;
                case 8:  setR8(truthValue);
                    break;
                case 9:  setR9(truthValue);
                    break;
                case 10:  setR10(truthValue);
                    break;
                case 11:  setR11(truthValue);
                    break;
                case 12:  setR12(truthValue);
                    break;
                case 13:  setR13(truthValue);
                    break;
                case 14:  setR14(truthValue);
                    break;
                case 15:  setR15(truthValue);
                    break;
            }
        }
        else {
            for (int i = 0; i < truthValue.length; i++) {
                if (i == 7) {
                    truthValue[i]='1';
                }
                else {
                    truthValue[i] = '0';
                }
            }
            switch (dRegInt) {
                case 0: setR0(truthValue);
                    break;
                case 1:  setR1(truthValue);
                    break;
                case 2:  setR2(truthValue);
                    break;
                case 3:  setR3(truthValue);
                    break;
                case 4:  setR4(truthValue);
                    break;
                case 5:  setR5(truthValue);
                    break;
                case 6: setR6(truthValue);
                    break;
                case 7:  setR7(truthValue);
                    break;
                case 8:  setR8(truthValue);
                    break;
                case 9:  setR9(truthValue);
                    break;
                case 10:  setR10(truthValue);
                    break;
                case 11:  setR11(truthValue);
                    break;
                case 12:  setR12(truthValue);
                    break;
                case 13:  setR13(truthValue);
                    break;
                case 14:  setR14(truthValue);
                    break;
                case 15:  setR15(truthValue);
                    break;
            }
        }
    }

    public void execHLT (String binaryString) {
        setpCounter(-1);
    }

    public void execBNE (String binaryInstruction) {
        String bReg = binaryInstruction.substring(8,12); //grabs binary for base register
        int bRegInt = toDecimal(bReg); //base register is stored as an int
        char[] bRegdata = new char[8]; //Initialization of a store for base register data
        switch (bRegInt) { //grabs base register data
            case 0: bRegdata = getR0();
                break;
            case 1:  bRegdata = getR1();
                break;
            case 2:  bRegdata = getR2();
                break;
            case 3:  bRegdata = getR3();
                break;
            case 4:  bRegdata = getR4();
                break;
            case 5:  bRegdata = getR5();
                break;
            case 6: bRegdata = getR6();
                break;
            case 7:  bRegdata = getR7();
                break;
            case 8:  bRegdata = getR8();
                break;
            case 9:  bRegdata = getR9();
                break;
            case 10:  bRegdata = getR10();
                break;
            case 11:  bRegdata = getR11();
                break;
            case 12:  bRegdata = getR12();
                break;
            case 13:  bRegdata = getR13();
                break;
            case 14:  bRegdata = getR14();
                break;
            case 15:  bRegdata = getR15();
                break;
        }
        String dReg = binaryInstruction.substring(12,16); //grabs binary for destination register from instruction
        int dRegInt = toDecimal(dReg); //turns binary decimal register to int value
        char[] dRegdata = new char[8]; //Initialization of a store for the destination register data
        switch (dRegInt) { //grabs data from destination register
            case 0: dRegdata = getR0();
                break;
            case 1:  dRegdata = getR1();
                break;
            case 2:  dRegdata = getR2();
                break;
            case 3:  dRegdata = getR3();
                break;
            case 4:  dRegdata = getR4();
                break;
            case 5:  dRegdata = getR5();
                break;
            case 6: dRegdata = getR6();
                break;
            case 7:  dRegdata = getR7();
                break;
            case 8:  dRegdata = getR8();
                break;
            case 9:  dRegdata = getR9();
                break;
            case 10:  dRegdata = getR10();
                break;
            case 11:  dRegdata = getR11();
                break;
            case 12:  dRegdata = getR12();
                break;
            case 13:  dRegdata = getR13();
                break;
            case 14:  dRegdata = getR14();
                break;
            case 15:  dRegdata = getR15();
                break;
        }
        bRegInt = toDecimal(hexToBinary(bRegdata)); //converts the data from the base register to an int
        dRegInt = toDecimal(hexToBinary(dRegdata)); //converts the data from the destination register to an integer
        if (bRegInt != dRegInt) { //compares the data between the base and destination registers and changes the pcCounter to the address inside the instruction if their are equal
            String addressBinary = binaryInstruction.substring(16,32);
            String addressHex = binaryToHex(addressBinary);
            char[] data = new char[8]; //Creation of store for length 8 address
            for (int i = 0; i < 4; i++) { //Turns length 4 address into length 8 word
                    data[i] = addressHex.charAt(i);
            }
            int replaceCounter = toDecimal(hexToBinary(data)); //turns the address into an int to be used as the program counter
            pCounter = (replaceCounter*2); //sets the counter to the new address and is multiplied by two since each bit is 2 hex chars
        }
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

