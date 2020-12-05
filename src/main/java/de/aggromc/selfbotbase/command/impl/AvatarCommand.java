package de.aggromc.selfbotbase.command.impl;

import de.aggromc.selfbotbase.command.Command;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.event.message.MessageCreateEvent;


public class AvatarCommand extends Command {

    @Override
    public final String getName() {
        return "avatar";
    }

    @Override
    public final void execute(MessageCreateEvent event, Message msg, String content, MessageAuthor author, Channel channel) {
        msg.edit(author.getAvatar().getUrl().toString() + "?size=1024").join();
    }
}
