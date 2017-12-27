package com.ocr.cash_register_shell.commands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@Slf4j
public class Show extends AbstractShellCommand {

    @ShellMethod(key = "show", value = "Show cash register contents.")
    public String show() {
        log.debug("Show");
        String out = cashDrawerFormatter.toOutput(cashRegister.getCashDrawer());
        return out;
    }
}
