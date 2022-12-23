package Main.event;

import Main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.time.Instant;

import static Main.Main.guild;


public class JoinAndLeaveMain {


    public void onLeave(GuildMemberRemoveEvent event) {
        if (event.getGuild().getId().equals("825162735603810316")) {
            int memberCount = event.getGuild().getMemberCount();
            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(new Color(67, 239, 152))
                    .setDescription(event.getUser().getAsMention() + "leave了")
                    .setFooter(memberCount + "人數")
                    .setTimestamp(Instant.now());
            System.out.println(event.getUser().getAsMention());
            guild.getTextChannelById("1008344266642300999").sendMessageEmbeds(eb.build()).queue();
        }
    }

    public static class Step {
        public static int step;
        public static int step2;
        public static int step3;
        public static String stepID_1;
        public static String message1;
        public static String Embed;
        public static String stepID_4;
        static String step_gay;
        public static Member member1;
        public static EmbedBuilder b;
    }

    public void onJoin(GuildMemberJoinEvent event) {
        if (event.getGuild().getId().equals("825162735603810316")) {
            Step.step = 0;
            Step.step2 = 0;
            Step.step3 = 0;
            Step.stepID_4 = String.valueOf(0);
            User member = event.getUser();
            Step.member1 = event.getMember();
            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(new Color(67, 239, 152))
                    .setDescription(event.getMember().getUser().getAsMention() + "加入了")
                    .setFooter(event.getGuild().getMemberCount() + "人數")
                    .setTimestamp(Instant.now());
            System.out.println(event.getMember().getUser().getAsMention());
            EmbedBuilder a = new EmbedBuilder()
                    .setColor(new Color(52, 213, 235))
                    .setDescription("歡迎加入NRTS伺服器,在正式進入之前請需要通過驗證\nWelcome to join the NRTS server, please pass the verification before entering officially");
            EmbedBuilder b = new EmbedBuilder()
                    .setColor(new Color(52, 213, 235))
                    .setDescription("1.你是否會遵守管理員指示並服從\nWill you follow the administrator's instructions and obey");
            member.openPrivateChannel().queue(
                    channel -> {
                        channel.sendMessageEmbeds(a.build()).queue();
                        channel.sendMessageEmbeds(b.build()).queue(message -> {
                            message.addReaction("✅").queue();
                            message.addReaction("❌").queue();
                            Step.step = 1;
                        });
                        System.out.println("join-訊息已送達");
                    }
            );
            guild.getTextChannelById("1008344266642300999").sendMessageEmbeds(eb.build()).queue();
        }
        }

        public void GuildReactionCheck (MessageReactionAddEvent event){
            if (event.isFromGuild()) return;
            User Member = event.getUser();
            String member = event.getUser().getId();
            int StepID = Step.step;
            if (member.equals(Main.botID)) return;
            if (StepID == 1) {
                switch (event.getReactionEmote().getEmoji()) {
                    case "✅":
                        EmbedBuilder c = new EmbedBuilder()
                                .setColor(new Color(52, 213, 235))
                                .setDescription("2.請問你是否有遊玩minecraft|Do you play minecraft?");

                        event.getChannel().sendMessageEmbeds(c.build()).queue(message -> {
                            message.addReaction("✅").queue();
                            message.addReaction("❌").queue();
                            Step.step = 2;
                        });
                        break;
                    case "❌":
                        EmbedBuilder d = new EmbedBuilder()
                                .setColor(new Color(52, 213, 235))
                                .setDescription("由於你的選擇我們不得將你正式加入到伺服器");
                        event.getChannel().sendMessageEmbeds(d.build()).queue();
                        break;
                }

            } else {
                return;
            }


        }

        public void GuildReactionCheck1 (MessageReactionAddEvent event){
            if (event.isFromGuild()) return;
            String member = event.getUser().getId();
            if (member.equals(Main.botID)) return;

            int StepID1 = Step.step;

            if (StepID1 == 2) {

                switch (event.getReactionEmote().getEmoji()) {
                    case "✅":
                        EmbedBuilder d = new EmbedBuilder().setDescription("""
                                3.請問你的性別
                                1.男性 2.女性 3.雙性 4.沒性
                                3. Ask your gender
                                1. Male 2. Female 3. Intersex 4. No sex""").setColor(new Color(67, 239, 152));
                        event.getChannel().sendMessageEmbeds(d.build()).queue(message -> {
                            message.addReaction("1️⃣").queue();
                            message.addReaction("2️⃣").queue();
                            message.addReaction("3️⃣").queue();
                            message.addReaction("4️⃣").queue();
                            Step.step = 3;
                            Step.step2 = 1;
                        });
                        break;
                    case "❌":
                        EmbedBuilder c = new EmbedBuilder().setDescription("3.請問你的性別\n1.男性 2.女性 3.雙性 4.沒性").setColor(new Color(67, 239, 152));
                        event.getChannel().sendMessageEmbeds(c.build()).queue(message -> {
                            message.addReaction("1️⃣").queue();
                            message.addReaction("2️⃣").queue();
                            message.addReaction("3️⃣").queue();
                            message.addReaction("4️⃣").queue();
                            Step.step = 3;
                            Step.step2 = 2;
                        });
                        break;
                }
            } else {
                return;
            }
        }

