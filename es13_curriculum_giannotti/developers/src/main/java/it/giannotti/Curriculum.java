package it.giannotti;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
    private int npages;
    private String school;
    private List<String> languages;

    public Curriculum(int npages, String school) {
        this.npages = npages;
        this.school = school;
        languages = new ArrayList<>();
    }

    public int getNpages() {
        return npages;
    }

    public void setNpages(int npages) {
        this.npages = npages;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean addLanguage(String language) {
        if (languages.size() < 6 && languages.indexOf(language) == -1) {
            languages.add(language);
            return true;
        } else {
            return false;
        }
    }

    public int getValue() {
        int n_languages = languages.size();
        if (n_languages > 4)
            return 3;
        else if (n_languages > 1)
            return 2;
        else
            return 1;
    }

    @Override
    public String toString() {
        return npages + " pages - " + school + " - " + languages.toString() + "]";
    }

    // @Override
    // public boolean equals(Curriculum c) {
    // if(this.school == c.school && this.languages.size() == c.languages.size())
    // return true;
    // return false;
    // }

}
