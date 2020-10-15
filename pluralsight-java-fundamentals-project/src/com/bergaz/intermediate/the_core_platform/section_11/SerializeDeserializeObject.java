package com.bergaz.intermediate.the_core_platform.section_11;

public class SerializeDeserializeObject {
    public static void main(String[] args) {

        String outputFile = LocalFilePath.getPath() + "/BankAccount_output";

        BankAccount bankAccount = new BankAccount("1234", 500);
        bankAccount.deposit(10);
        BankAccountManager bankAccountManager = new BankAccountManager();
        bankAccountManager.saveAccount(bankAccount, outputFile);

        BankAccount deserializedAccount = bankAccountManager.loadAccount(outputFile);
        System.out.println("read: " + deserializedAccount.getBalance());
    }
}
