package Main.command.list;

import com.sun.security.auth.login.ConfigFile;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.ObjectInputFilter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.event.onready.d;

public class lottery {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Logger LOGGER = LoggerFactory.getLogger(lottery.class);
    private static final HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        try {
            if (!event.getName().equals("lottery")) return;
                try {
                    final File dbfile = new File("lottery_db.db");

                    if (!dbfile.exists()) {
                        if (!dbfile.createNewFile()) {
                            LOGGER.info("Created db file");
                        } else {
                            LOGGER.info("Could not create db file");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                config.setJdbcUrl("jdbc:sqlite:database.db");
                config.setConnectionTestQuery("SELECT 1");
                config.addDataSourceProperty("cachePrepStmts", "true");
                config.addDataSourceProperty("prepStmtCacheSize", "250");
                config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
                ds = new HikariDataSource(config);

                try (final Statement statement = getConnection().createStatement()) {
                    final String defaultPrefix = dotenv.get("./prefix");

                    statement.execute("CREATE TABLE IF NOT EXISTS guild_settings (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "guild_id VARCHAR(20) NOT NULL," +
                            "prefix VARCHAR(255) NOT NULL DEFAULT '" + defaultPrefix + "'" +
                            ");");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public lottery() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