        public void GuildReactionCheck2 (MessageReactionAddEvent event){
            if (event.isFromGuild()) return;
            String member = event.getUser().getId();
            if (member.equals(Main.botID)) return;
            int StepID2 = Step.step;
            if (StepID2 == 3) {
                switch (event.getReactionEmote().getEmoji()) {
                    case "1":
                        Step.step3 = 1;
                        EmbedBuilder a = new EmbedBuilder()
                                .setDescription("""
                                        請問你的姓名稱呼(你想別人叫你什麼名字)|May I ask your name (what do you want others to call you)
                                        請注意稱呼不能多於四個字元|Please note that the title cannot exceed four characters
                                        *中文=兩個字元,英文=等於一個字元|Chinese = two characters, English = equal to one character""");
                        event.getChannel().sendMessageEmbeds(a.build()).queue();
                        Step.step = 4;
                        Step.stepID_4 = event.getMessageId();
                        break;
                    case "2️⃣":
                        Step.step3 = 2;
                        EmbedBuilder b = new EmbedBuilder()
                                .setDescription("""
                                        請問你的姓名稱呼(你想別人叫你什麼名字)|May I ask your name (what do you want others to call you)
                                        請注意稱呼不能多於四個字元|Please note that the title cannot exceed four characters
                                        *中文=兩個字元,英文=等於一個字元|Chinese = two characters, English = equal to one character""");
                        event.getChannel().sendMessageEmbeds(b.build()).queue();
                        Step.step = 4;
                        Step.stepID_4 = event.getMessageId();
                        break;
                    case "3️⃣":
                        Step.step3 = 3;
                        EmbedBuilder c = new EmbedBuilder()
                                .setDescription("""
                                        請問你的姓名稱呼(你想別人叫你什麼名字)|May I ask your name (what do you want others to call you)
                                        請注意稱呼不能多於四個字元|Please note that the title cannot exceed four characters
                                        *中文=兩個字元,英文=等於一個字元|Chinese = two characters, English = equal to one character""");
                        event.getChannel().sendMessageEmbeds(c.build()).queue();
                        Step.step = 4;
                        Step.stepID_4 = event.getMessageId();
                        break;
                    case "4️⃣":
                        Step.step3 = 4;
                        EmbedBuilder d = new EmbedBuilder()
                                .setDescription("""
                                        請問你的姓名稱呼(你想別人叫你什麼名字)|May I ask your name (what do you want others to call you)
                                        請注意稱呼不能多於四個字元|Please note that the title cannot exceed four characters
                                        *中文=兩個字元,英文=等於一個字元|Chinese = two characters, English = equal to one character""");
                        event.getChannel().sendMessageEmbeds(d.build()).queue();
                        Step.stepID_4 = (event.getMessageId());
                        Step.step = 4;
                        break;
                }
            }

        }

        public static void onMessage (MessageReceivedEvent event){
            if (event.isFromGuild()) return;
            if (Step.step == 4) {
                if (event.getMessageId().equals(Step.stepID_4)) return;
                Step.message1 = event.getMessage().getContentRaw();
                if (Step.message1.equals("")) return;
                EmbedBuilder a = new EmbedBuilder()
                        .setDescription("恭喜你的資料已經確認完成,歡迎您的加入\nCongratulations, your information has been confirmed,Welcome to join");
                event.getChannel().sendMessageEmbeds(a.build()).queue();
                event.getChannel().sendMessage("請等待管理員接受你的加入或拒絕").queue();
                //---------------------------------------------------------------------------
                if (Step.step3 == 1) {
                    Step.step_gay = "男性";
                } else if (Step.step3 == 2) {
                    Step.step_gay = "女性";
                } else if (Step.step3 == 3) {
                    Step.step_gay = "雙性";
                } else if (Step.step3 == 4) {
                    Step.step_gay = "沒性";
                }
                //---------------------------------------------------------------------------
                if (Step.step2 == 1) {
                    Step.stepID_1 = "Yes";
                } else if (Step.step2 == 2) {
                    Step.stepID_1 = "No";
                }
                //---------------------------------------------------------------------------

                //---------------------------------------------------------------------------
                String member1 = Step.member1.getUser().getName();
                guild.getTextChannelById("1008344242441179187").sendMessage(guild.getRoleById("825203834455588866").getAsMention()).queue();
                Step.b = new EmbedBuilder()
                        .setTitle(member1 + "加入報告")
                        .setDescription("1.你是否會遵守管理員指示並服從|Will you follow the administrator's instructions and obey\n" +
                                "=====Yes\n2.請問你是否有遊玩minecraft|Do you play minecraft?\n=====" + Step.stepID_1 + "\n3.問你的性別\n1.男性 2.女性 3.雙性 4.沒性\n=====" +
                                Step.step_gay + "\n4.請問你的姓名稱呼(你想別人叫你什麼名字)\n=====" + Step.message1);
                guild.getTextChannelById("1008344242441179187").sendMessageEmbeds(Step.b.build())
                        .setActionRow(Button.success("00004", "允許加入"), (Button.danger("00005", "拒絕加入"))).queue();
                guild.getTextChannelById("1008344264503210204").sendMessageEmbeds(Step.b.build()).queue();


                Step.step = 0;
            }
            return;
        }
}



