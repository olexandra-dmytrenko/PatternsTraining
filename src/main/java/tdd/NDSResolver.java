package tdd;

import lombok.Getter;
import lombok.SneakyThrows;

/**
 * Created by olexandra on 11/6/17.
 */
public class NDSResolver {
    @Getter
    private double nds;
    private static NDSResolver ourInstance = new NDSResolver();

    public static NDSResolver getInstance() {
        return ourInstance;
    }
    @SneakyThrows
    private NDSResolver(){
        initNDS();
    }

    private void initNDS() throws InterruptedException {
        Thread.sleep(4000);
        nds = 20;
    }
}
