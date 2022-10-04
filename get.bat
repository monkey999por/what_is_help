@echo off

rem "パスが通ってるファイルのフォルダパスをクリップボードにコピーする"

if "%1"=="" (
	echo パスが通ってるファイルのフォルダパスをクリップボードにコピーする
	exit /B 0
)

where /Q %1

if "%ERRORLEVEL%"=="0" (
	setlocal ENABLEDELAYEDEXPANSION
		for /F "delims=" %%i in ('where %1') do (
			echo %%~dpi
			set /P <NUL="%%~dpi" | clip
		)
	 endlocal
) else (
	echo ファイルが見つかりません
)
