package de.aggromc.selfbotbase;

import de.aggromc.selfbotbase.command.CommandManager;
import org.javacord.api.AccountType;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public final class Selfbot {

    public static final void main(String[] args) {
        final String token = "Input your token here.";
        final String prefix = "a.";

        final DiscordApi api = new DiscordApiBuilder().setAccountType(AccountType.CLIENT).setToken(token).login().join();

        final CommandManager cmdMan = new CommandManager(prefix);

        System.out.println("Logged in as " + api.getYourself().getDiscriminatedName() + "!");

        api.addMessageCreateListener(event -> {
            if (event.getMessageAuthor().isYourself()) {
                if (event.getMessageContent().startsWith(prefix)) {
                    System.out.println("[COMMANDMANAGER] Command executed: " + event.getMessageContent());
                    cmdMan.execute(event);
                }
            }
        });


    }

}
