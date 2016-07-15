package com.springapp.mvc.boots;

/**
 * Created by o.lutsevich on 8.7.16.
 */
public enum Boots {
    NEGAMAX("NegaMax", "4e53-be6c-ae2adaf91d47-2", "глубина прощёта 6", "60 мин", "/boot/negaMax"),
    SIMPLE_BOOT("Simple_Boot", "602C05B9706EFCD9B84D4AC9", "разработка нового бота", "60 мин", "/boot/simple_boot"),
    ALPHA_BETA("AlphaBeta", "4ec5ab7-36c1-4e3e-9db8", "будующее не за горами", "undefine", "#"),
    NEURAL_BOOT("Neural_Boot", "d4ec5ab79db8-e3944919a", "будующее не за горами", "undefine", "#"),
    ENTROPY_BOOT("Entropy_Boot", "d4ec5ab79db8-e3944919a", "будующее не за горами", "undefine", "#"),
    BOBIK("bobik","d4ec5ab7-36c1-4e3e-9db8-", "будующее не за горами", "undefine", "#");

    private String bootName;
    private String pass;
    private String description;
    private String timeStroke;
    private String url;

    Boots(String bootName, String pass, String description, String timeStroke, String url) {
        this.bootName = bootName;
        this.pass = pass;
        this.description = description;
        this.timeStroke = timeStroke;
        this.url = url;
    }

    public String getBootName() {
        return bootName;
    }

    public String getPass() {
        return pass;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getTimeStroke() {
        return timeStroke;
    }
}

