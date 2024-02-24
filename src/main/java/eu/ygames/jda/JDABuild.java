package eu.ygames.jda;

import eu.ygames.commands.help;
import eu.ygames.commands.removeRole;
import eu.ygames.commands.setRole;
import eu.ygames.core.commandHandler;
import eu.ygames.listeners.*;
import eu.ygames.utils.Settings;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class JDABuild {
    public static void JDAConfigure() {

        JDABuilder builder = JDABuilder.createDefault(Settings.getTOKEN());
        enableIntents(builder);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setAutoReconnect(true);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setCompression(Compression.NONE);
        builder.setChunkingFilter(ChunkingFilter.ALL);

        addCommands();
        addListeners(builder);
        builder.build();

    }

    public static void enableIntents (JDABuilder builder) {
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS); //GUILD_MEMBERS is necessary for set Role
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT); //MESSAGE_CONTENT is necessary for commands
    }

    public static void addCommands()  {

        //commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("help", new help());
        commandHandler.commands.put("setRole",new setRole());
        commandHandler.commands.put("removeRole", new removeRole());
    }

    public static void addListeners(JDABuilder builder) {
        builder.addEventListeners(new commandListener());
        builder.addEventListeners(new joinListener());
        builder.addEventListeners(new reactionListener());

    }

}
