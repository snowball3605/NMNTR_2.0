package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.List;

import static Main.Main.guild;

public class Question {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("question")) return;
            if (!event.isFromGuild()) return;
            if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                event.getInteraction().deferReply(true).setContent("你沒有權限").queue();
            }
            // -----------------------------------------------------------------------------//
            List<Message> messageList = event.getChannel().getHistory().retrievePast(Integer.parseInt(String.valueOf(Math.max(1, Math.min(100, 50)))))
                    .complete();
            guild.getTextChannelById("1008344259616854136").deleteMessages(messageList).queue();
            EmbedBuilder a = new EmbedBuilder()
                    .setTitle("問題回報|活動參加|疑問解答")
                    .setDescription("你好,如有需要請點擊以下按鈕\n將會有專人解答您的疑問")
                    .setAuthor("NRTS製作團隊")
                    .setColor(new Color(0xFF0000));
            event.getChannel().sendMessageEmbeds(a.build()).setActionRow(Button.success("00000", "\uD83D\uDCDC開啟客服單")).queue();
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}
