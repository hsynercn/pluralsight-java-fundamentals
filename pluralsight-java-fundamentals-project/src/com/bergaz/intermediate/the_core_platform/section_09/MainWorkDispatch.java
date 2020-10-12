package com.bergaz.intermediate.the_core_platform.section_09;

public class MainWorkDispatch {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("1234", 500);
        WorkDispatchSystem workDispatchSystem = new WorkDispatchSystem();
        workDispatchSystem.startWork("com.bergaz.intermediate.the_core_platform.section_09.AccountWorker",
                bankAccount);
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}
