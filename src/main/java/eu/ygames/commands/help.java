package eu.ygames.commands;

import eu.ygames.core.permsCore;
import eu.ygames.utils.MSGS;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;

public class help implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException {

        event.getMessage().delete().complete();

        switch (permsCore.checkAdmin(event)) {
            case 1:
            case 2:
            case 3:
            case 4:
                event.getChannel().sendMessageEmbeds(MSGS.green().setDescription(
                        ":small_red_triangle_down: Help\n\n" +
                                new setRole().help() + "\n\n" +
                                new removeRole().help() + "\n\n" +
                                help()
                ).build()).complete();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return Settings.getPREFIX() + "help\n" +
                "Gibt die Hilfe aus\n" +
                "Bsp: " + Settings.getPREFIX() + "help";
    }
}
