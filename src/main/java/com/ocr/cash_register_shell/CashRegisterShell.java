package com.ocr.cash_register_shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication
@ComponentScan({"com.ocr.cash_register", "com.ocr"})
public class CashRegisterShell {

	public static void main(String[] args) {
		SpringApplication.run(CashRegisterShell.class, args);
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("cash-register-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}
}
