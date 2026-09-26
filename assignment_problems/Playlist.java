import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    // Returns a defensive copy of the array containing only added songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return this.songCount;
    }
}