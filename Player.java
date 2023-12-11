public class Player {
    private String name;
    private Die die;
    public Player(String name, Die die) { //specific constructor (the only one we need)
        this.name = name;
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Die getDie() {
        return die;
    }

    public void setDie(Die die) {
        this.die = die;
    }
}
