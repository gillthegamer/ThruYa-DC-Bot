package eu.ygames.utils;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class MSGS {

    public static EmbedBuilder green() {
        return new EmbedBuilder().setColor(Color.green);
    }

    public static EmbedBuilder red() {
        return new EmbedBuilder().setColor(Color.red);
    }

    public static EmbedBuilder yellow() {
        return new EmbedBuilder().setColor(Color.YELLOW);
    }

    public static EmbedBuilder orange() {
        return new EmbedBuilder().setColor(Color.orange);
    }

    public static EmbedBuilder blue() {
        return new EmbedBuilder().setColor(Color.blue);
    }

    public static EmbedBuilder magenta() {
        return new EmbedBuilder().setColor(Color.MAGENTA);
    }

    public static EmbedBuilder cyan() {
        return new EmbedBuilder().setColor(Color.CYAN);
    }

}
