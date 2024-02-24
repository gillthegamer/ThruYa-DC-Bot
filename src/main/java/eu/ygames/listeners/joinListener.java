package eu.ygames.listeners;

import eu.ygames.utils.MSGS;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class joinListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());

        event.getGuild().getTextChannelById(Settings.getLOGCHANNEL()).sendMessageEmbeds(
                MSGS.cyan().setDescription(
                        event.getMember().getAsMention() + " ist um " + formatter.format(date) + " Uhr auf " + event.getGuild().getName() + " gejoint.\n" +
                                "Es sind jetzt " + event.getGuild().getMembers().size() + " User auf dem Discord."
                ).build()
        ).complete();

        event.getGuild().getTextChannelById(Settings.getWELCOMECHANNEL()).sendMessageEmbeds(
                MSGS.cyan().setDescription(
                     "Hallo " + event.getMember().getAsMention() + " und Willkommen auf " + event.getGuild().getName() + "."
                ).build()
        ).complete();
    }
}
