package eu.ygames.listeners;

import eu.ygames.core.commandHandler;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;


public class commandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().startsWith(Settings.getPREFIX()) && !event.getMessage().getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            try {
                commandHandler.handleCommand(commandHandler.parser.parse(event.getMessage().getContentStripped(), event));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}