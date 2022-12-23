package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class help2 extends ListenerAdapter{

    public void SelectMenu(SelectMenuInteractionEvent event) {

        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date = event.getGuild().getTimeCreated();
        String form = time.format(date);

        if (event.getComponent().getId().equals("info")) {

            for (int i = 0; i < event.getValues().size(); i++) {

                switch (event.getValues().get(i)) {

                    case "01":
                        event.getInteraction().editMessageEmbeds(new EmbedBuilder().setTitle("Rasam_Bot").setDescription("請選擇你的需要\nPlease choose your needs").setFooter("\u00A9NRTS | 製作團隊").build()).queue();
                        break;
                    case "02":
                        event.getInteraction().editMessageEmbeds(new EmbedBuilder().setTitle("Rasam_Bot  系統\n\n\n指令command").setDescription("/clear [數字]->清除訊息\n/clear [number]-> clear message\n \n/ban [用戶]-> 封禁成員\n" +
                                "/ban [Member]-> ban Member\n\n/unban [用戶]-> 解除封禁成員\n/unban [member]-> unban member\n\n/help->機械人教學\n /help-> bot help \n\n" +
                                "/status -> 查看機械人狀態\n/status -> Check bot Status").build()).queue();
                }
            }
        }
    }
}
