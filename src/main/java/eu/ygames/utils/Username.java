package eu.ygames.utils;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Objects;

public class Username {

    public static int getUsernameArgsCount(MessageReceivedEvent event) {
        String username = Objects.requireNonNull(event.getGuild().getMemberById(event.getMessage().getMentions().getMentions(Message.MentionType.USER).get(0).getId())).getEffectiveName();
        String[] nick = username.split(" ");
        return nick.length;
    }
}
