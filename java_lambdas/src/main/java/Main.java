import music.Album;
import music.Artist;
import music.Track;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by barin.huseyin on 2/28/2016.
 *  examples from o reilly books "named java 8 lambdas"
 */
public class Main {


    //TODO: lets try the is prime or not?
    List<String> songs = Arrays.asList("get up pa", "it is a man world", "it is a man world", "like a sex machine");


    public static boolean isPrime(int number) {

        return IntStream.range(2, number)
                .noneMatch(index -> number % index == 0);

    }

    public static void main(String[] args) {

        new Main();


    }

    public Main() {

/*
        mainCollectorExample();
        List<Artist> artists = SampleData.getThreeArtists();
        System.out.println(artists.stream().filter(artist -> artist.isFrom("London"))
                .count());
        artists.stream().forEach(System.out::println);
*/
        refactoringLegacyCode1();
        System.out.println("\n\n");
        refactoringLegacyCode2();

        System.out.println("\n\n");
        refactoringLegacyCode3();


        System.out.println("\n\n");
        System.out.println(refactoringLegacyCode4().toString());

    }



    private void refactoringLegacyCode1() {

        Set<String> trackNamnes = new HashSet<>();

        getAlbumStream().forEach(album -> {
            album.getTracks()
                    .forEach(track -> {
                        if (track.getLength() > 60)
                            trackNamnes.add(track.getName());
                    });
        });

        trackNamnes.forEach(System.out::println);
    }


    private void refactoringLegacyCode2() {

        Set<String> trackNamnes = new HashSet<>();
        getAlbumStream().forEach(album -> {
            album.getTracks()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNamnes.add(name));
        });
        trackNamnes.forEach(System.out::println);
    }

    private void refactoringLegacyCode3() {

        Set<String> trackNamnes = new HashSet<>();


        //album --tracks on album - track    // we dont like nested loop or operation

        getAlbumStream()
                .flatMap(album->album.getTracks())
                .filter(track ->track.getLength()>60)
                .map(suitableTrack->suitableTrack.getName())
                .forEach(name->trackNamnes.add(name));

        trackNamnes.forEach(System.out::println);
    }

    private Set<String> refactoringLegacyCode4() {
        return getAlbumStream().flatMap(album->album.getTracks())  // much better...
                .filter(track->track.getLength()>60)
                .map(track1->track1.getName())
                .collect(toSet());
    }




    public Stream<Album> getAlbumStream() {

        Artist johnColtrane = new Artist("John Coltrane", "US");
        Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), asList(johnColtrane));

        return Stream.of(aLoveSupreme);


    }

    public Stream<String> getSongStream() {
        songs.stream().filter(s -> s.startsWith("get"));
        return songs.stream();
    }

    public void mainCollectorExample() {
        Stream songsStream = getSongStream().map(s -> s.toUpperCase());
        System.out.println(songsStream.count());

        Set<String> setSongs = getSongStream().filter(s -> s.startsWith("it")).collect(toSet());
        System.out.println("Set count:" + setSongs.size());
        songsStream.close();


        int sum = getSongStream().mapToInt(song -> song.toString().length()).sum();
        System.out.println("sum is :" + sum);


        //lets understand the difference between lazy and eager evaluation
        getSongStream().filter(song -> {
            System.out.println("coming song in lazy:" + song);
            return song.startsWith("al");
        });

        getSongStream().filter(song -> {
            System.out.println("coming song in eager:" + song);
            return song.startsWith("al");
        }).count();


        Stream<String> letters = Stream.of("b", "c", "d", null).filter(letter -> letter.isEmpty());


        // Optional<String> firstLetter = Optional.of(letters.findFirst());


    }


}
