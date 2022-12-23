package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.time.Instant;
import java.util.List;

import static Main.Main.guild;
import static Main.util.CommandOption.COUNT;

public class clear {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {

            if (!event.getName().equals("clear")) return;
            if (!event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                event.getInteraction().deferReply(true).setContent("你沒有權限使用此指令").queue();
            }
            if (!event.isFromGuild()) {
                event.getInteraction().deferReply(true).setContent("請在群組裏使用此指令").queue();
            }
            int message = 0;
            OptionMapping amount = event.getOption(COUNT);
            assert amount != null;
            message = (int) Math.max(2, Math.min(100, amount.getAsLong()));
            List<Message> messageList = event.getChannel().getHistory().retrievePast(Integer.parseInt(String.valueOf(message)))
                    .complete();
            event.getTextChannel().deleteMessages(messageList).queue();
            event.getInteraction().getChannel().sendMessage("已刪除訊息數量"+ message).queue();
            String channel = event.getTextChannel().getName();
            EmbedBuilder a = new EmbedBuilder()
                    .setTitle("刪除訊息")
                    .setDescription("已刪除訊息數量" + message + "\n" + channel)
                    .setTimestamp(Instant.now());
            guild.getTextChannelById("1008344263240728616").sendMessageEmbeds(a.build()).queue();
            String name = event.getGuild().getName();
            System.out.println(name + "已刪除"+ message + "訊息");

        } catch (IllegalArgumentException e) {
            event.getInteraction().deferReply(true).setContent("指令錯誤請檢查後再試\n1.檢查刪除訊息是否在兩週以內\n2.檢查刪除訊息少於100條").queue();
        }
    }
}
