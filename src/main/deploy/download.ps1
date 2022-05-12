echo @off
$ProgressPreference = 'SilentlyContinue'

echo "Downloading JDK..."
Invoke-RestMethod -Uri "https://download.oracle.com/java/18/latest/jdk-18_linux-aarch64_bin.tar.gz" -Method Get -ContentType "application/zip" -OutFile "./java.zip"

echo "Extracting..."
Expand-Archive -Path java.zip -DestinationPath .

Remove-Item './java.zip'

echo "Downloading server jar..."
Invoke-RestMethod -Uri "https://launcher.mojang.com/v1/objects/3737db93722a9e39eeada7c27e7aca28b144ffa7/server.jar" -Method Get -OutFile "./server.jar"

echo "Done."
$ProgressPreference = 'Continue'