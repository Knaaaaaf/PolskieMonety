# Polskie Monety — Fabric 1.21.11

Mod Fabric dodający trzy przedmioty:
- **Moneta 1ZŁ** — wartość 1 zł
- **Moneta 50ZŁ** — wartość 50 zł
- **Moneta 100ZŁ** — wartość 100 zł

W prawym górnym rogu ekranu wyświetla się `Kasa: X zł`. Kwota jest liczona z monet znajdujących się w głównym ekwipunku i drugiej ręce.

## Build lokalny
Wymagane Java 21 i Gradle:
```bash
gradle build
```
Gotowy plik JAR znajdzie się w `build/libs/`.

## GitHub Actions
Workflow `.github/workflows/build.yml` buduje mod po każdym pushu i udostępnia JAR jako artefakt w zakładce Actions.

## Instalacja
1. Zainstaluj Fabric Loader dla Minecraft 1.21.11 oraz Fabric API.
2. Pobierz `polskie-monety-1.0.0.jar` z artefaktów GitHub Actions.
3. Umieść JAR w folderze `mods`.
