package Main.event;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import static Main.Main.guild;
import static Main.Main.jda;

public class Cross_group_chat {

    public void MessageReceivedEvent(MessageReceivedEvent event) {
        if (event.getGuild().getId().equals("825162735603810316")) {
            if (event.getChannel().getId().equals("1005008757350223883")) {
                if (!event.getMember().getId().equals("869150235073601537")) {
                    String message = event.getMessage().getContentRaw();
                    String guild_name = event.getGuild().getName();
                    String Member = event.getMember().getUser().getName();
                    jda.getGuildById("955718792917426196").getTextChannelById("1005013502605406319").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                    jda.getGuildById("883760822143320065").getTextChannelById("1005015242708897893").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                }
            }
        }
        if (event.getGuild().getId().equals("955718792917426196")) {
            if (event.getChannel().getId().equals("1005013502605406319")) {
                if (!event.getMember().getId().equals("869150235073601537")) {
                    String message = event.getMessage().getContentRaw();
                    String guild_name = event.getGuild().getName();
                    String Member = event.getMember().getUser().getName();
                    jda.getGuildById("825162735603810316").getTextChannelById("1005008757350223883").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                    jda.getGuildById("883760822143320065").getTextChannelById("1005015242708897893").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                }
            }
        }
        if (event.getGuild().getId().equals("883760822143320065")) {
            if (event.getChannel().getId().equals("1005015242708897893")) {
                if (!event.getMember().getId().equals("869150235073601537")) {
                    String message = event.getMessage().getContentRaw();
                    String guild_name = event.getGuild().getName();
                    String Member = event.getMember().getUser().getName();
                    jda.getGuildById("825162735603810316").getTextChannelById("1005008757350223883").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                    jda.getGuildById("955718792917426196").getTextChannelById("1005013502605406319").sendMessage("[" + guild_name + "]" + Member + "->" + message).queue();
                }
            }
        }

    }
}
