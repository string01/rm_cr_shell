package com.ocr.cash_register_shell.commands;

import com.ocr.cash_register.CashDrawer;
import com.ocr.cash_register.InputFormatException;
import com.ocr.cash_register.InsufficientFundsException;
import com.ocr.cash_register.InvalidChangeException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Change extends AbstractShellCommand{

    @ShellMethod(key = "change", value="Put cash in register.")
    public String change(int amt) {
        try {
            cashRegister.change(amt);
        } catch (InvalidChangeException e) {
            return "Sorry";
        } catch (InsufficientFundsException e) {
            return "Sorry";
        }
        
        String out = cashDrawerFormatter.toOutput(cashRegister.getLastTaken(), true);
        return out;
    }
}
