package ru.netology.manager;

import ru.netology.domain.PosterMovie;

public class MovieManager {
    private int limit = 5;              //  Поле с названием переменой лимит
    private PosterMovie[] movies = new PosterMovie[0];    // Масcив всех фильмов  movie[]


    // Конструктор = 1
    public MovieManager() {
    }

    // Конструктор = 2
    public MovieManager(int tlimit) {  //  Параметры конструктора
        this.limit = tlimit; // Присвоение полю лимит (слева) значение переменой лимит из параметра конструктора (справа)

    }


    public PosterMovie[] findAll() {    // Метод возвращающий все фильмы
        return movies;                  // Вывод всех фильмов в порядке добавления


    }

    public int getLimit() {             // Возвращает текущее значение лимита
        return limit;
    }

    //        (Тип данных (ПРОБЕЛ) Имя переменной)
    public void save(PosterMovie newMovie) { // Метод добавление нового Фильма
        PosterMovie[] tmp = new PosterMovie[movies.length + 1]; // Массив tmp[]
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];        // Подставляем временную переменную в массив для подсчёта обращения ячейки массива по индексу
        }
        tmp[tmp.length - 1] = newMovie; // Присвоение в последнюю ячейку временного массива tmp значение из переменной newMovie в параметры метода save
        movies = tmp;

    }

    public PosterMovie[] findLast() {       // Возрашает массив в обратном порядке
        int resultLength = 0;                // Временная переменная
        if (limit >= movies.length) {        // Если limit  равен  длине массива movie
            resultLength = movies.length;    // То итоговый limit равен длине массива movies
        } else {
            resultLength = getLimit();       // Иначе итоговый лимит равен значению из поля лимит

        }
        PosterMovie[] result = new PosterMovie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = findAll()[movies.length - 1 - i];
        }
        return result;
    }


}





