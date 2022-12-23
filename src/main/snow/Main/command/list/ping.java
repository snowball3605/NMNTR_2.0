package Main.command.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ping {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("ping")) return;
            event.getInteraction().deferReply().setContent(event.getJDA().getGatewayPing()+ "ms").queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
