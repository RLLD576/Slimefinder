@echo off
echo Enter seed: 
SET /P seed=""
java -jar slimefinder.jar %seed% -h
:a
echo Enter mode: 
SET /P mode=""
java -jar slimefinder.jar %seed% %mode%
goto :a
