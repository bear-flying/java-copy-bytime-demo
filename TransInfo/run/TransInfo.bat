@echo off
FOR %%F IN (..\lib\*.jar) DO call :addcp %%F
goto extlibe
:addcp
SET CLASSPATH=%CLASSPATH%;%1
goto :eof
:extlibe
SET CLASSPATH=%CLASSPATH%;..\conf
set CLASSPATH=%CLASSPATH%;%LOCALCLASSPATH%

java  -Xms256m -Xmx512m -cp %CLASSPATH% com.founder.TransInfomation
pause