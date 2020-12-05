package de.aggromc.selfbotbase.command;

import de.aggromc.selfbotbase.command.impl.AvatarCommand;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.HashMap;

public final class CommandManager {

    private final HashMap<String /* Name */, Command> commandHashMap = new HashMap<>();
    private int commandCount;
    private final String prefix;

    public CommandManager(final String prefix) {
        this.prefix = prefix;
        this.registerCommands();
    }

    private final void registerCommands() {
        add(new AvatarCommand());
    }

    private final void add(final Command c) {
        commandHashMap.put(prefix + c.getName(), c);
        commandCount++;
    }

    public final void execute(final MessageCreateEvent event) {
        if (commandHashMap.containsKey(event.getMessageContent().split(" ") [0])) {
            commandHashMap.get(event.getMessageContent().split(" ") [0]).execute(event, event.getMessage(), event.getMessageContent(), event.getMessageAuthor(), event.getChannel());
        }
    }
}
