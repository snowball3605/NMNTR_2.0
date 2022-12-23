package Main.command.list;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Main.util.CommandOption.*;

public class countdown {

    public static class e {
        public static int[] step;
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("countdown")) return;
        try {
            int a = 999999999;
            if (!event.getGuild().getSelfMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply(true).setContent("你沒有權限使用此指令").queue();
            }
            if (!event.isFromGuild()) {
                event.getInteraction().deferReply(true).setContent("請在群組裏使用此指令").queue();
            }
            final int[] Seconds = {0};
            final int[] minutes = {0};
            final int[] hours = {0};
            final int[] days = {0};
            OptionMapping Second = event.getOption(SECONDS);
            OptionMapping minute = event.getOption(MINUTE);
            OptionMapping hour = event.getOption(HOUR);
            OptionMapping day = event.getOption(DAYS);
            if (Second != null) {
                Seconds[0] = (int) Math.max(1, Math.min(60, Second.getAsLong()));
            } else if (Second == null) {
                Seconds[0] = 10;
            }
            if (minute != null) {
                minutes[0] = (int) Math.max(0, Math.min(60, minute.getAsLong()));
            } else if (minute == null) {
                minutes[0] = 0;
            }
            if (hour != null) {
                hours[0] = (int) Math.max(0, Math.min(12, hour.getAsLong()));
            } else if (hour == null) {
                hours[0] = 0;
            } else if (day == null) {
                days[0] = 0;
            }
            if (day != null) {
                days[0] = (int) Math.max(0, Math.min(2300, day.getAsLong()));
            }

            ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();

            if (!threadPool.isShutdown())
                threadPool.shutdown();
            threadPool = Executors.newScheduledThreadPool(1);

            final long[] aff = {2120};
            char gg = 1;
            if (e.step[a] == 0) return;
            event.getInteraction().deferReply().setContent(days[0] + "D:" + hours[0] + "H:" + minutes[0] + "M:" + Seconds[0] + "S").queue();
            int finalDays = days[0];
            int finalHours = hours[0];
            threadPool.scheduleWithFixedDelay(() -> {
                if (e.step[a] == 0) return;
                event.getHook().editOriginal("\n" + days[0] + "D:" + hours[0] + "H:" + minutes[0] + "M:" + Seconds[0] + "S").queue();
                Seconds[0] -= 1;
                if (e.step[a] == 1) {
                    if (Seconds[0] == -1) {
                        if (e.step[a] == 0) return;
                        event.getHook().editOriginal("\n" + days[0] + "D:" + hours[0] + "H:" + minutes[0] + "M:" + Seconds[0] + "S").queue();
                        minutes[0] -= 1;
                        Seconds[0] = 59;
                       if (minutes[0] == -1 && e.step[a] == 1) {
                            if (e.step[a] == 0) return;
                            event.getHook().editOriginal("\n" + days[0] + "D:" + hours[0] + "H:" + minutes[0] + "M:" + Seconds[0] + "S").queue();
                            hours[0] -= 1;
                            minutes[0] = 59;
                            if (hours[0] == -1 && e.step[a] == 1) {
                                if (e.step[a] == 0) return;
                                event.getHook().editOriginal("\n" + days[0] + "D:" + hours[0] + "H:" + minutes[0] + "M:" + Seconds[0] + "S").queue();
                                days[0] -= 1;
                                hours[0] = 24;
                            }
                        }
                    } else if (Seconds[0] == 0 && minutes[0] == 0 && hours[0] == 0 && days[0] == 0) {
                        event.getHook().editOriginal("時間結束|time up").queue();
                        e.step[a] = 0;
                        return;
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);
        } catch (ErrorResponseException e) {
            System.out.println("time error");
            return;
        }
    }

}
