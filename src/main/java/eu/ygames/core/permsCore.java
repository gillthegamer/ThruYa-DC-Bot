package eu.ygames.core;

import eu.ygames.utils.MSGS;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class permsCore {

    public static int checkAdmin(MessageReceivedEvent event) {
        if (Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).getRoles().contains(event.getGuild().getRoleById(Settings.getAdminHobbitbear()))) {
            return 1;
        } else if (Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).getRoles().contains(event.getGuild().getRoleById(Settings.getAdminHeyimt()))) {
            return 2;
        } else if (Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).getRoles().contains(event.getGuild().getRoleById(Settings.getAdminNeor3flux()))) {
            return 3;
        } else {
            ErrorNoPermission(event);
            return 0;
        }
    }
    public static int checkRols(String RoleID) {
        if (Arrays.asList(Settings.getRolsHobbitbear()).contains(RoleID)) {
            return 1;
        } else if (Arrays.asList(Settings.getRolsHeyimt()).contains(RoleID)) {
            return 2;
        } else if (Arrays.asList(Settings.getRolsNeor3flux()).contains(RoleID)) {
            return 3;
        } else {
            return 0;
        }
    }

    private static void ErrorNoPermission(MessageReceivedEvent event) {
        Message msg = event.getChannel().sendMessageEmbeds(MSGS.red().setDescription(
                ":warning:  Sorry, " + event.getAuthor().getAsMention() + ", du hast nicht die Berechtigung diesen Befehl auszuf\u00fchren!"
        ).build()).complete();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                msg.delete().queue();
            }
        }, 10000);
    }

}
