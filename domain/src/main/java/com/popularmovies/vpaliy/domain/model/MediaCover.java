package com.popularmovies.vpaliy.domain.model;


import android.text.format.DateUtils;
import android.text.format.Time;

import java.util.List;
import java.util.Locale;

public class MediaCover {

    private String mediaId;
    private double averageRate;
    private boolean isFavorite;
    private boolean isWatched;
    private boolean isMustWatch;
    private String releaseYear;
    private String movieTitle;
    private String posterPath;
    private String duration;
    private String releaseDate;
    private String mainBackdrop;
    private List<String> genres;
    private List<String> backdrops;
    private boolean isTvShow;

    public String getAverageRate() {
        return String.format(Locale.US,"%.1f",averageRate);
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<String> getBackdrops() {
        return backdrops;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public boolean isMustWatch() {
        return isMustWatch;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setMustWatch(boolean mustWatch) {
        isMustWatch = mustWatch;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getDuration() {
        return duration;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public double getAverageVote(){
        return averageRate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setTvShow(boolean tvShow) {
        isTvShow = tvShow;
    }

    public boolean isTvShow() {
        return isTvShow;
    }

    public void setMainBackdrop(String mainBackdrop) {
        this.mainBackdrop = mainBackdrop;
    }

    public String getMainBackdrop() {
        return mainBackdrop!=null?mainBackdrop:posterPath;
    }

    public String getFormattedDate(){
        Time time = new Time();
        time.parse3339(getReleaseDate());
        return DateUtils.getRelativeTimeSpanString(time.toMillis(false),
                System.currentTimeMillis(), DateUtils.HOUR_IN_MILLIS,
                DateUtils.FORMAT_ABBREV_ALL).toString();
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public void setBackdrops(List<String> backdrops) {
        this.backdrops = backdrops;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
