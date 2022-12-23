package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class now_time {

    public class count {

        public static class ID {

            public static  int[] step;
        }
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            int a = 1;
            if (!event.getName().equals("nowtime")) return;
            if (!event.getGuild().getSelfMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply(true).setContent("你沒有權限使用此指令").queue();
            }
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            event.getInteraction().deferReply().setContent(format.format(date)).queue();


            ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
            if (!threadPool.isShutdown())
                threadPool.shutdown();
            threadPool = Executors.newScheduledThreadPool(1);

            threadPool.scheduleWithFixedDelay(() -> {
                if (count.ID.step[a] == 999) return;
                event.getHook().editOriginal(format.format(date)).queue();
            }, 0, 1, TimeUnit.SECONDS);

        } catch (ErrorResponseException e) {
            System.out.println("time error");
        }
    }
}
