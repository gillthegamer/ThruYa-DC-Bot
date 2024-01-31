package eu.ygames.commands;

import eu.ygames.core.permsCore;
import eu.ygames.utils.MSGS;
import eu.ygames.utils.Settings;
import eu.ygames.utils.Username;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class removeRole implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

        event.getMessage().delete().complete();

        StringBuilder rolename = new StringBuilder("-none-");
        int nameLength = Username.getUsernameArgsCount(event);
        if (args.length >= nameLength) {
            rolename = new StringBuilder();
            for (int i = nameLength; i < args.length; i++) {
                rolename.append(args[i]).append(" ");
            }
            rolename.deleteCharAt(rolename.length() - 1);
        }

        Role role;
        try {
            role = event.getGuild().getRolesByName(rolename.toString(), true).get(0);
        } catch (Exception e) {
            role = null;
        }


        if (permsCore.checkRols(role.getId()) == permsCore.checkAdmin(event)) {
            event.getGuild().removeRoleFromMember((UserSnowflake) event.getMessage().getMentions().getMentions(Message.MentionType.USER).get(0), role).queue();
            Message msg = event.getChannel().sendMessageEmbeds(MSGS.green().setDescription(
                    ":small_red_triangle_down: " + event.getMessage().getMentions().getMentions(Message.MentionType.USER).get(0).getAsMention() +
                            " hat jetzt die " + rolename + " Rolle nicht mehr"
            ).build()).complete();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    msg.delete().queue();
                }
            }, 5000);
        } else {
            Message msg = event.getChannel().sendMessageEmbeds(MSGS.red().setDescription(
                    ":small_red_triangle_down: Du kannst diese Rolle nicht verwalten!"
            ).build()).complete();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    msg.delete().queue();
                }
            }, 5000);
        }




            /*
            event.getGuild().getTextChannelsByName(Settings.getLOGCHANNEL(), true).get(0).sendMessageEmbeds(
                    MSGS.red().setDescription(
                            ":small_red_triangle_down: " + event.getMessage().getMentions().getMentions(Message.MentionType.USER).get(0).getAsMention() +
                                    " wurde gekickt von " + event.getMessage().getAuthor().getAsMention() + "(" + Objects.requireNonNull(event.getMessage().getMember()).getRoles().get(1).getName() + ").\n\n" +
                                    "Grund: " + reason
                    ).build()).complete();
            */




    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return Settings.getPREFIX() + "setRole [User] [Roles] \n" +
                "Setzt bei dem erwähnten User die Role \n" +
                "Bsp: setRole @gillthegamer Helfende Elfen";
    }
}
