package stream_guide;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by barin.huseyin on 3/2/2016.
 */
public class StreamKeyPoints {


    public StreamKeyPoints() {


        //Lets start with simple examples
        Stream<String> players = Stream.of("deron8", "joe2", "iverson6", "garnett5", "wade2");
        players.filter(player -> player.endsWith("2")).forEach(System.out::println);

        //lets make some converting operations but we will get an exception here since this stream is used already.


        //lets create a stream supplier for reusing purposes.
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("deron8", "joe2", "iverson6", "garnett5", "wade2");
        streamSupplier.get()
                .map(s -> s.substring(s.length() - 1, s.length()))
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(System.out::println);

        streamSupplier.get().filter(player -> player.endsWith("2")).forEach(System.out::println);

        //a little dive in with flatmap, collect, reduce operators
        List<Player> myFavoPlayerList = Player.getPlayers()
                .filter(player -> player.team.equalsIgnoreCase("Brooklyn") || player.team.equalsIgnoreCase("miami"))
                .collect(Collectors.toList());


        System.out.println(myFavoPlayerList.toString());
        Set<Player> myPlayerSet = Player.getPlayers()
                .map(player -> {
                    player.name = player.name.toUpperCase();
                    return player;
                })
                .collect(Collectors.toSet());
        System.out.println(myPlayerSet.toString() + "\n\n");


        //lets making some grouping operations here.
        Map<String, List<Player>> playersTeamMap = Player.getPlayers().collect(Collectors.groupingBy(player -> player.team));   //like a declarative programming style (SQL programming))
        playersTeamMap.forEach((team, player) -> System.out.println(String.format("Player: %s  - Team: %s ", player, team)));


        IntSummaryStatistics playerStatictics = Player.getPlayers()
                .collect(Collectors.summarizingInt(player -> player.jerseyNumber));


        System.out.println(playerStatictics);



        Stream.of("nabar","iyidir","moruk").peek(System.out::println);

        Stream.of("nabar","iyidir","moruk").peek(System.out::println)
                .forEach(System.out::print);




    }

    public static void main(String[] args) {

        new StreamKeyPoints();
    }


}
