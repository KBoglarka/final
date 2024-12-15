package com.epam.training.ticketservice.ui.config;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PromptConfig implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("Ticket service>");
    }
}
