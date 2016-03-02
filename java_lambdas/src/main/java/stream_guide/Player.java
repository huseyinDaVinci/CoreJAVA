package stream_guide;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by barin.huseyin on 3/2/2016.
 */
public class Player {


    String name;
    int jerseyNumber;
    String team;

    //private static Supplier<Stream<Player>> players=
    private static Supplier<Stream<Player>> playerStreamSupplier=()->Arrays.asList(
            new Player("deron","Brooklyn",8),
            new Player("joe","Miami",2),
            new Player("bosh","Miami",1),
            new Player("haslem","Miami",20),
            new Player("kobe","Lakers",24),
            new Player("garnett","Minnesota",5)).stream();

    public Player(String name, String team,int jerseyNumber) {
        this.name = name;
        this.team=team;
        this.jerseyNumber = jerseyNumber;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", team='" + team + '\'' +
                '}';
    }
    public static Stream<Player> getPlayers(){
        return playerStreamSupplier.get();
    }


}
