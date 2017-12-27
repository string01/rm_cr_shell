package com.ocr.cash_register_shell.commands;

import com.ocr.cash_register.CashDrawer;
import com.ocr.cash_register.InputFormatException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Put extends AbstractShellCommand {

    @ShellMethod(key = "put", value="Put cash in register.")
    public String put(String a20, String a10, String a5, String a2, String a1){
        String input = cashDrawerFormatter.fromInput(a20, a10, a5, a2, a1);
        try {
            CashDrawer cd = cashDrawerFactory.create(input);
            cashRegister.put(cd);
            String out = cashDrawerFormatter.toOutput(cashRegister.getCashDrawer());
            return out;
        } catch (InputFormatException e) {
            return "Error: " +  e.getMessage();
        }
    }
}
