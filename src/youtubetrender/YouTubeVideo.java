/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import javax.json.JsonObject;

/**
 *
 * @author lewi0146
 */
public class YouTubeVideo {

    private String channel;
    private String date;
    private String title;
    private String description;
    private int viewCount;
    private String id;

    public YouTubeVideo(String channel, String date, String title, String description, int viewCount, String id) {
        this.channel = channel;
        this.date = date;
        this.title = title;
        this.description = description;
        this.viewCount = viewCount;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return channel + ": " + title;
    }

}
