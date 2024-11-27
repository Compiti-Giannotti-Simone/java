package it.giannotti;

public class Player {
    private String name,surname;
    private Monster monster;
    
    public Player(String name, String surname, Monster monster) {
        this.name = name;
        this.surname = surname;
        this.monster = monster;
    }

    public ChallengeResults challenge(Player p) throws Exception {
        ChallengeResults c = new ChallengeResults(this,p);
        c.getAttacks().add("--------------------------------------------------------------------------------------------");
        c.getAttacks().add("Battaglia tra " + ConsoleColors.BLUE + this.getFullName() + ConsoleColors.WHITE + " e " + ConsoleColors.RED + p.getFullName() + ": ");
        c.getAttacks().add(ConsoleColors.BLUE + this.toString());
        c.getAttacks().add(ConsoleColors.RED + p.toString());
        if (this.monster.getHp() <= 0 || p.monster.getHp() <= 0) {
            throw new AlreadyDiedException("Uno dei mostri è già morto");
        }
        while(true) {
            c.getAttacks().add(ConsoleColors.BLUE + this.getFullName() + ConsoleColors.WHITE + " attacca " + ConsoleColors.RED + p.getFullName() + ConsoleColors.WHITE + " per " + this.monster.attack(p.monster));
            if(p.monster.getHp() < 0) {
                c.setWinner(1);
                c.getAttacks().add(ConsoleColors.BLUE + this.getFullName() + ConsoleColors.WHITE + " vince la battaglia");
                break;
            }
            c.getAttacks().add(ConsoleColors.RED + p.getFullName() + ConsoleColors.WHITE + " attacca " + ConsoleColors.BLUE + this.getFullName() + ConsoleColors.WHITE + " per " + p.monster.attack(this.monster));
            if(this.monster.getHp() < 0) {
                c.setWinner(2);
                c.getAttacks().add(ConsoleColors.RED + p.getFullName() + ConsoleColors.WHITE + " vince la battaglia");
                break;
            }
        }
        c.getAttacks().add("--------------------------------------------------------------------------------------------");
        return c;
    }

    @Override
    public String toString() {
        return "Player " + name + " " + surname + ": " + monster.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Monster getMonster() {
        return monster;
    }

    
}
