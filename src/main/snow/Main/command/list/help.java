package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class help extends ListenerAdapter {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("help")) return;
            event.getChannel().sendMessageEmbeds(new EmbedBuilder().setTitle("NRTS_Bot").setDescription("請選擇你的需要\nPlease choose your needs").setFooter("\u00A9NRTS | 製作團隊").build()).setActionRow(sendServer()).queue();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static SelectMenu sendServer() {
        return SelectMenu.create("info")
                .setPlaceholder("command")
                .addOption("\uD83C\uDFE0主頁\n\uD83C\uDFE0Home", "01")
                .addOption("❗主要指令\n❗main command", "02")
                .addOption("\uD83D\uDCCB更多資訊\n\uD83D\uDCCBMore information", "03")
                .setRequiredRange(1, 1)
                .build();
    }


}
