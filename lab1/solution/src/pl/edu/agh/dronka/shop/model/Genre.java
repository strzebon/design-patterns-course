package pl.edu.agh.dronka.shop.model;

public enum Genre {
    ROCK("rock"), HIPHOP("hip hop"), POP("pop"), JAZZ("jazz"), CLASSICAL("classical");

    private String displayName;

    Genre(String displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString(){
        return displayName;
    }

}
