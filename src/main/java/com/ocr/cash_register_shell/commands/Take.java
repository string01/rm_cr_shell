package com.ocr.cash_register_shell.commands;

import com.ocr.cash_register.CashDrawer;
import com.ocr.cash_register.CashDrawerFactory;
import com.ocr.cash_register.InputFormatException;
import com.ocr.cash_register.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Take extends AbstractShellCommand {

    @ShellMethod(key = "take", value="Take cash from register.")
    public String take(String a20, String a10, String a5, String a2, String a1){
        String input = cashDrawerFormatter.fromInput(a20, a10, a5, a2, a1);
        try {
            CashDrawer cd = cashDrawerFactory.create(input);
            cashRegister.take(cd);
            String out = cashDrawerFormatter.toOutput(cashRegister.getCashDrawer());
            return out;
        } catch (InputFormatException e) {
            return "Error: " +  e.getMessage();
        } catch (InsufficientFundsException e) {
            return "Sorry";
        }
    }
}
