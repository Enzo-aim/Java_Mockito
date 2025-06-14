package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager();     // Объект менеджера с лимитом по умолчанию

    MovieManager manager2 = new MovieManager(3); // Объект менеджера с новым лимитом

    PosterMovie movie1 = new PosterMovie(2, "Бладшот", "Боевик");
    PosterMovie movie2 = new PosterMovie(22, "Вперед", "Мультфильм");
    PosterMovie movie3 = new PosterMovie(30, "Отель Белград", "Комедия");
    PosterMovie movie4 = new PosterMovie(5, "Джентельмены", "Боевик");
    PosterMovie movie5 = new PosterMovie(65, "Человек-невидимка", "Ужасы");
    PosterMovie movie6 = new PosterMovie(45, "Тролли", "Мультфильм");
    PosterMovie movie7 = new PosterMovie(72, "Номер один", "Комедия");


    @BeforeEach    // Выполнять перед каждым тестом
    public void setup() {
        manager.save(movie1);   // Добавление фильма в массив movie хранящийся у менеджера
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);
    }

    @BeforeEach     // Для объекта менеджера с лимитом
    public void setup2() {
        manager2.save(movie1);
        manager2.save(movie2);
        manager2.save(movie3);
        manager2.save(movie4);
        manager2.save(movie5);
        manager2.save(movie6);
        manager2.save(movie7);

    }

    @Test  // Тест на добавление нового Фильма
    public void addMovies() {
        PosterMovie posterMovie = new PosterMovie(55, "Король Артур", "Боевик");
        manager.save(posterMovie); // Вызываем у обьекта менеджер метод SAVE для добавление нового фильма в конец списка
        PosterMovie[] expected = {
                movie1,
                movie2,
                movie3,
                movie4,
                movie5,
                movie6,
                movie7,
                posterMovie
        };
        PosterMovie[] actual = manager.findAll();  // У обьекта менеджер вызов метода (findAll) для получения массива всех фильмов из поля Movies
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReverseAllMovies() {    // Должен перевернуть все фильмы с изменённым лимитом по умолчанию
        PosterMovie[] expected = {
                movie5, movie4, movie3, movie2, movie1
        };
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldReverseAllMoviesChangeLimit() {  // Должен перевернуть все фильмы с изменённым лимитом на 3
        PosterMovie[] expected = {
                movie3, movie2, movie1
        };
        PosterMovie[] actual = manager2.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseWhenLimitEcMoviesLength() {  // Должен перевернуть где (limit) равен длине массива фильмов
        MovieManager movieManager = new MovieManager();
        movieManager.save(movie1);
        movieManager.save(movie2);
        movieManager.save(movie3);
        movieManager.save(movie4);
        movieManager.save(movie5);
        PosterMovie[] expected = {
                movie5,
                movie4,
                movie3,
                movie2,
                movie1};
        PosterMovie[] actual = movieManager.findLast();
        Assertions.assertArrayEquals(expected, actual);


    }
}

