echo @off
$ProgressPreference = 'SilentlyContinue'

echo "Downloading server jar..."
Invoke-RestMethod -Uri "https://launcher.mojang.com/v1/objects/3737db93722a9e39eeada7c27e7aca28b144ffa7/server.jar" -Method Get -OutFile "./server.jar"

echo "Done."
$ProgressPreference = 'Continue'