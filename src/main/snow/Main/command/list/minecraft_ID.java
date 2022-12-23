package Main.command.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Main.util.CommandOption.MINECRAFT_API;

public class minecraft_ID {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("mcsearch")) return;

            OptionMapping id = event.getOption(MINECRAFT_API);
            String Name = id.getAsString();

            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + Name);

            //Name---------------------------------------------------------------------------------
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int resp = connection.getResponseCode();

            if (resp != 200) {
                throw new RuntimeException("HttpResponseCode " + resp);
            } else {
                StringBuilder infor = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    infor.append(scanner.nextLine());
                }


                scanner.close();
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(String.valueOf(infor));

                String a = (String) json.get("id");

                URL url1 = new URL(" https://sessionserver.mojang.com/session/minecraft/profile/" + a);

                HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
                connection1.setRequestMethod("GET");
                connection1.connect();

                int r = connection1.getResponseCode();

                if (r != 200) {
                    throw new RuntimeException("HttpResponseCode " + r);
                } else {
                    StringBuilder i = new StringBuilder();
                    Scanner scanner1 = new Scanner(url1.openStream());

                    while (scanner1.hasNext()) {
                        i.append(scanner1.nextLine());
                    }
                    scanner1.close();

                    JSONParser parser1 = new JSONParser();
                    JSONObject data = (JSONObject) parser1.parse(String.valueOf(i));

                    Date date = new Date();
                    EmbedBuilder c = new EmbedBuilder()
                            .setTitle(data.get("name")+ " Minecraft Profiles")
                            .setDescription("User Name: " + data.get("name") + "\nUUID: " + data.get("id"))
                            .setFooter("NRTS" + " | " + date)
                            .setColor(new Color(0, 255, 255));

                    event.getChannel().sendMessageEmbeds(c.build()).queue();
                }
            }
            //Name---------------------------------------------------------------------------------

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
