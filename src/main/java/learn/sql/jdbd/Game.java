package learn.sql.jdbd;

import java.util.Objects;

class Game{
    String name;
    String type;
    Integer player;

    public Game(String name, String type, Integer player) {
        this.name = name;
        this.type = type;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name) && Objects.equals(type, game.type) && Objects.equals(player, game.player);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", player=" + player +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, player);
    }
}
