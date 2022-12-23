package Main;

import Main.command.list.*;
import Main.event.JoinAndLeaveMain;
import Main.event.Question_button_click;
import Main.event.onready;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener_2 extends ListenerAdapter {
    help help = new help();
    help2 help2 = new help2();
    clear clear = new clear();
    JoinAndLeaveMain joinAndLeaveMain = new JoinAndLeaveMain();
    Ban ban = new Ban();
    Unban unban = new Unban();
    ping ping = new ping();
    Question question = new Question();
    Question_button_click question_button_click = new Question_button_click();
    status status = new status();
    onready onready = new onready();
    countdown countdown = new countdown();
    game game = new game();
    PoP PoP = new PoP();
    now_time now_time = new now_time();
    minecraft_ID minecraft_id = new minecraft_ID();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        clear.onSlashCommand(event);
        help.onSlashCommand(event);
        ban.onSlashCommand(event);
        unban.onSlashCommand(event);
        ping.onSlashCommand(event);
        question.onSlashCommand(event);
        status.onSlashCommand(event);
        countdown.onSlashCommand(event);
        game.onSlashCommand(event);
        PoP.onSlashCommand(event);
        now_time.onSlashCommand(event);
        minecraft_id.onSlashCommand(event);
    }

    @Override
    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {
        help2.SelectMenu(event);
        question_button_click.SelectMen(event);
        status.SelectMenu(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        joinAndLeaveMain.onJoin(event);
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        joinAndLeaveMain.onLeave(event);
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        joinAndLeaveMain.GuildReactionCheck(event);
        joinAndLeaveMain.GuildReactionCheck1(event);
        joinAndLeaveMain.GuildReactionCheck2(event);


    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (JoinAndLeaveMain.Step.step == 4) {
            JoinAndLeaveMain.onMessage(event);
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        question_button_click.onButtonClick(event);
        question_button_click.onButtonClick1(event);
        question_button_click.onButtonClick2(event);
        question_button_click.onButtonClick3(event);
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        onready.onReady(event);
    }

}

