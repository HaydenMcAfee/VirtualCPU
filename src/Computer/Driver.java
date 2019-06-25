package Computer;

import Computer.CPU;

public class Driver {

    public static void main(String[] args) {
        MMU mmu = new MMU();
        mmu.load("instructions"); //loads instructions into ram
        CPU process = new CPU();
        int counter = 0;
        // while (process.getpCounter != (-1))
        while (counter < 4) {
            char[] word = process.fetch(mmu, process.getpCounter());
//        char [] binaryString =
        String binaryString = process.decode(word);

        process.execute(mmu, binaryString);
        counter++;
    }
        System.out.println(process.getR5());
        System.out.println(process.getR6());
        System.out.println(process.getR1());
        System.out.println(process.getR0());

        //if instruction is HLT then pCounter = -1
    }
    //done
}
//driver

//memory management unit specific class osml
//Space using dynamic array
//Write, load, and store from memory
//32 bit, 8 hex character storage
//

