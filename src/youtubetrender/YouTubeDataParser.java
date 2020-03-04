/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParsingException;

/**
 *
 * @author lewi0146
 */
public class YouTubeDataParser {

    public List<YouTubeVideo> parse(String fileName) throws YouTubeDataParserException {

        List<YouTubeVideo> list = new ArrayList<>();
        JsonReader jsonReader = null;

        try {
            //read data
            jsonReader = Json.createReader(new FileInputStream(fileName));
        } catch (FileNotFoundException fnfe) {
            throw new YouTubeDataParserException("File not found: " + fileName);
        }
        
        JsonObject jobj = null;
        try
        {
            jobj = jsonReader.readObject();
        }
        catch (JsonParsingException jpe)
        {
            throw new YouTubeDataParserException("Parsing exception: " + jpe.getMessage());
        }

        // read the values of the item field
        JsonArray items = jobj.getJsonArray("items");

        for (int i = 0; i < items.size(); i++) {
            JsonObject video = items.getJsonObject(i);
            JsonObject snippet = video.getJsonObject("snippet");

            // parsing to Youtube video
            String channelId = snippet.getString("channelId");
            String channelTitle = snippet.getString("channelTitle");
            String publishAt = snippet.getString("publishedAt");
            String title = snippet.getString("title");
            String description = snippet.getString("description");

            // parsing statistics
            JsonObject statistics = video.getJsonObject("statistics");
            int viewCount = Integer.valueOf(statistics.getString("viewCount"));

            YouTubeVideo ytv = new YouTubeVideo(channelTitle, publishAt, title, description, viewCount, channelId);

            // add to the list 
            list.add(ytv);
        }

        return list;
    }

}
