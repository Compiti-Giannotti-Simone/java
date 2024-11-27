package it.giannotti;

public abstract class Monster {
    private int hp,atk;

    public Monster() {
        this.hp = 500;
        this.atk = 100 + Math.round((float)Math.random()*100);;
    }

    public String attack(Monster m) {
        String damage;
        if(Math.random() < this.getCrit()) { 
            damage = this.atk*2 + " danni, con un colpo critico (" + m.hp + " -> " + (m.hp-atk*2) + ")";
            m.hp = m.hp - (this.atk * 2);
        }
        else { 
            damage = this.atk + " danni (" + m.hp + " -> " + (m.hp-atk) + ")";
            m.hp = m.hp - this.atk;
        }
        return damage;
    }

    public abstract String getType();
    public abstract double getCrit();

    @Override
    public String toString() {
        return "Monster type= " + getType() + ", hp= " + hp + ", atk= " + atk + ", crit chance= " + getCrit()*100 + "%";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }


}
