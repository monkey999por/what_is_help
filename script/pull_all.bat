@echo off
pushd %~dp0

rem gitリポジトリが複数ある場合、すべてpullする

setlocal
FOR /F  %%i IN ('dir /b /ad') DO (
  cd %%i
  cd
  git pull
  cd ..
)

endlocal