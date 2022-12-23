package Main.event;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class onready extends ListenerAdapter {

    public static int s;
    public static int m;
    public static int h;
    public static int d;


    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("機械人由雪球製作");
        System.out.println("bot is made by snowball");
        System.out.println("Copyright © 2022 NRTS SERVER");
        System.out.println("版權所有 © 2022 NRTS SERVER");
        s = 0;
        m = 0;
        h = 0;
        d = 0;
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        if (!threadPool.isShutdown())
            threadPool.shutdown();
        threadPool = Executors.newScheduledThreadPool(1);
        threadPool.scheduleWithFixedDelay(() -> {
            s += 1;
            if (s == 60) {
                s = 0;
                m++;
                if (m == 60) {
                    m = 0;
                    h++;
                    if (h == 24) {
                        h = 0;
                        d++;
                    }
                }
            }

        }, 0, 1, TimeUnit.SECONDS);
    }
}
