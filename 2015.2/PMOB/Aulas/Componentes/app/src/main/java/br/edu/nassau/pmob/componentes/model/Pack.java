package br.edu.nassau.pmob.componentes.model;

/**
 * Created by dhiego on 22/09/15.
 */
public class Pack {

    private String name;
    private String trackNumber;

    public Pack(){

    }

    public Pack(String name, String trackNumber){
        this.name = name;
        this.trackNumber = trackNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }
}
