package eu.ygames.listeners;

import eu.ygames.utils.MSGS;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class reactionListener extends ListenerAdapter {

    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getGuild().getTextChannelById(Settings.getRULECHANNEL()).equals(event.getGuild().getTextChannelById(event.getReaction().getChannel().getId()))) { //check if reaction is in defined rule Channel
            if (event.getReaction().getEmoji().equals(Emoji.fromUnicode(Settings.getRULECHECKEMOJI()))) { //check if reaction is defined emote
                event.getGuild().addRoleToMember(
                        Objects.requireNonNull(event.getMember()),
                        event.getGuild().getRoleById(Settings.getDEFAULTROLE())
                ).queue();
                event.getGuild().getTextChannelById(Settings.getLOGCHANNEL()).sendMessageEmbeds(
                        MSGS.green().setDescription(
                                "Der User " + Objects.requireNonNull(
                                        event.getGuild().getMember(event.getMember().getUser())
                                ).getAsMention() + " hat erfolgreich die Regeln best\u00e4tigt."
                        ).build()
                ).complete();

            }
        }

    }

    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        if (event.getGuild().getTextChannelById(Settings.getRULECHANNEL()).equals(event.getGuild().getTextChannelById(event.getReaction().getChannel().getId()))) { //check if reaction is in defined rule Channel
            if (event.getReaction().getEmoji().equals(Emoji.fromUnicode(Settings.getRULECHECKEMOJI()))) { //check if reaction is defined emote
                event.getGuild().removeRoleFromMember(Objects.requireNonNull(
                                event.getMember()),
                        event.getGuild().getRoleById(Settings.getDEFAULTROLE())
                ).queue();
                event.getGuild().getTextChannelById(Settings.getLOGCHANNEL()).sendMessageEmbeds(
                        MSGS.green().setDescription(
                                "Der User " + Objects.requireNonNull(
                                                event.getGuild().getMember(event.getMember().getUser()))
                                        .getAsMention() + " best\u00e4tigt die Regeln nun nicht mehr."
                        ).build()
                ).complete();
            }
        }


    }

}
