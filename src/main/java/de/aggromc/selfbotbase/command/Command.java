package de.aggromc.selfbotbase.command;

import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.event.message.MessageCreateEvent;

public abstract class Command {

    public abstract String getName();
    public abstract void execute(final MessageCreateEvent event, final Message msg, final String content, final MessageAuthor author, final Channel channel);

}
