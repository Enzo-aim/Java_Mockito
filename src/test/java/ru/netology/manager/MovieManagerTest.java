package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovie;

class MovieManagerTest {
    MovieManager manager;

    PosterMovie movie1 = new PosterMovie(2, "Бладшот", "Боевик");
    PosterMovie movie2 = new PosterMovie(22, "Вперед", "Мультфильм");
    PosterMovie movie3 = new PosterMovie(30, "Отель Белград", "Комедия");
    PosterMovie movie4 = new PosterMovie(5, "Джентельмены", "Боевик");
    PosterMovie movie5 = new PosterMovie(65, "Человек-невидимка", "Ужасы");
    PosterMovie movie6 = new PosterMovie(45, "Тролли", "Мультфильм");
    PosterMovie movie7 = new PosterMovie(72, "Номер один", "Комедия");


    @Test  // Тест на добавление нового Фильма
    public void addMovies() {
        manager = new MovieManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);

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
    public void shouldReverseWhenLimitEcMoviesLength() {  // Должен вернуть где (limit) (5) равен длине массива фильмов (5)
        manager = new MovieManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        PosterMovie[] expected = {
                movie5,
                movie4,
                movie3,
                movie2,
                movie1};
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldReverseWhenLimitEcMoviesLengthDown() {  // Должен вернуть фильмы в обратном порядке с лимитом по умолчанию (5), из (4) фильмов
        manager = new MovieManager();

        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        PosterMovie[] expected = {movie4, movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseWhenLimitEcMoviesLengthUp() {  // Должен вернуть фильмы в обратном порядке с лимитом по умолчанию (5), из (6) фильмов
        manager = new MovieManager();
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        PosterMovie[] expected = {movie5, movie4, movie3, movie2, movie1};
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReverseAllMoviesChangeLimit() {  // Должен вернуть  где изменёный (limit) (3) равен длине массива фильмов (3)
        manager = new MovieManager(3);
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);

        PosterMovie[] expected = {
                movie3, movie2, movie1
        };
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mustReturnMoviesOverThanTheChangedLimit() { // Должен вернуть фильмы в обратном порядке с изменённым лимитом (4), из (7) фильмов
        manager = new MovieManager(4);
        manager.save(movie1);
        manager.save(movie2);
        manager.save(movie3);
        manager.save(movie4);
        manager.save(movie5);
        manager.save(movie6);
        manager.save(movie7);
        PosterMovie[] expected = {
                movie7, movie6, movie5, movie4
        };
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mustReturnMoviesLessThanTheChangedLimit() { // Должен вернуть фильмы в обратном порядке с изменённым лимитом (4), из (2) фильмов
        manager = new MovieManager(4);
        manager.save(movie1);
        manager.save(movie2);
        PosterMovie[] expected = {
                movie2, movie1
        };
        PosterMovie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}




