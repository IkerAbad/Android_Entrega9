# Android_Entrega9

Entrega de Android del ciclo de DAM (abril de 2023). Es una app en Kotlin para guardar canciones en una base de datos local con Room: se añaden con su título, grupo o cantante, álbum y año, y se muestran en una lista.

## Qué hay

- `AddSongFragment` y `SongsListFragment`, conectados con el componente de navegación (`res/navigation/navigation.xml`).
- `Song`, `SongDao` y `SongDatabase` con Room (versión 2.5.1). El DAO tiene consultas para listar, ordenar por año, buscar por título y por año, actualizar y borrar.
- `SongsViewModel` conecta la base de datos con las pantallas.

## Cómo abrirlo

Abre la carpeta en Android Studio, deja que Gradle sincronice y ejecútala en un emulador o en un móvil (`minSdk 21`, `compileSdk 33`). No la he compilado desde el entorno en el que escribí este README.

---

# Android_Entrega9 (English)

Android hand-in from my DAM vocational course (April 2023). A Kotlin app that stores songs in a local Room database: you add them with a title, band or singer, album and year, and they are shown in a list.

## What's inside

- `AddSongFragment` and `SongsListFragment`, connected with Jetpack Navigation (`res/navigation/navigation.xml`).
- `Song`, `SongDao` and `SongDatabase` using Room (version 2.5.1). The DAO has queries to list, sort by year, search by title and by year, update and delete.
- `SongsViewModel` connects the database to the screens.

## Opening it

Open the folder in Android Studio, let Gradle sync and run it on an emulator or a phone (`minSdk 21`, `compileSdk 33`). I have not compiled it in the environment where I wrote this README.
