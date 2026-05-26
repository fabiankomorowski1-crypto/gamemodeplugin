# GamemodePlugin

Plugin do Minecrafta Paper 26.1.2 umożliwiający zmianę trybu gry za pomocą komendy.

## Instalacja

1. Sklonuj repozytorium
2. Uruchom `mvn clean package`
3. Skopiuj wygenerowany JAR z folderu `target/` do folderu `plugins/` serwera
4. Uruchom serwer

## Użycie

### Komenda
```
/gamemode <0|1|2|3>
```

### Tryby gry
- `0` - Survival
- `1` - Creative
- `2` - Adventure
- `3` - Spectator

### Przykład
```
/gamemode 1
```
Zmienia Twój tryb gry na Creative.

## Uprawnienia
- `gamemode.use` - Pozwala na użycie komendy `/gamemode`

## Alias
- `/gm` - Skrót do `/gamemode`

## Autor
fabian
