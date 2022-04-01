package temp;

import java.io.*;
import java.nio.Buffer;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//IO怎么读文件呀～
public class BookmarkDemo extends HashMap implements Map{
    public static void main(String[] args) {
        try {
            FileOutputStream stream = new FileOutputStream("/usr/wohamon/Desktop/techlinks.html");
            FileInputStream inputStream = new FileInputStream("/usr/wohamon/Desktop/techlinks.html");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putAll(Map m) {
        super.putAll(m);
    }


}
