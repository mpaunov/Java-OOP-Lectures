package desingPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private Map<String, Item> registry;

    public Register() {
        registry = new HashMap<>();
        loadTypes();
    }

    private void loadTypes() {
        Book book = new Book("Lord of the rings", "lotr//img", 29.99);
        book.setAuthor("J. R. R. Tolkien");

        registry.put("Book", book);

        Music music = new Music("Slayer", "slayer//img", 9.99);
        music.setDuration(3.14);

        registry.put("Music", music);

    }

    public Item getItem(String type) {
        try {
            return registry.get(type).clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }


}
