package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.time.Instant;

import static Main.util.CommandOption.*;

public class Ban {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ban")) return;
        if (!event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.getInteraction().deferReply(true).setContent("你沒有權限使用此指令").queue();
        } // real ok
        if (!event.isFromGuild()) {
            event.getInteraction().deferReply().setContent("請在伺服器內使用此指令").queue();
            return;
        }
        if (!event.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }
        Member banedMember = event.getOption(BANMEMBER).getAsMember();
        if (!event.getGuild().getSelfMember().canInteract(banedMember)) {
            event.getInteraction().deferReply(true).setContent("此成員的地位比機器人高").queue();
            return;
        }
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }
        OptionMapping option = event.getOption(DELDAYS);
        String memberName = banedMember.getUser().getAsMention();

        event.getGuild().ban(banedMember, option == null ? 0 : option.getAsInt()).queue();
        event.getInteraction().deferReply(true).setContent(memberName + "ban Successfully").queue();
        event.getGuild().getTextChannelById("1008344237856792648").sendMessageEmbeds(
                new EmbedBuilder()
                        .setColor(new Color(67, 239, 152))
                        .setTitle("封禁名單")
                        .setDescription("ID:"+ memberName +"\n"+ "封禁時間:" + option.getAsString() +"天")
                        .setTimestamp(Instant.now()).build()
        ).queue();
    }
}
