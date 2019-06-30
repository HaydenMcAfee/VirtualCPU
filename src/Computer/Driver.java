package Computer;

import Computer.CPU;

public class Driver {

    public static void main(String[] args) {
        MMU mmu = new MMU();
        mmu.load("instructions"); //loads instructions into ram
        CPU process = new CPU();

        while (process.getpCounter() != -1) {
            char[] word = process.fetch(mmu, process.getpCounter());
            String binaryString = process.decode(word);
            process.execute(mmu, binaryString);
        }
        //if instruction is HLT then pCounter = -1
        coreDump(mmu);

    }
    //done

    public static void coreDump (MMU mmu) {
        System.out.print("1. ");
        int counter1 = 0;
        int counter2 = 2;
        for(int i = 0; i < mmu.getRAM().length; i++){
            counter1++;
            System.out.print(mmu.getRAM()[i]);
            if (counter1 == 8) {
                counter1 = 0;
                counter2++;
                System.out.println();
                System.out.print(counter2 + ". ");
            }
        }
    }
}

//driver

//memory management unit specific class osml
//Space using dynamic array
//Write, load, and store from memory
//32 bit, 8 hex character storage
//

