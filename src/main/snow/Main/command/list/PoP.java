package Main.command.list;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class PoP {

    record Person(String store, String ans) {}

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("turtle")) return;
        try {
            JsonObject Obj = new JsonObject();
            //=======================================
            Person jsonString = new Person("1", "男孩儿在几年前和父亲一起遭受过海难，在海上漂流了一阵子，甚至差点饿死。在最危急的时候，父亲做了一碗海龟汤给男子，欺骗男子其中的海龟肉是从海中猎获的。这碗救了男子一命的海龟汤，美好的滋味让他永远无法忘怀，获救后的某天得知这家餐馆里有提供海龟汤，便决定前来回味海龟汤的味道。然而，喝了几口后却发现口中的汤与记忆中的味道完全不同，就在此时才意识到一件事：原来遇难时所喝的海龟汤，其实是他那后来衰弱而死的父亲，当时为了让男子有机会活命下去而取自己身上的肉煮汤供男子食用的");
            String path = "Discord_bot\\src\\main\\snow\\Main\\.JSON";
            try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                Gson gson = new Gson();
                String json = gson.toJson(jsonString);
                out.write(json);
            }
        } catch (JsonMappingException ex) {
            ex.printStackTrace();
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
        }
