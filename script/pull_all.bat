@echo off
pushd %~dp0

rem git���|�W�g������������ꍇ�A���ׂ�pull����

setlocal
FOR /F  %%i IN ('dir /b /ad') DO (
  cd %%i
  cd
  git pull
  cd ..
)

endlocal