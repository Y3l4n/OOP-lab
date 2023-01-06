package test.media;

import aims.media.book.Book;
import aims.media.disc.CompactDisc;
import aims.media.disc.DigitalVideoDisc;
import aims.track.Track;

public class MediaObjects {
        protected static DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95,
                        "Roger Allers",
                        87);
        protected static DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 19.95,
                        "George Lucas",
                        124);
        protected static DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99, "John Musker", 90);

        protected static Book book1 = new Book(4, "The Jungle Book", "Story", 19.95, "Kipling");
        protected static Book book2 = new Book(5, "The Lord of the Rings", "Story", 24.95, "Tolkien");
        protected static Book book3 = new Book(6, "Harry Potter", "Story", 29.95, "Rowling");
        protected static Book book4 = new Book(7, "Dragon Ball", "Story", 19.95, "Akira Toriyama");

        private static Track track1 = new Track("Track1", 10);
        private static Track track2 = new Track("Track2", 20);
        private static Track track3 = new Track("Track3", 30);
        private static Track track4 = new Track("Track4", 40);
        protected static CompactDisc cd1 = new CompactDisc(8, "Best Music of 2020", "Music", 25.95, "Jake", "TBA",
                        track1,
                        track2, track4);
        protected static CompactDisc cd2 = new CompactDisc(9, "Best Music of 2022", "Music", 29.95, "John Muller",
                        "TBA",
                        track1, track3);
}
