package com.bergaz.intermediate.the_core_platform.section_11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BankAccountManager {
    public void saveAccount(BankAccount bankAccount, String fileName) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            objectOutputStream.writeObject(bankAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BankAccount loadAccount(String fileName) {
        BankAccount bankAccount = null;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            bankAccount = (BankAccount) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bankAccount;
    }
}
