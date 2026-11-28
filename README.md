# Bit Casino

Bit Casino is a Java Swing desktop prototype built by a team for Gonzaga University's CPSC 224 course. It brings together a player setup screen, shared player and session classes, and casino-themed minigame prototypes that use virtual credits and tokens.

## What you can try

| Component | Current state |
| --- | --- |
| [Main window](src/menu/) | Splash screen and player-name entry for up to four players. The lobby is still in development. |
| [Plinko](src/games/plinko/) | Standalone Swing demo with a peg board and animated ball movement. |
| [Roulette](src/games/roulette/) | Standalone Swing panel preview with separate betting and game classes. |
| [Slots](src/games/slots/) | Game logic, artwork, and JUnit test source. |

## Run locally

Use JDK 17 or newer and run these PowerShell commands from the repository root. The compile step skips JUnit test files, which require a separate dependency.

```powershell
$sources = Get-ChildItem -Path src -Recurse -Filter *.java -File |
    Where-Object { $_.Name -notlike '*Test.java' } |
    Select-Object -ExpandProperty FullName
javac -d out $sources
java -cp "out;src" menu.CasinoFrame
```

To launch the standalone demos after compiling:

```powershell
java -cp "out;src" Main
java -cp "out;src" games.roulette.RoulettePreview
```

The classpath includes `src` so the roulette preview can load its artwork. On macOS or Linux, use `out:src` as the runtime classpath.

## Team credits

This project was a product of the CPSC 224 team. See the [commit history](https://github.com/bradencalme-maker/KingsOfCPSC224/commits/main/) for contributions across the team.
