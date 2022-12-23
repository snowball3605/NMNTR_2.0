package Main.command.list;

import Main.event.Question_button_click;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.EnumSet;

import static Main.util.CommandOption.*;

public class game {

    public static class ID {
        public static int c1;
        public static int c2;
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("game")) return;
            if (!event.isFromGuild()) {
                event.getInteraction().deferReply(true).setContent("請在群組裏使用此指令").queue();
            }
            ID.c1 = 0;
            ID.c2 = 0;
            OptionMapping player1 = event.getOption(GAME_USERID_1);
            OptionMapping player2 = event.getOption(GAME_USERID_2);
            String b1 = player1.getAsMember().getUser().getName();
            String b2 = player2.getAsMember().getUser().getName();
            ID.c1 = (int) player1.getAsLong();
            ID.c2 = (int) player2.getAsLong();
            Member p1 = player1.getAsMember();
            Member p2 = player2.getAsMember();
            event.getGuild().createTextChannel("game-" + b1)
                    .addPermissionOverride(p1, EnumSet.of(Permission.VIEW_CHANNEL), null).queue(message -> message.sendMessage("規則\n1.遊戲開始時會有30個按鈕\n2.每一次點擊按鈕將隨機生成數字\n3.兩位玩家須輪流進行點擊按鈕\n4.點擊中炸彈即是失敗\n5.炸彈只有一個")
                            .setActionRow(Button.success("start_game_p1", "準備")).queue());
            event.getGuild().createTextChannel("game-" + b2)
                    .addPermissionOverride(p2, EnumSet.of(Permission.VIEW_CHANNEL), null).queue(message -> message.sendMessage("規則\n1.遊戲開始時會有30個按鈕\n2.每一次點擊按鈕將隨機生成數字\n3.兩位玩家須輪流進行點擊按鈕\n4.點擊中炸彈即是失敗\n5.炸彈只有一個")
                            .setActionRow(Button.success("start_game_p2", "準備")).queue());
            event.getInteraction().deferReply(true).setContent("game is start").queue();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
