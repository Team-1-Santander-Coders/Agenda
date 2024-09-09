@echo off
set SRC_DIR=src
set OUT_DIR=out

REM
if not exist %OUT_DIR% (
    mkdir %OUT_DIR%
)

REM
dir /b /s %SRC_DIR%\*.java > sources.txt

REM
for /f %%i in (sources.txt) do set found=true

if defined found (
    javac -d %OUT_DIR% @sources.txt
    echo Projeto compilado com sucesso!

    REM
    java -cp %OUT_DIR% com.team1.AgendaApp
) else (
    echo Nenhum arquivo .java encontrado.
)

REM
del sources.txt
