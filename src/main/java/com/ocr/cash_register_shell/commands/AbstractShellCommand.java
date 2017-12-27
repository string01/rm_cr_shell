package com.ocr.cash_register_shell.commands;

import com.ocr.cash_register.CashDrawerFactory;
import com.ocr.cash_register.CashDrawerFormatter;
import com.ocr.cash_register.CashRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public abstract class AbstractShellCommand {

    @Autowired
    protected CashRegister cashRegister;

    @Autowired
    protected CashDrawerFormatter cashDrawerFormatter;

    @Autowired
    protected CashDrawerFactory cashDrawerFactory;


    protected String formatOutput(){
        return cashDrawerFormatter.toOutput(cashRegister.getCashDrawer());
    }

}
