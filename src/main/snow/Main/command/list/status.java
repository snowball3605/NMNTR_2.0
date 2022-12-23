package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static Main.Main.jda;
import static Main.event.onready.*;

public class status {

    public static class Step {
        public static int guild_Size;
        public static int Channel_Size;
        public static int Channel_Size1;
        public static int Channel_Size2;
        public static int Channel_Size3;
        public static int Channel_Size5;
        public static int p;
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("status")) return;
           Step.guild_Size = event.getJDA().getGuilds().size();
           Step.Channel_Size = event.getJDA().getPrivateChannels().size();
           Step.Channel_Size1 = event.getJDA().getTextChannels().size();
           Step.Channel_Size2 = event.getJDA().getVoiceChannels().size();
           Step.Channel_Size3 = event.getJDA().getThreadChannels().size();
           Step.Channel_Size5 = event.getJDA().getStageChannels().size();
            int Member_size = jda.getUsers().size();
            Step.p = Step.Channel_Size + Step.Channel_Size1 + Step.Channel_Size2 + Step.Channel_Size3 + Step.Channel_Size5;
            event.getChannel().sendMessage("請選擇你的語言版本|Please select your language version").setActionRow(sendServer()).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static SelectMenu sendServer() {
        return SelectMenu.create("status")
                .setPlaceholder("version")
                .addOption("中文版本(Chinese version)", "001")
                .addOption("English version(英文版本)", "002")
                .setRequiredRange(1, 1)
                .build();
    }

    public void SelectMenu(SelectMenuInteractionEvent event) {
        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date = event.getGuild().getTimeCreated();
        String form = time.format(date);

        if (event.getComponent().getId().equals("status")) {

            for (int i = 0; i < event.getValues().size(); i++) {

                switch (event.getValues().get(i)) {

                    case "001":
                        event.getInteraction().editMessageEmbeds(new EmbedBuilder().setTitle("NMNTR(New Make a Nature Tech Robot)  狀態").setDescription("\uD83D\uDC51 總群組:``"+ Step.guild_Size + "``\n\uD83D\uDCFA 總頻道:``"+ Step.p + "``\n\uD83D\uDC64 總使用者:``jda.getUsers().size();"+"``\n" +
                                "\uD83D\uDD52總使用時間: "+"天-DAY: ``"+d+"``|小時-hour: ``"+h+"``|分鐘-min: ``"+m+"``|秒-sec: ``"+ s+"``"+"\n\uD83D\uDCF6BOT延遲: ``"+event.getJDA().getGatewayPing()+"``ms"+"\n\uD83D\uDCACDiscord_JDA版本: ``"+"17``").build()).queue();
                    case "002":
                        event.getInteraction().editMessageEmbeds(new EmbedBuilder().setTitle("NMNTR(New Make a Nature Tech Robot)  status").setDescription("\uD83D\uDC51 Total group count:``"+ Step.guild_Size + "``\n\uD83D\uDCFA total channel count:``"+ Step.p + "``\n\uD83D\uDC64 total Users count:``jda.getUsers().size();"+"``\n" +
                                "\uD83D\uDD52total use time: "+"天-DAY: ``"+d+"``|小時-hour: ``"+h+"``|分鐘-min: ``"+m+"``|秒-sec: ``"+ s+"``"+"\n\uD83D\uDCF6BOT message ping: ``"+event.getJDA().getGatewayPing()+"``ms"+"\n\uD83D\uDCACDiscord_JDA version: ``"+"17``").build()).queue();
                }
            }
        }
    }
}
