package ru.netology.domain;

// Класс который  описывает параметры фильма
public class PosterMovie {
    private int id;       // поле
    private String name;  // поле
    private String genre; // поле

    // Конструктор
    public PosterMovie(int id, String name, String genre) {
        this.id = id;        // Присвоение полю значений из параметров конструктора
        this.name = name;    // Присвоение полю значений из параметров конструктора
        this.genre = genre;  // Присвоение полю значений из параметров конструктора
    }


}
