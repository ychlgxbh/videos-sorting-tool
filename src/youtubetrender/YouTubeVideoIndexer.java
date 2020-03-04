/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author lewi0146
 */
public class YouTubeVideoIndexer {

    public static List<String> notMeaningfulWord = new ArrayList<String>();
    private List<YouTubeVideo> items;
    private Map<String, YouTubeWordItem> words;

    public YouTubeVideoIndexer(List<YouTubeVideo> items) {
        this.items = items;
        // Articles
        notMeaningfulWord.add("the");
        notMeaningfulWord.add("a");
        notMeaningfulWord.add("an");
        //Conjunctions
        notMeaningfulWord.add("though");
        notMeaningfulWord.add("although");
        notMeaningfulWord.add("and");
        notMeaningfulWord.add("or");
        notMeaningfulWord.add("while");
        notMeaningfulWord.add("if");
        notMeaningfulWord.add("the");
        notMeaningfulWord.add("unless");
        notMeaningfulWord.add("until");
        notMeaningfulWord.add("then");
        notMeaningfulWord.add("whether");
        notMeaningfulWord.add("whereas");
        notMeaningfulWord.add("after");
        notMeaningfulWord.add("before");
        notMeaningfulWord.add("once");
        notMeaningfulWord.add("since");
        notMeaningfulWord.add("till");
        notMeaningfulWord.add("when");
        notMeaningfulWord.add("whenever");
        notMeaningfulWord.add("while");
        notMeaningfulWord.add("because");
        notMeaningfulWord.add("since");
        notMeaningfulWord.add("why");
        notMeaningfulWord.add("what");
        notMeaningfulWord.add("whatever");
        notMeaningfulWord.add("which");
        notMeaningfulWord.add("whichever");
        notMeaningfulWord.add("who");
        notMeaningfulWord.add("whoever");
        notMeaningfulWord.add("whom");
        notMeaningfulWord.add("whomever");
        notMeaningfulWord.add("whose");
        notMeaningfulWord.add("how");
        notMeaningfulWord.add("where");
        notMeaningfulWord.add("wherever");
        notMeaningfulWord.add("that");
        //Prepositions
        notMeaningfulWord.add("by");
        notMeaningfulWord.add("of");
        notMeaningfulWord.add("in");
        notMeaningfulWord.add("on");
        notMeaningfulWord.add("behind");
        notMeaningfulWord.add("to");
        notMeaningfulWord.add("with");
        notMeaningfulWord.add("about");
        notMeaningfulWord.add("between");
        notMeaningfulWord.add("for");
        //Others
        notMeaningfulWord.add("am");
        notMeaningfulWord.add("is");
        notMeaningfulWord.add("are");
        notMeaningfulWord.add("was");
        notMeaningfulWord.add("were");
        notMeaningfulWord.add("be");
        notMeaningfulWord.add("been");
        notMeaningfulWord.add("com");
        notMeaningfulWord.add("http");
        notMeaningfulWord.add("https");
        notMeaningfulWord.add("www");
        notMeaningfulWord.add("ly");


    }

    public void index(boolean removeNotMeaningfulWord) {

        words = new HashMap<>();

        for (int p = 0; p < items.size(); p++) {

            YouTubeVideo item = items.get(p);
            String text = item.getTitle() + " " + item.getDescription();
            // convert to lowercase
            text = convertToLowerCase(text);
            // remove punctuations
            text = eliminatePuntuations(text);

            if (text != null) {
                Scanner ws = new Scanner(text);
                while (ws.hasNext()) {
                    String w = ws.next();
                    if(removeNotMeaningfulWord == true && notMeaningfulWord.contains(w)){
                        continue;
                    }
                    if (words.containsKey(w)) {
                        YouTubeWordItem tempWI = words.get(w);
                        tempWI.add(item);
                        words.put(w, tempWI);

                    } else {

                        YouTubeWordItem tempWI = new YouTubeWordItem(w);
                        tempWI.add(item);
                        words.put(w, tempWI);
                    }
                }
            }
        }
    }

    public boolean containsWord(String word){
        boolean result = words.containsKey(word);
        return result;
    }
    public List<YouTubeWordItem> getSortedYouTubeWordItems() {

        List<YouTubeWordItem> items = new ArrayList<>(words.values());

        Collections.sort(items);

        return items;
    }

    public YouTubeWordItem getWordItem(String word) {
        return words.get(word);
    }

    public int getWordCount(String word) {
        return words.get(word).getCount();
    }

    public Set<YouTubeVideo> getWordVideos(String word) {
        return words.get(word).getVideos();
    }

    public void something() {

        List<YouTubeWordItem> items = this.getSortedYouTubeWordItems();

        for (int i = 0; i < 10; i++) {
            System.out.println((i) + ": " + items.get(i).getWord());

        }

        Scanner in = new Scanner(System.in);
        System.out.print("Enter id to list: ");
        int index = in.nextInt();

        YouTubeWordItem wi = items.get(index);

    }

    // convert all characters to lower case
    public String convertToLowerCase(String str) {
        String result = str.toLowerCase();
        return result;
    }

    // eliminate puntuations
    public String eliminatePuntuations(String str) {
        String result = str.replaceAll("\\p{Punct}", " ");
        result = result.replace("-", " ");
        result = result.replace("\n", " ");
        result = result.replace("[", " ");
        result = result.replace("]", " ");
        return result;
    }

    // add a new word to the list of not meaningful words
    public void addNotMeaningfulWords(String str) {
        if (!notMeaningfulWord.contains(str)) {
            notMeaningfulWord.add(str);
        } else {
            System.out.println(str + " is already in the list.");
        }
    }
}
