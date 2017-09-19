import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**Do things.
 *
 * @author zacha
 *
 */
public class anythingYouLike
{
    /**THe main method.
     *
     * @param args asasdfasdfasdf.
     */
    public static void main(final String[] args) {
        System.out.println(countWords(urlToString("http://tgftp.nws.noaa.gov/data/"
                + "raw/fz/fzus53.klot.srf.lot.txt")));
        System.out.println(countUniqueWords("hello, my name is asdf. Hello again. Hi.", "hello"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    /**COunts the words in a string.
     *
     * @param str str to hold things
     * @return long
     */
    public static long countWords(final String str) {
        long count = 0;
        char[] myCharArray = str.toCharArray();
        char curChar = ' ';
        for (int i = 0; i < myCharArray.length; i++) {
            curChar = myCharArray[i];
            if (curChar == ' ') {
                count++;
            }
        }
        count++;
        return count;
    }

    /**COunts the unique words in a string.
    *
    * @param str str to hold things
    * @param str str unique word
    * @return long
    */
   public static long countUniqueWords(String text, String word) {
       text = text.toLowerCase();
       word = word.toLowerCase();
       long count = 0;
       int locationOf = -1;
       while(true) {
           locationOf = text.indexOf(word);
           if(locationOf != -1) {
               text = text.substring(locationOf + word.length());
               count++;
           }
           else {
               break;
           }
       }
       return count;
   }
}
