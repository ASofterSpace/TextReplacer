@echo off

REM cd /D %~dp0

java -classpath "%~dp0\bin" -Xms16m -Xmx1024m com.asofterspace.textReplacer.Main %*

pause