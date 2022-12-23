package Main.event;

import Main.command.list.Unban;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

import java.time.Instant;
import java.util.EnumSet;

import static Main.Main.guild;

public class Question_button_click extends ListenerAdapter {

    public static class Step {
        public static String Name = Unban.Stp.mt;
        public static String Namt = Unban.Stp.mg;
        public static String UN = Unban.Stp.ms;
    }

    public void onButtonClick(ButtonInteractionEvent event) {
        if (!event.getButton().getId().equals("00000")) return;
        event.deferEdit().queue();
        String member = event.getMember().getUser().getName();
        if (event.getButton().getId().equals("00000")) {
            event.getGuild().createTextChannel("ticket-" + member, event.getGuild().getCategoryById("1008344224506331288"))
                    .addPermissionOverride(event.getGuild().getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                    .addPermissionOverride(event.getGuild().getRoleById("825203834455588866"), EnumSet.of(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND), null)
                    .addPermissionOverride(event.getMember(), EnumSet.of(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND), null)
                    .queue(message -> message.sendMessage("請選擇你需要的項目").setActionRow(ez()).queue());

        }
    }
    public void SelectMen(SelectMenuInteractionEvent event) {
        if (event.getComponent().getId().equals("QAQ")) {
            for (int i = 0; i < event.getValues().size(); i++) {
                switch (event.getValues().get(i)) {
                    case "0001":
                        event.getChannel().deleteMessageById(event.getMessageId()).queue();
                        event.getChannel().sendMessage(event.getGuild().getRoleById("825203834455588866").getAsMention()).queue();
                        EmbedBuilder a = new EmbedBuilder()
                                .setDescription(event.getMember().getAsMention()+"客服單創建 -> 領取獎勵")
                                .setTimestamp(Instant.now());
                        event.getChannel().sendMessageEmbeds(a.build()).queue();
                        EmbedBuilder b = new EmbedBuilder()
                                .setAuthor("NRTS製作團隊")
                                .setTitle("如不需要客服單請關閉客服單以免造成我們不便")
                                .setDescription("感謝您的合作");
                        event.getChannel().sendMessageEmbeds(b.build()).setActionRow(Button.success("00001", "關閉客服單")).queue();
                        event.getChannel().sendMessage("X----------------X\n"+"您好"+event.getMember().getAsMention()+"由於現在所有團隊人員忙線中\n" +
                                "為避免造成困擾請勿TAG服務人員以免造成他人困擾，並請提供您目前遇到的問題及詳細資訊\n好讓我們的客服人員可以盡速的為您提供服務\n" +
                                "X----------------X").queue();
                        return;
                    case "0002":
                        event.getChannel().deleteMessageById(event.getMessageId()).queue();
                        event.getChannel().sendMessage(event.getGuild().getRoleById("825203834455588866").getAsMention()).queue();
                        EmbedBuilder c = new EmbedBuilder()
                                .setDescription(event.getMember().getAsMention()+"客服單創建 -> 疑問解答")
                                .setTimestamp(Instant.now());
                        event.getChannel().sendMessageEmbeds(c.build()).queue();
                        EmbedBuilder d = new EmbedBuilder()
                                .setAuthor("NRTS製作團隊")
                                .setTitle("如不需要客服單請關閉客服單以免造成我們不便")
                                .setDescription("感謝您的合作");
                        event.getChannel().sendMessageEmbeds(d.build()).setActionRow(Button.success("00001", "關閉客服單")).queue();
                        event.getChannel().sendMessage("X----------------X\n"+"您好"+event.getMember().getAsMention()+"由於現在所有團隊人員忙線中\n" +
                                "為避免造成困擾請勿TAG服務人員以免造成他人困擾，並請提供您目前遇到的問題及詳細資訊\n好讓我們的客服人員可以盡速的為您提供服務\n" +
                                "X----------------X").queue();
                        return;
                    case "0003":
                        event.getChannel().deleteMessageById(event.getMessageId()).queue();
                        event.getChannel().sendMessage(event.getGuild().getRoleById("825203834455588866").getAsMention()).queue();
                        EmbedBuilder e = new EmbedBuilder()
                                .setDescription(event.getMember().getAsMention()+"客服單創建 -> 問題回報")
                                .setTimestamp(Instant.now());
                        event.getChannel().sendMessageEmbeds(e.build()).queue();
                        EmbedBuilder f = new EmbedBuilder()
                                .setAuthor("NRTS製作團隊")
                                .setTitle("如不需要客服單請關閉客服單以免造成我們不便")
                                .setDescription("感謝您的合作");
                        event.getChannel().sendMessageEmbeds(f.build()).setActionRow(Button.success("00001", "關閉客服單")).queue();
                        event.getChannel().sendMessage("X----------------X\n"+"您好"+event.getMember().getAsMention()+"由於現在所有團隊人員忙線中\n" +
                                "為避免造成困擾請勿TAG服務人員以免造成他人困擾，並請提供您目前遇到的問題及詳細資訊\n好讓我們的客服人員可以盡速的為您提供服務\n" +
                                "X----------------X").queue();
                        return;
                    case "0004":
                        event.getChannel().deleteMessageById(event.getMessageId()).queue();
                        event.getChannel().sendMessage(event.getGuild().getRoleById("825203834455588866").getAsMention()).queue();
                        EmbedBuilder g = new EmbedBuilder()
                                .setDescription(event.getMember().getAsMention()+"客服單創建 -> 其他問題")
                                .setTimestamp(Instant.now());
                        event.getChannel().sendMessageEmbeds(g.build()).queue();
                        EmbedBuilder h = new EmbedBuilder()
                                .setAuthor("NRTS製作團隊")
                                .setTitle("如不需要客服單請關閉客服單以免造成我們不便")
                                .setDescription("感謝您的合作");
                        event.getChannel().sendMessageEmbeds(h.build()).setActionRow(Button.success("00001", "關閉客服單")).queue();
                        event.getChannel().sendMessage("X----------------X\n"+"您好"+event.getMember().getAsMention()+"由於現在所有團隊人員忙線中\n" +
                                "為避免造成困擾請勿TAG服務人員以免造成他人困擾，並請提供您目前遇到的問題及詳細資訊\n好讓我們的客服人員可以盡速的為您提供服務\n" +
                                "X----------------X").queue();
                        return;
                }
            }
        }

    }

    public static SelectMenu ez() {
        return SelectMenu.create("QAQ")
                .setPlaceholder("請你選擇問題類型")
                .addOption("\uD83D\uDE01領取獎勵", "0001")
                .addOption("❓疑問解答", "0002")
                .addOption("❓問題回報", "0003")
                .addOption("其他問題", "0004")
                .setRequiredRange(1, 1).build();
    }

    public void onButtonClick1(ButtonInteractionEvent event) {
        if (event.getMember().getUser().getId().equals("869150235073601537")) return;
        try {
            if (event.getButton().getId().equals("00001")) {
                event.getChannel().delete().queue();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return;
        }
    }

    public void onButtonClick2(ButtonInteractionEvent event) {
        if (event.getMember().getUser().getId().equals("1008344211713703936")) return;
        try {
            if (event.getButton().getId().equals("00004")) {
                Role role = guild.getRoleById("1008344211713703936");
                assert role != null;
                guild.addRoleToMember(JoinAndLeaveMain.Step.member1, role).queue();
                guild.modifyNickname(JoinAndLeaveMain.Step.member1, "[玩家]"+JoinAndLeaveMain.Step.message1).queue();
                JoinAndLeaveMain.Step.member1.getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessage("管理員已經接受您的加入 ").queue();
                });
                guild.getTextChannelById("1008344242441179187").deleteMessageById(guild.getTextChannelById("1008344242441179187").getLatestMessageId()).queue();
                guild.getTextChannelById("1008344242441179187").sendMessage(event.getMember().getUser().getName()+"已處理"+ JoinAndLeaveMain.Step.member1.getUser().getName()+"\n結果:接受").queue();
                guild.getTextChannelById("1008344264503210204").sendMessage(event.getMember().getUser().getName()+"已處理"+ JoinAndLeaveMain.Step.member1.getUser().getName()+"\n結果:接受").queue();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onButtonClick3(ButtonInteractionEvent event) {
        if (event.getMember().getUser().getId().equals("869150235073601537")) return;
        try {
            if (event.getButton().getId().equals("00005")) {
                JoinAndLeaveMain.Step.member1.kick().queue();
                JoinAndLeaveMain.Step.member1.getUser().openPrivateChannel().queue(channel -> {
                    channel.sendMessage("抱歉,管理員已經拒絕你的加入").queue();
                });
                guild.getTextChannelById("1008344242441179187").deleteMessageById(guild.getTextChannelById("1008344242441179187").getLatestMessageId()).queue();
                guild.getTextChannelById("1008344242441179187").sendMessage(event.getMember().getUser().getName()+"已處理"+ JoinAndLeaveMain.Step.member1.getUser().getName()+"\n結果:拒絕").queue();
                guild.getTextChannelById("1008344264503210204").sendMessage(event.getMember().getUser().getName()+"已處理"+ JoinAndLeaveMain.Step.member1.getUser().getName()+"\n結果:拒絕").queue();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onButtonClick4(ButtonInteractionEvent event) {
        if (event.getMember().getUser().getId().equals("869150235073601537")) return;
        try {
            if (event.getButton().getId().equals("start_game_p1")) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
