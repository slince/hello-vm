package org.slince.hellovm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        VirtualMachine vm = new VirtualMachine();
        List<VirtualMachine.Instruction> instructions = List.of(
                new VirtualMachine.Instruction("push", 1), // 常量入栈
                new VirtualMachine.Instruction("push", 2), // 常量入栈
                new VirtualMachine.Instruction("add", null), // 栈上加法
                new VirtualMachine.Instruction("push", 5), // 入栈
                new VirtualMachine.Instruction("sub", null) // 栈上减法
        );
        // 以上指令相当于 1 + 2 - 5 ； 输出-2
        System.out.println(vm.execute(instructions));
    }
}