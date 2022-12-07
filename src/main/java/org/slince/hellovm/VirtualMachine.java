package org.slince.hellovm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class VirtualMachine{
    private static final int DEFAULT_STACK_SIZE = 120;

    // 栈区
    private final Integer[] stack;
    // 程序计数器
    private int programCounter = 0;
    // 栈顶指针
    private int stackPointer = -1;

    public VirtualMachine(int stackSize){
        this.stack = new Integer[stackSize];
    }

    public VirtualMachine() {
        this(DEFAULT_STACK_SIZE);
    }

    public Integer execute(List<Instruction> program){
        int length = program.size();
        while (programCounter < length) {
            Instruction inst = program.get(programCounter);
            switch (inst.getType()) {
                case "push":
                    stackPointer++;
                    stack[stackPointer] = inst.getOperand();
                    break;
                case "add":
                    Integer right = stack[stackPointer];
                    stackPointer--;
                    Integer left = stack[stackPointer];
                    stack[stackPointer] = left + right;
                    break;
                case "sub":
                    Integer right2 = stack[stackPointer];
                    stackPointer--;
                    Integer left2 = stack[stackPointer];
                    stack[stackPointer] = left2 - right2;
                    break;
            }
            programCounter++;
        }
        return stack[stackPointer];
    }

    @RequiredArgsConstructor
    @Getter
    public static class Instruction{
        private final String type;
        private final Integer operand;
    }
}
