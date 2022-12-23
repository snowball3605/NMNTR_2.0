package Main;

import Main.command.list.help;
import Main.command.list.help2;
import Main.event.onready;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

import static Main.util.CommandOption.*;

public class Main {

    static final String TOKEN = "666";

    public static JDA jda;
    public static String botID;
    public static Guild guild;



    public static void main(String[] args) throws Exception {

        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN)
                .setLargeThreshold(250)
                .enableCache(CacheFlag.ONLINE_STATUS, CacheFlag.ACTIVITY)
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.playing("Kevin"))
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(new Listener_2());

        jda = jdaBuilder.build().awaitReady();
        jda.addEventListener(new help());
        jda.addEventListener(new help2());
        jda.addEventListener(new onready());
        botID = jda.getSelfUser().getId();
        guild = jda.getGuildById("825162735603810316");


        jda.updateCommands().addCommands(
                new CommandDataImpl("help", "bot help"),
                new CommandDataImpl("clear", "clear message")
                        .addOption(OptionType.INTEGER, COUNT, "2-100", true),
                new CommandDataImpl("ban", "ban member")
                        .addOption(OptionType.MENTIONABLE, BANMEMBER, "member", true),
                new CommandDataImpl("unban", "unban member")
                        .addOption(OptionType.MENTIONABLE, USERID, "member", true),
                new CommandDataImpl("status", "status"),
                new CommandDataImpl("question", "question"),
                new CommandDataImpl("game", "game")
                        .addOption(OptionType.MENTIONABLE, GAME_USERID_1, "player1", true)
                        .addOption(OptionType.MENTIONABLE, GAME_USERID_2, "player2", true),
                new CommandDataImpl("ping", "ping"),
                new CommandDataImpl("turtle", "turtle"),
                new CommandDataImpl("lottery", "lottery"),
                new CommandDataImpl("nowtime", "now_time"),
                new CommandDataImpl("countdown", "countdown")
                        .addOption(OptionType.STRING, SECONDS, "seconds", true)
                        .addOption(OptionType.STRING, MINUTE, "minute")
                        .addOption(OptionType.STRING, HOUR, "hour")
                        .addOption(OptionType.STRING, DAYS, "days"),
                new CommandDataImpl("mcsearch", "Search the Minecraft uuid/name")
                        .addOption(OptionType.STRING, MINECRAFT_API, "enter your mc name to get uuid")

        ).queue();
    }
}
